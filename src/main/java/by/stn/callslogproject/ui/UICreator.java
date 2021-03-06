package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogTableManager;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UICreator {
	private static final String APP_NAME = "CallsLog";
	private static final String ADD_BUTTON_LABEL = "ADD";
	private static final String UPDATE_BUTTON_LABEL = "UPDATE";
	private static final String REFRESH_BUTTON_LABEL = "REFRESH";
	private static final String DELETE_BUTTON_LABEL = "DELETE";
	@Setter
	private CallsLogTableManager callsLogTableManager;

	public void create() {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = createFrame();
			frame.add(createPanel(), BorderLayout.NORTH);
			frame.add(createScrollPane(), BorderLayout.CENTER);
		});
	}

	private JFrame createFrame() {
		JFrame frame = new JFrame(APP_NAME);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(700, 600);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		return frame;
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(createButton(ADD_BUTTON_LABEL, e -> callsLogTableManager.addRow()));
		panel.add(createButton(DELETE_BUTTON_LABEL, e -> callsLogTableManager.deleteRow()));
		panel.add(createButton(UPDATE_BUTTON_LABEL, e -> callsLogTableManager.update()));
		panel.add(createButton(REFRESH_BUTTON_LABEL, e -> callsLogTableManager.refresh()));
		return panel;
	}

	private JButton createButton(String label, ActionListener e) {
		JButton button = new JButton(label);
		button.addActionListener(e);
		return button;
	}

	private JScrollPane createScrollPane() {
		return new JScrollPane(createTable());
	}

	private JTable createTable() {
		JTable table = new JTable();
		callsLogTableManager.setUpTableModel(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//TODO
//		table.setAutoCreateRowSorter(true);
//		table.getRowSorter().toggleSortOrder(1);
		return table;
	}
}