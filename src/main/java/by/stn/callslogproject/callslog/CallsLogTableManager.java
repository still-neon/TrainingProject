package by.stn.callslogproject.callslog;

import by.stn.callslogproject.facade.Facade;
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
import java.util.Date;
import java.util.List;

public class CallsLogTableManager {
	@Setter
	private static Facade facade;
	private DefaultTableModel tableModel;
	private JTable table;
	private boolean editEnabled = true;

	private static JComboBox createComboBox(List<String> options) {
		JComboBox comboBox = new JComboBox();
		for (Object option : options) {
			comboBox.addItem(option);
		}
		return comboBox;
	}

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
//		table.setModel(createTableModel());
		setUpTableModel(table);
	}

	public DefaultTableModel createTableModel() {
		tableModel = new DefaultTableModel(facade.getTableData(), getColumnsTitles()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return editEnabled;
			}
		};
		return tableModel;
	}

	public void setUpTableModel(JTable table) {
		this.table = table;
		setUpTableColumns();
	}

	private TableCellRenderer createRenderer() {
		TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				if (value instanceof Date) {
					value = simpleDateFormat.format(value);
				}
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		return tableCellRenderer;
	}

	private void setUpTableColumns() {
		for (TableColumns column : TableColumns.values()) {
			if (column.visible) {
				setUpTableColumnCellEditor(column.getIndex(), column.getTableCellEditor());
				if (column.needRender) {
					setUpTableColumnCellRenderer(column.getIndex(), createRenderer());
				}
			} else {
				hideColumn(column.getIndex());
			}
		}
	}

	private void setUpTableColumnCellEditor(int columnIndex, TableCellEditor tableCellEditor) {
		table.getColumnModel().getColumn(columnIndex).setCellEditor(tableCellEditor);
	}

	private void setUpTableColumnCellRenderer(int columnIndex, TableCellRenderer tableCellRenderer) {
		table.getColumnModel().getColumn(columnIndex).setCellRenderer(tableCellRenderer);
	}

	private void hideColumn(int number) {
		table.getColumnModel().getColumn(number).setMinWidth(0);
		table.getColumnModel().getColumn(number).setMaxWidth(0);
	}

	private String[] getColumnsTitles() {
		String[] columnsTitles = new String[TableColumns.values().length];
		for (int i = 0; i < columnsTitles.length; i++) {
			columnsTitles[i] = TableColumns.values()[i].getTitle();
		}
		return columnsTitles;
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

	public enum TableColumns {
		CALL_TYPE(0, "Call Type", true, false, new DefaultCellEditor(createComboBox(facade.getCallTypes()))),
		CALLER(1, "Caller", true, false, new DefaultCellEditor(createComboBox(facade.getPersonsNames()))),//TODO: need to discuss TableColumns
		CALLER_ID(2, "CallerID", false, false, null),
		ADDRESSEE(3, "Addressee", true, false, new DefaultCellEditor(createComboBox(facade.getPersonsNames()))),
		ADDRESSEE_ID(4, "AddresseeID", false, false, null),
		START_DATE(5, "Start Date", true, true, new DatePicker()),
		END_DATE(6, "End Date", true, true, new DatePicker()),
		ID(7, "ID", false, false, null);

		@Getter
		private int index;
		@Getter
		private String title;
		@Getter
		private boolean visible;
		@Getter
		private boolean needRender;
		@Getter
		private TableCellEditor tableCellEditor;

		TableColumns(int index, String title, boolean visible, boolean needRender, TableCellEditor tableCellEditor) {
			this.index = index;
			this.title = title;
			this.visible = visible;
			this.needRender = needRender;
			this.tableCellEditor = tableCellEditor;
		}
	}
}