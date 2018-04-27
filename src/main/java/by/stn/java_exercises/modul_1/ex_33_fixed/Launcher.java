package by.stn.java_exercises.modul_1.ex_33_fixed;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class Launcher {
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String TARGET_FOLDER = PATH + FS + "src" + FS + "main" + FS + "resources" + FS;

    public static void main(String args[]) {
        System.out.println(FilesQualifier.qualify(TARGET_FOLDER));
        System.out.println(FoldersQualifier.qualify(TARGET_FOLDER));
    }
}