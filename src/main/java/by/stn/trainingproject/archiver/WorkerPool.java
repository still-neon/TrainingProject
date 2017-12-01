package by.stn.trainingproject.archiver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerPool {

    private static final String FS = System.getProperty("file.separator");
    private static final String PATH = System.getProperty("user.dir");
    public static final String REGULAR_FILE = "test.pdf";
    private static final String INPUT_FILE = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + REGULAR_FILE;
    private static final String ARCHIVED_FILE = "test";
    public static final String OUTPUT_FILE_FORMAT = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE + "%d.zip";
    Object lock = this;
    private boolean suspendFlag;


    // Wrapper Pattern
    private ExecutorService service = Executors.newFixedThreadPool(3);


    public void start(final JLabel label, final String output_file){
        //suspendFlag = false;

        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Archiver.zipFile(new File(INPUT_FILE), output_file, new Archiver.Callback() {
                        @Override
                        public void statusUpdate(long status) {
                            label.setText("File is " + status + "% zipped");
                            /*
                            synchronized (lock) {
                                // TODO create suspend() method
                                while (suspendFlag) {
                                    suspend();
                                }
                            }*/
                        }
                    });
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //changeState(UICreator.ArchiveAction.ComponentsState.FINISHED);
                label.setText("File " + REGULAR_FILE + " is zipped");
            }
        });

    }

    public void suspend() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void resume() {
        //suspendFlag = false;
        lock.notify();

    }


//    public interface Archiv
}

