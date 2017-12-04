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

    public static void zipFile(File inputFile, final String zipFilePath, final Callback callback) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        try {
            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
            FileInputStream fileInputStream = new FileInputStream(inputFile);

            byte[] buf = new byte[1024000];
            int bytesRead;
            long sizeRead = 0;

            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
                sizeRead += bytesRead;
                callback.statusUpdate(sizeRead * 100 / inputFile.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileOutputStream.close();
        }
    }

    public interface Callback {
        void statusUpdate(long status);
    }
}