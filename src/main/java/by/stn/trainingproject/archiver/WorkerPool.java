package by.stn.trainingproject.archiver;

import java.util.concurrent.ExecutorService;

public class WorkerPool {

    private static final String FS = System.getProperty("file.separator");
    private static final String PATH = System.getProperty("user.dir");
    public static final String REGULAR_FILE = "test.pdf";
    private static final String INPUT_FILE = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + REGULAR_FILE;
    private static final String ARCHIVED_FILE = "test";
    private static final String OUTPUT_FILE_FORMAT = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE + "%d.zip";

    // Wrapper Pattern
    private ExecutorService service;

    public void start(){

    }

    public void suspend() {

    }

    public void resume() {

    }

//    public interface Archiv
}
