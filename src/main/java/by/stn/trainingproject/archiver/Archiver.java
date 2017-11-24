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
    private FileOutputStream fileOutputStream;
    private ZipOutputStream zipOutputStream;
    private JLabel label;
    private Timer timer;
    private File file;


    Archiver(JLabel label) {
        this.label = label;
    }

    public void zipFile(File inputFile, final String zipFilePath) throws IOException {
        try {
            fileOutputStream = new FileOutputStream(zipFilePath);
            zipOutputStream = new ZipOutputStream(fileOutputStream);

            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream fileInputStream = new FileInputStream(inputFile);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    timer = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        public void run() {
                            file = new File(zipFilePath);
                            label.setText("Zipped " + file.length() / 1000000 + "Mb");
                        }
                    };
                    timer.schedule(timerTask, 1000, 3000);
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
            timer.cancel();
        }
    }
}
