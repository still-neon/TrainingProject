package by.stn.trainingproject.archiver;

import javax.swing.*;
import java.util.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.TimerTask;

/**
 * Created by eugenkrasotkin on 11/21/2017.
 */
public class Archiver {

    public static void zipFile(File inputFile, final String zipFilePath, final Callback callback) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        final Timer[] timer = new Timer[1];
        final File[] file = new File[1];
        try {
            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream fileInputStream = new FileInputStream(inputFile);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    timer[0] = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        public void run() {
                            file[0] = new File(zipFilePath);
                            // TODO change to bytes read not written
                            callback.statusUpdate(file[0].length());
                        }
                    };
                    timer[0].schedule(timerTask, 1000, 3000);
                }
            });

            byte[] buf = new byte[1024000];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileOutputStream.close();
            timer[0].cancel();
        }
    }

    public interface Callback {
        void statusUpdate(long status);
    }

}
