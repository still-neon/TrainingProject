package by.stn.java_exercises.modul_1.ex_30_fixed;

import java.io.IOException;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class FileWithDataCreator {
    public static void create(String filePath,String text) throws IOException {
        FileManager.create(filePath);
        FileManager.write(filePath,text);
    }
}