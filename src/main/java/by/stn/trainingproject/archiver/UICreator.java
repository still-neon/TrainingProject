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
    private static final String OUTPUT_FILE1 = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE + "1.zip";
    private static final String OUTPUT_FILE2 = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE + "2.zip";
    private static final String OUTPUT_FILE3 = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + ARCHIVED_FILE + "3.zip";
    private static final String appName = "Archive file";
    private static final String buttonSuspendText = "Suspend";
    private static final String buttonResumeText = "Resume";
    private static final String buttonFinishedText = "Finished";

    public UICreator() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    private void createUI() {
        service = Executors.newFixedThreadPool(3);
        frame = new JFrame(appName);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(240, 200);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(contents);

        processFirstInfo = new JLabel(appName + ": " + REGULAR_FILE);
        processSecondInfo = new JLabel(appName + ": " + REGULAR_FILE);
        processThirdInfo = new JLabel(appName + ": " + REGULAR_FILE);
        //TODO пусть Вася сделает
        startFirstProcess = new JButton();//TODO make good numbers
        startFirstProcess.setAction(new ArchiveAction(appName, startFirstProcess, processFirstInfo, service,OUTPUT_FILE1));
        startSecondProcess = new JButton();
        startSecondProcess.setAction(new ArchiveAction(appName, startSecondProcess, processSecondInfo, service,OUTPUT_FILE2));
        startThirdProcess = new JButton();
        startThirdProcess.setAction(new ArchiveAction(appName, startThirdProcess, processThirdInfo, service,OUTPUT_FILE3));

        contents.add(startFirstProcess);
        contents.add(processFirstInfo);

        contents.add(startSecondProcess);
        contents.add(processSecondInfo);

        contents.add(startThirdProcess);
        contents.add(processThirdInfo);
    }

    static class ArchiveAction extends AbstractAction {
        private JButton button;
        private JLabel label;
        private Object lock = new Object();
        private String buttonName;
        private boolean suspendFlag;
        private ExecutorService service;
        private String output_file;

        ArchiveAction(String name, JButton button, JLabel label, ExecutorService service, String output_file) {
            this.button = button;
            this.label = label;
            buttonName = name;
            changeState(ComponetsState.INITIAL);
            this.service = service;
            this.output_file = output_file;
        }

        public synchronized void resume() {
            synchronized (lock) {
                lock.notify();
            }
        }

        public void actionPerformed(ActionEvent e) {
            if (button.getText() == buttonName) {
                changeState(ComponetsState.INPROGRESS);
                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Archiver.zipFile(new File(INPUT_FILE), output_file, new Archiver.Callback() {
                                @Override
                                public void statusUpdate(long status) {
                                    label.setText("File is " + status + "% zipped");
                                    synchronized (lock) {
                                        while (suspendFlag) {
                                            try {
                                                lock.wait();
                                            } catch (InterruptedException e1) {
                                                e1.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            });
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        changeState(ComponetsState.FINISHED);
                        label.setText("File " + REGULAR_FILE + " is zipped");
                    }
                });
            } else if (button.getText() == buttonSuspendText) {
                changeState(ComponetsState.SUSPEND);
            } else if (button.getText() == buttonResumeText) {
                changeState(ComponetsState.INPROGRESS);
                resume();
            }
        }

        private void changeState(ComponetsState state) {
            // TODO button state and label text
            putValue(Action.NAME, state.labelText);
            suspendFlag = state.suspend;
            button.setEnabled(state.enabled);
        }

        private enum ComponetsState {
            INITIAL(false, true, appName), INPROGRESS(false, true, buttonSuspendText), SUSPEND(true, true, buttonResumeText), FINISHED(false, false, buttonFinishedText);

            private boolean suspend;
            private boolean enabled;
            private String labelText;

            ComponetsState(boolean suspend, boolean enabled, String labelText) {
                this.suspend = suspend;
                this.enabled = enabled;
                this.labelText = labelText;
            }
        }
    }
}
