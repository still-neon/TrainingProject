package by.stn.trainingproject.archiver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static by.stn.trainingproject.archiver.WorkerPool.REGULAR_FILE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
    public static final int OUTPUT_FILE_COUNT = 3;
    private static final String APP_NAME = "Archive file";
    private static final String BUTTON_SUSPEND_TEXT = "Suspend";
    private static final String BUTTON_RESUME_TEXT = "Resume";
    private static final String BUTTON_FINISHED_TEXT = "Finished";
    private static final String LABEL_TEXT = APP_NAME + ": " + REGULAR_FILE;

    private WorkerPool workerPool;
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

    private void createUI() {
        workerPool = WorkerPool.getInstance();

        frame = new JFrame(APP_NAME);
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
            buttons[i].setAction(new ArchiveAction(buttons[i], labels[i], workerPool, i + 1));
        }
        for (int i = 0; i < OUTPUT_FILE_COUNT; i++) {
            contents.add(buttons[i]);
            contents.add(labels[i]);
        }
    }

    private static class ArchiveAction extends AbstractAction {
        private JButton button;
        private JLabel label;
        private ComponentsState state;
        private WorkerPool workerPool;
        private int outputFileNum;

        ArchiveAction(JButton button, JLabel label, WorkerPool workerPool, int outputFileNum) {
            this.button = button;
            this.label = label;
            this.workerPool = workerPool;
            this.outputFileNum = outputFileNum;
            changeState(ComponentsState.INITIAL);
        }

        public void actionPerformed(ActionEvent e) {
            switch (state) {
                case INITIAL:
                    changeState(ComponentsState.INPROGRESS);
					workerPool.start(outputFileNum, new LabelUpdater());
                    break;
                case INPROGRESS:
                    changeState(ComponentsState.SUSPEND);
                    workerPool.suspend(outputFileNum);
                    break;
                case SUSPEND:
                    changeState(ComponentsState.INPROGRESS);
                    workerPool.resume(outputFileNum);
                    break;
                case FINISHED:

                    break;
                default:
                    throw new IllegalStateException("Unsupported enum value = " + state);
            }
        }

		public class LabelUpdater implements WorkerPool.Callback {
			@Override
			public void update(long status) {
				if (status < 100) {
					label.setText("File is " + status + "% zipped");
				} else if (status == 100) {
					label.setText("File " + REGULAR_FILE + " is zipped");
					changeState(UICreator.ArchiveAction.ComponentsState.FINISHED);
				}
			}
		}

        private void changeState(ComponentsState state) {
            this.state = state;
            putValue(Action.NAME, state.labelText);
            button.setEnabled(state.enabled);
        }

        private enum ComponentsState {
            INITIAL(true, APP_NAME), INPROGRESS(true, BUTTON_SUSPEND_TEXT), SUSPEND(true, BUTTON_RESUME_TEXT), FINISHED(false, BUTTON_FINISHED_TEXT);

            private boolean enabled;
            private String labelText;

            ComponentsState(boolean enabled, String labelText) {

                this.enabled = enabled;
                this.labelText = labelText;
            }
        }
    }
}