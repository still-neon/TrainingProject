package by.stn.trainingproject.archiver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
    private JFrame frame;
    private JLabel processFirstInfo, processSecondInfo, processThirdInfo;
    private JButton startFirstProcess, startSecondProcess, startThirdProcess;
    private static final String FS = System.getProperty("file.separator");
    private static final String PATH = System.getProperty("user.dir");
    private static final String REGULAR_FILE = "test.pdf";
    private static final String ARCHIVED_FILE = "test";
    private static final String INPUT_FILE = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + REGULAR_FILE;
    private static final String OUTPUT_FILE = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE;

    public UICreator() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    private void createUI() {
        frame = new JFrame("Archive File");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(contents);

        startFirstProcess = new JButton("Archive file1");
        startSecondProcess = new JButton("Archive file2");
        startThirdProcess = new JButton("Archive file3");

        processFirstInfo = new JLabel("Press button for archive file: " + REGULAR_FILE);
        processSecondInfo = new JLabel("Press button for archive file: " + REGULAR_FILE);
        processThirdInfo = new JLabel("Press button for archive file: " + REGULAR_FILE);

        contents.add(startFirstProcess);
        contents.add(processFirstInfo);

        contents.add(startSecondProcess);
        contents.add(processSecondInfo);

        contents.add(startThirdProcess);
        contents.add(processThirdInfo);

        startFirstProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExecutorService service = Executors.newFixedThreadPool(3);
                startFirstProcess.setEnabled(false);
                final int finalCounter = 1;
                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Started" + finalCounter);
                            new Archiver().zipFile(new File(INPUT_FILE), OUTPUT_FILE + finalCounter + ".zip");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        processFirstInfo.setText("File " + REGULAR_FILE + " is zipped to " + ARCHIVED_FILE + finalCounter + ".zip");
                    }
                });
            }
       });
    }
}