package by.stn.java_exercises.modul_1.ex_33_fixed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class FoldersQualifier {
    public static List<String> qualify(String targetFolder) {
        List<String> foldersNames = new ArrayList<>();
        for (File file : new File(targetFolder).listFiles(File::isDirectory)) {
            foldersNames.add(file.getName());
        }
        return foldersNames;
    }
}