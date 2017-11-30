package by.stn.trainingproject.archiver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static by.stn.trainingproject.archiver.WorkerPool.REGULAR_FILE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
    public static final int OUTPUT_FILE_COUNT = 3;
    private static final String appName = "Archive file";
    private static final String buttonSuspendText = "Suspend";
    private static final String buttonResumeText = "Resume";
    private static final String buttonFinishedText = "Finished";
    private static final String LABEL_TEXT = appName + ": " + REGULAR_FILE;

    private JFrame frame;
    private JLabel[] labels = new JLabel[OUTPUT_FILE_COUNT];
    private JButton[] buttons = new JButton[OUTPUT_FILE_COUNT];

    public UICreator() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }

    //TODO tem comment

    private void createUI() {
        service = Executors.newFixedThreadPool(3);
        frame = new JFrame(appName);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(240, 200);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(contents);

        for (int i = 0; i < OUTPUT_FILE_COUNT; i++) {
            labels[i] = new JLabel(LABEL_TEXT);
        }
        for (int i = 0; i < OUTPUT_FILE_COUNT; i++) {
            buttons[i] = new JButton();
            buttons[i].setAction(new ArchiveAction(buttons[i], labels[i], service, String.format(OUTPUT_FILE_FORMAT, i + 1)));
        }
        for (int i = 0; i < OUTPUT_FILE_COUNT; i++) {
            contents.add(buttons[i]);
            contents.add(labels[i]);
        }
    }

    private static class ArchiveAction extends AbstractAction {
        private JButton button;
        private JLabel label;
        private Object lock = this;
        private boolean suspendFlag;
        private ExecutorService service;
        private String output_file;
        private ComponentsState state;

        ArchiveAction(JButton button, JLabel label, ExecutorService service, String output_file) {
            this.button = button;
            this.label = label;
            changeState(ComponentsState.INITIAL);
            this.service = service;
            this.output_file = output_file;
        }

        public synchronized void resume() {
            lock.notify();
        }

        public void actionPerformed(ActionEvent e) {
            switch (state) {
                case INITIAL:
                    changeState(ComponentsState.INPROGRESS);
                    start();
                    break;
                case INPROGRESS:
                    changeState(ComponentsState.SUSPEND);
                    break;
                case SUSPEND:
                    changeState(ComponentsState.INPROGRESS);
                    resume();
                    break;
                case FINISHED:
                    break;
                default:
                    throw new IllegalStateException("Unsupported enum value = " + state);
            }
        }

        private void changeState(ComponentsState state) {
            this.state = state;
            putValue(Action.NAME, state.labelText);
            suspendFlag = state.suspend;
            button.setEnabled(state.enabled);
        }

        private void start() {
            // TODO
            // workerPool.start()
            // плюс, каким-то образом должны обновлять процентик
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Archiver.zipFile(new File(INPUT_FILE), output_file, new Archiver.Callback() {
                            @Override
                            public void statusUpdate(long status) {
                                label.setText("File is " + status + "% zipped");
                                synchronized (lock) {
                                    // TODO create suspend() method
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
                    changeState(ComponentsState.FINISHED);
                    label.setText("File " + REGULAR_FILE + " is zipped");
                }
            });
        }

        private enum ComponentsState {
            INITIAL(false, true, appName), INPROGRESS(false, true, buttonSuspendText), SUSPEND(true, true, buttonResumeText), FINISHED(false, false, buttonFinishedText);

            private boolean suspend;
            private boolean enabled;
            private String labelText;

            ComponentsState(boolean suspend, boolean enabled, String labelText) {
                this.suspend = suspend;
                this.enabled = enabled;
                this.labelText = labelText;
            }
        }
    }
}
