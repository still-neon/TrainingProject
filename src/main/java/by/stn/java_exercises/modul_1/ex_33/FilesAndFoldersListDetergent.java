package by.stn.java_exercises.modul_1.ex_33;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Created by EugenKrasotkin on 3/14/2018.
 */
public class FilesAndFoldersListDetergent {
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String TARGET_FOLDER = PATH + FS + "src" + FS + "main" + FS + "resources" + FS;
    private static File file;

    public static HashMap<String, ArrayList<String>> detailFiles(String targetFolder) {
        file = new File(targetFolder);
        Map<String, ArrayList<String>> filesInfo = new HashMap<>();

        BasicFileAttributes attributes = null;

        for (File file : file.listFiles(File::isFile)) {
            List<String> fileAttributes = new ArrayList<>();
            try {
                attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileAttributes.add(String.valueOf(attributes.creationTime()));
            fileAttributes.add(String.valueOf(attributes.size()));

            filesInfo.put(file.getName(), (ArrayList<String>) fileAttributes);
        }
        return (HashMap<String, ArrayList<String>>) filesInfo;
    }

    public static ArrayList<String> detailFolders(String targetFolder) {
        file = new File(targetFolder);
        List<String> foldersNames = new ArrayList<>();
        for (File file : file.listFiles(File::isDirectory)) {
            foldersNames.add(file.getName());
        }
        return (ArrayList<String>) foldersNames;
    }

    public static void main(String args[]) {
        System.out.println(detailFiles(TARGET_FOLDER));
        System.out.println(detailFolders(TARGET_FOLDER));
    }
}