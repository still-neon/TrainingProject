package by.stn.trainingproject.archiver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by eugenkrasotkin on 11/21/2017.
 */
public class Archiver {
    private FileOutputStream fileOutputStream;
    private ZipOutputStream zipOutputStream;

    public void zipFile(File inputFile, String zipFilePath) throws IOException {
        try {
            fileOutputStream = new FileOutputStream(zipFilePath);
            zipOutputStream = new ZipOutputStream(fileOutputStream);

            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream fileInputStream = new FileInputStream(inputFile);

            byte[] buf = new byte[1024000];
            int bytesRead;
            long start = System.currentTimeMillis();
            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }
            System.out.println(System.currentTimeMillis()-start);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileOutputStream.close();
        }
    }
}