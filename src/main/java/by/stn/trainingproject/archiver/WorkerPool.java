package by.stn.trainingproject.archiver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class WorkerPool {
    public static final String REGULAR_FILE = "test.pdf";
    private static final String ARCHIVED_FILE = "test";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String INPUT_FILE = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + REGULAR_FILE;
    private static final String OUTPUT_FILE_FORMAT = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE + "%d.zip";
    private Locker locker;
    private Signaler signaler;
    private ExecutorService service;
    private static WorkerPool _instance = null;

    private WorkerPool() {
        service = Executors.newFixedThreadPool(3);
        locker = new Locker();
        signaler = new Signaler();
    }

    public synchronized static WorkerPool getInstance() {
        if (_instance == null)
            _instance = new WorkerPool();
        return _instance;
    }

    public void start(final int fileNum, final Callback callback) {
        final Object lock = locker.getLock(fileNum);
        synchronized (lock) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Archiver.zipFile(new File(INPUT_FILE), String.format(OUTPUT_FILE_FORMAT, fileNum), new Archiver.Callback() {
                            @Override
                            public void statusUpdate(long status) {
                                callback.update(status);
                                synchronized (lock) {
                                    if (signaler.hasToStop(fileNum)) {
                                        {
                                            try {
                                                lock.wait();
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
    }

    public void suspend(int fileNum) {
        Object lock = locker.getLock(fileNum);
        synchronized (lock) {
            signaler.switchSignal(fileNum);
        }
    }

    public void resume(int fileNum) {
        Object lock = locker.getLock(fileNum);
        synchronized (lock) {
            signaler.switchSignal(fileNum);
            lock.notify();
        }
    }

    private static class Locker {
        private final Map<Integer, Object> locks;

        public Locker() {
            this.locks = new HashMap<>();
        }

        public Object getLock(int fileNum) {
            Object lock = locks.get(fileNum);
            if (lock == null) {
                lock = new Object();
                locks.put(fileNum, lock);
            }
            return lock;
        }
    }

    private static class Signaler {
        private final Map<Integer, Boolean> suspend;

        public Signaler() {
            this.suspend = new HashMap<>();
        }

        public boolean hasToStop(int fileNum) {
            Boolean flag = suspend.get(fileNum);
            if (flag == null) {
                flag = false;
                suspend.put(fileNum, flag);
            }
            return flag;
        }

        public void switchSignal(int fileNum) {
            boolean flag = hasToStop(fileNum);
            suspend.put(fileNum, !flag);
        }
    }

    public interface Callback {
        void update(long status);
    }
}