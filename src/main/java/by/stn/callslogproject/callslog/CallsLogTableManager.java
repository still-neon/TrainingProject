package by.stn.callslogproject.callslog;

import by.stn.callslogproject.facade.Facade;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CallsLogTableManager {
	@Setter
	private static Facade facade;
	@Setter
	private static CallsLogColumnsManager callsLogColumnsManager;
	private DefaultTableModel tableModel;
	private JTable table;
	private boolean editEnabled;

	public CallsLogTableManager() {
		editEnabled = true;
	}

	public void addRow() {
		String[] str = {};
		tableModel.insertRow(table.convertRowIndexToModel(table.getSelectedRow()) + 1, str);
//		tableModel.addRow(str);
//		tableModel.moveRow(table.convertRowIndexToModel(table.getSelectedRow()),table.convertRowIndexToModel(table.getSelectedRow())+1,1);
	}

	public void deleteRow() {
		tableModel.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
	}

	public void save() {
		facade.save(getModelData());
	}

	public void refresh() {
		setUpTableModel(table);
	}

	public void setUpTableModel(JTable table) {
		this.table = table;

		tableModel = new DefaultTableModel(facade.getTableData(), CallsLogColumnsManager.getCOLUMNS_TITLES()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return editEnabled;
			}
		};

		table.setModel(tableModel);
		callsLogColumnsManager.setUpTableColumns(table);
	}

	private Object[][] getModelData() {
		Object[][] modelData = new Object[tableModel.getRowCount()][tableModel.getColumnCount()];
		for (int i = 0; i < modelData.length; i++) {
			for (int j = 0; j < tableModel.getColumnCount(); j++) {
				modelData[i][j] = tableModel.getValueAt(i, j);
			}
		}
		return modelData;
	}
}