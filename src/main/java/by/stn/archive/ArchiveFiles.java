package by.stn.archive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveFiles extends JFrame implements ActionListener, Runnable {
    //private static ArchiveFiles archive;
    private static final String PATH = System.getProperty("user.dir");
    private static final String REGULAR_FILE = "ExitWounds.avi";
    private static final String ARCHIVED_FILE = "ExitWounds.zip";
    //TODO file separator instead of \\
    private static final String INPUT_FILE = PATH+"\\src\\main\\resources\\"+REGULAR_FILE;
    private static final String OUTPUT_FILE = PATH+"\\src\\main\\resources\\"+ARCHIVED_FILE;
    private JLabel processInfo;
    private JButton startProcess;

    public ArchiveFiles() {
        super("Archive File");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        startProcess = new JButton("Archive");
        processInfo = new JLabel("For archive file " + REGULAR_FILE + " press button");

        //TODO Anonimus
        startProcess.addActionListener(this);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(processInfo);
        contents.add(startProcess);
        setContentPane(contents);
        setSize(400, 100);
        setVisible(true);
    }

    public void zipFile(File inputFile, String zipFilePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream fileInputStream = new FileInputStream(inputFile);
            //TODO check time 1024 and more
            byte[] buf = new byte[10240000];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }
            //TODO finally or try with recources
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //archive.zipFile(new File(INPUT_FILE), OUTPUT_FILE);
        processInfo.setText("File " + REGULAR_FILE + " is zipped to " + ARCHIVED_FILE);
    }

    public void actionPerformed(ActionEvent e) {
        //TODO make anonimus class. using
       /*new Thread(new Runnable() {
                @Override
                public void run() {
                    archive.zipFile(new File(INPUT_FILE), OUTPUT_FILE);
                    processInfo.setText("File " + REGULAR_FILE + " is zipped to " + ARCHIVED_FILE);
                }
            }).start();*/
        //archive.zipFile(new File(INPUT_FILE), OUTPUT_FILE);
        startProcess.setEnabled(false);
        new Thread(this).start();

    }

    public static void main(String[] args) {
        //archive = new ArchiveFiles();
    }
}