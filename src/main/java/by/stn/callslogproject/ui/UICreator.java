package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogTableManager;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
	private static final String APP_NAME = "CallsLog";
	private static final String ADD_BUTTON_LABEL = "Add Call";
	private static final String SAVE_BUTTON_LABEL = "Save";
	private static final String REFRESH_BUTTON_LABEL = "Refresh";
	private static final String DELETE_BUTTON_LABEL = "Delete Call";
	@Setter
	private CallsLogTableManager callsLogTableManager;

	public void create() {
		SwingUtilities.invokeLater(new Runnable() {
			JFrame frame;

			public void run() {
				frame = createFrame();
				frame.add(createContents(), BorderLayout.NORTH);
				frame.add(createScrollPane(), BorderLayout.CENTER);
			}

			private JFrame createFrame() {
				frame = new JFrame(APP_NAME);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setSize(700, 600);
				frame.setResizable(true);
				frame.setVisible(true);
				frame.setLayout(new BorderLayout());
				return frame;
			}

			private JPanel createContents() {
				JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
				contents.add(createButton(ADD_BUTTON_LABEL, e -> callsLogTableManager.addRow()));
				contents.add(createButton(DELETE_BUTTON_LABEL, e -> callsLogTableManager.deleteRow()));
				contents.add(createButton(SAVE_BUTTON_LABEL, e -> callsLogTableManager.save()));
				contents.add(createButton(REFRESH_BUTTON_LABEL, e -> callsLogTableManager.refresh()));
				return contents;
			}

			private JButton createButton(String label, ActionListener e) {
				JButton button = new JButton(label);
				button.addActionListener(e);
				return button;
			}

			private JScrollPane createScrollPane() {
				return new JScrollPane(callsLogTableManager.getTable());
			}
		});
	}
}