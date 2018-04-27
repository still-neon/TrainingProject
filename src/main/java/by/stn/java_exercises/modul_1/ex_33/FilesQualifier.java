package by.stn.java_exercises.modul_1.ex_33;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Created by EugenKrasotkin on 3/14/2018.
 */
public class FilesQualifier {
    public static Map<String, List<String>> qualify(String targetFolder) {
        Map<String, List<String>> filesInfo = new HashMap<>();

        BasicFileAttributes attributes = null;

        for (File file : new File(targetFolder).listFiles(File::isFile)) {
            List<String> fileAttributes = new ArrayList<>();
            try {
                attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileAttributes.add(String.valueOf(attributes.creationTime()));
            fileAttributes.add(String.valueOf(attributes.size()));

            filesInfo.put(file.getName(), fileAttributes);
        }
        return filesInfo;
    }
}