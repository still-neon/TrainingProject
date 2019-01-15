package by.stn.callslogproject.callslog;

import by.stn.callslogproject.personsinfo.PersonsFacade;
import by.stn.callslogproject.ui.DatePicker;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CallsLogTableManager {
	@Getter
	private static final String[] COLUMN_NAMES = {"CallType", "Caller", "Addressee", "StartDate", "EndDate", "ID"};
	private DefaultTableModel tableModel;
	@Setter
	private CallsLogFacade callsLogFacade;
	@Setter
	private PersonsFacade personsFacade;
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
		callsLogFacade.save(getModelData());
	}

	public void refresh() {
		// fillTable();
	}

	public DefaultTableModel createTableModel() {
		tableModel = new DefaultTableModel(callsLogFacade.getTableData(), COLUMN_NAMES) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return editEnabled;
			}
		};
		return tableModel;
	}

	public void setUpTableModel(JTable table) {
		this.table = table;

		setUpTableColumnCellEditor(0, new DefaultCellEditor(createComboBox(Collections.singletonList(callsLogFacade.getCallTypes()))));
		setUpTableColumnCellEditor(1, new DefaultCellEditor(createComboBox(Collections.singletonList(personsFacade.getPersonsNames()))));
		setUpTableColumnCellEditor(2, new DefaultCellEditor(createComboBox(Collections.singletonList(personsFacade.getPersonsNames()))));
		setUpTableColumnCellEditor(3, new DatePicker());
		setUpTableColumnCellEditor(4, new DatePicker());

		setUpTableColumnCellRenderer(3, getRenderer());
		setUpTableColumnCellRenderer(4, getRenderer());
	}

	private JComboBox createComboBox(List<Object> options) {
		JComboBox comboBox = new JComboBox();
		for (Object option : options) {
			comboBox.addItem(option);
		}
		return comboBox;
	}

	private TableCellRenderer getRenderer() {
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
}