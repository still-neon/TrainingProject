package by.stn.callslogproject.callslog;

import by.stn.callslogproject.facade.Facade;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CallsLogTableManager {
	@Setter
	private static Facade facade;
	@Setter
	private static CallsLogColumnsConfigurator callsLogColumnsConfigurator;
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

	public void update() {
		facade.update(getModelData());
	}

	public void refresh() {
		setUpTableModel(table);
	}

	public void setUpTableModel(JTable table) {
		this.table = table;

		tableModel = new DefaultTableModel(facade.getDataToDisplay(), CallsLogColumnsConfigurator.getColumnsNames()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return editEnabled;
			}
		};

		table.setModel(tableModel);
		callsLogColumnsConfigurator.setUpTableColumns(table);
	}

	private Object[][] getModelData() {
		Object[][] modelData = new Object[tableModel.getRowCount()][tableModel.getColumnCount()];
		for (int row = 0; row < modelData.length; row++) {
			for (int column = 0; column < tableModel.getColumnCount(); column++) {
				modelData[row][column] = tableModel.getValueAt(row, column);
			}
		}
		return modelData;
	}
}