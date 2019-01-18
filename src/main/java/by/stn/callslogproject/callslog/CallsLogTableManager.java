package by.stn.callslogproject.callslog;

import by.stn.callslogproject.facade.Facade;
import by.stn.callslogproject.ui.DatePicker;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CallsLogTableManager {
	private static final String[] COLUMN_NAMES = {"CallType", "Caller", "CallerID", "Addressee", "AddresseeID", "StartDate", "EndDate", "ID"};
	@Setter
	private Facade facade;
	private DefaultTableModel tableModel;
	private JTable table;
	private boolean editEnabled = true;

	public void addRow() {
		String[] str = {};
		tableModel.addRow(str);
		//tableModel.moveRow(0,0,table.getSelectedRow()+1);
	}

	public void deleteRow() {
		tableModel.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
	}

	public void save() {
		facade.save(getModelData());
	}

	public void refresh() {
		table.setModel(createTableModel());
		setUpTableModel(table);
	}

	public DefaultTableModel createTableModel() {
		tableModel = new DefaultTableModel(facade.getTableData(), COLUMN_NAMES) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return editEnabled;
			}
		};
		return tableModel;
	}

	public void setUpTableModel(JTable table) {
		this.table = table;

		List<String> callTypes = facade.getCallTypes();
		List<String> personNames = facade.getPersonsNames();

		setUpTableColumnCellEditor(0, new DefaultCellEditor(createComboBox(callTypes)));
		setUpTableColumnCellEditor(1, new DefaultCellEditor(createComboBox(personNames)));
		setUpTableColumnCellEditor(3, new DefaultCellEditor(createComboBox(personNames)));
		setUpTableColumnCellEditor(5, new DatePicker());
		setUpTableColumnCellEditor(6, new DatePicker());

		setUpTableColumnCellRenderer(3, createRenderer());
		setUpTableColumnCellRenderer(4, createRenderer());

		hideColumns(2, 4, 7);
	}

	private JComboBox createComboBox(List<String> options) {
		JComboBox comboBox = new JComboBox();
		for (Object option : options) {
			comboBox.addItem(option);
		}
		return comboBox;
	}

	private TableCellRenderer createRenderer() {
		TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

			public Component getTableCellRendererComponent(JTable table,
														   Object value, boolean isSelected, boolean hasFocus,
														   int row, int column) {
				if (value instanceof Date) {
					value = simpleDateFormat.format(value);
				}
				return super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
			}
		};
		return tableCellRenderer;
	}

	private void setUpTableColumnCellEditor(int columnIndex, TableCellEditor tableCellEditor) {
		table.getColumnModel().getColumn(columnIndex).setCellEditor(tableCellEditor);
	}

	private void setUpTableColumnCellRenderer(int columnIndex, TableCellRenderer tableCellRenderer) {
		table.getColumnModel().getColumn(columnIndex).setCellRenderer(tableCellRenderer);
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

	private void hideColumns(int... numbers) {
		for (int number : numbers) {
			table.getColumnModel().getColumn(number).setMinWidth(0);
			table.getColumnModel().getColumn(number).setMaxWidth(0);
		}
	}
}