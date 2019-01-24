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
	private static final String[] COLUMN_NAMES = {"CallType", "Caller", "CallerID", "Addressee", "AddresseeID", "StartDate", "EndDate", "ID"};
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

		setUpTableColumnsCellEditor();
//		setUpTableColumnCellEditor(TableColumns.CALL_TYPE.getIndex(), new DefaultCellEditor(createComboBox(callTypes)));
//		setUpTableColumnCellEditor(TableColumns.CALL_TYPE.getIndex(), new DefaultCellEditor(createComboBox(personNames)));
//		setUpTableColumnCellEditor(TableColumns.CALL_TYPE.getIndex(), new DefaultCellEditor(createComboBox(personNames)));
//		setUpTableColumnCellEditor(TableColumns.CALL_TYPE.getIndex(), new DatePicker());
//		setUpTableColumnCellEditor(TableColumns.CALL_TYPE.getIndex(), new DatePicker());

		setUpTableColumnCellRenderer(TableColumns.START_DATE.getIndex(), createRenderer());
		setUpTableColumnCellRenderer(TableColumns.END_DATE.getIndex(), createRenderer());

		hideColumns(TableColumns.CALLER_ID.getIndex(), TableColumns.ADDRESSEE_ID.getIndex(), TableColumns.ID.getIndex());
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

	private void setUpTableColumnsCellEditor() {
		for (TableColumns column : TableColumns.values()) {
			setUpTableColumnCellEditor(column.getIndex(), column.getTableCellEditor());
		}
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

	public enum TableColumns {
		CALL_TYPE(0, "Call Type", 0, new DefaultCellEditor(createComboBox(facade.getCallTypes()))),
		CALLER("Caller", 1, new DefaultCellEditor(createComboBox(facade.getPersonsNames()))),
		CALLER_ID("CallerID", 2, null),
		ADDRESSEE("Addressee", 3, new DefaultCellEditor(createComboBox(facade.getPersonsNames()))),
		ADDRESSEE_ID("AddresseeID", 4, null),
		START_DATE("Start Date", 5, new DatePicker()),
		END_DATE("End Date", 6, new DatePicker()),
		ID("ID", 7, null);

		@Getter
		private String title;
		@Getter
		private int index;
		@Getter
		private TableCellEditor tableCellEditor;
		@Getter
		private boolean visible;
		@Getter
		private boolean needRender;


		TableColumns(int index, String title, boolean visible, boolean needRender, TableCellEditor tableCellEditor) {
			this.index = index;
			this.title = title;
			this.visible = visible;
			this.needRender = needRender;
			this.tableCellEditor = tableCellEditor;
		}
	}

	private void hideColumns(int... numbers) {
		for (int number : numbers) {
			table.getColumnModel().getColumn(number).setMinWidth(0);
			table.getColumnModel().getColumn(number).setMaxWidth(0);
		}
	}
}