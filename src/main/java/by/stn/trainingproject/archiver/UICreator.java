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

           /* SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    timer[0] = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        public void run() {

                            // TODO change to bytes read not written
                            callback.statusUpdate();
                        }
                    };
                    timer[0].schedule(timerTask, 1000, 3000);
                }
            });*/

            byte[] buf = new byte[1024000];
            int bytesRead;
            long counter = 0;
            long readedSize;

            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
                readedSize = bytesRead * counter;
                counter++;
                callback.statusUpdate(readedSize * 100/ inputFile.length());
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
