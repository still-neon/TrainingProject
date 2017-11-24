package by.stn.trainingproject.archiver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
    private JFrame frame;
    private JLabel processFirstInfo, processSecondInfo, processThirdInfo;
    private JButton startFirstProcess, startSecondProcess, startThirdProcess;
    private ExecutorService service;
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
        service = Executors.newFixedThreadPool(3);
        frame = new JFrame("Archive File");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(250, 200);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(contents);

        processFirstInfo = new JLabel("Archive file: " + REGULAR_FILE);
        processSecondInfo = new JLabel("Archive file: " + REGULAR_FILE);
        processThirdInfo = new JLabel("Archive file: " + REGULAR_FILE);
        //TODO пусть Вася сделает
        startFirstProcess = new JButton();//TODO make good numbers
        startFirstProcess.setAction(new ArchiveAction("Archive file1", startFirstProcess, processFirstInfo));
        startSecondProcess = new JButton();
        startSecondProcess.setAction(new ExitAction("Archive file2", startSecondProcess, processSecondInfo));
        startThirdProcess = new JButton();
        startThirdProcess.setAction(new ExitAction("Archive file3", startThirdProcess, processThirdInfo));

        contents.add(startFirstProcess);
        contents.add(processFirstInfo);

        contents.add(startSecondProcess);
        contents.add(processSecondInfo);

        contents.add(startThirdProcess);
        contents.add(processThirdInfo);
    }

    class static ArchiveAction extends AbstractAction {
        private JButton button;
        private JLabel label;
        private char fileNumber;

        ExitAction(String name, JButton button, JLabel label) {
            this.button = button;
            this.label = label;
            fileNumber = name.charAt(name.length() - 1);
            putValue(Action.NAME, name);
        }

        public void actionPerformed(ActionEvent e) {
            putValue(Action.NAME, "In progress");
            button.setEnabled(false);
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Archiver.zipFile(new File(INPUT_FILE), OUTPUT_FILE + fileNumber + ".zip", new Archiver.Callback() {
                            @Override
                            public void statusUpdate(long status) {
                                label.setText("Zipped " + status / (1024 * 1024) + "Mb");
                            }
                        });
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    putValue(Action.NAME, "Finished");
                    label.setText("File " + REGULAR_FILE + " is zipped");
                }
            });
        }

        private void changeState(ComponetsState state) {
            // TODO button state and label text
        }

        private enum ComponetsState {
            INITIAL(false,"Archive file"), IN_PROGRESS(true,"In progress"), FINISHED(true,"Finished");

            private boolean disabled;
            private String labelText;

            ArchiveComponetsState(boolean disabled, String labelText) {
                this.disabled = disabled;
                this.labelText = labelText;
            }
        }
    }
}
