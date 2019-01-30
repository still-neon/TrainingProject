package by.stn.callslogproject.callslog;

import by.stn.callslogproject.facade.Facade;
import by.stn.callslogproject.ui.DatePicker;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CallsLogColumnsManager {//TODO: конфигуратор
	@Getter
	private static final String[] COLUMNS_TITLES = {"Call Type", "Caller", "Addressee", "Start Date", "End Date", "ID"};
	@Setter
	private static Facade facade;
	private JTable table;

	private static JComboBox createComboBox(java.util.List<Object> options) {
		JComboBox comboBox = new JComboBox();
		for (Object option : (List<Object>) options.get(0)) {
			comboBox.addItem(option);
		}
		return comboBox;
	}

	public void setUpTableColumns(JTable table) {
		this.table = table;
		for (CallsLogColumns column : CallsLogColumns.values()) {
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

	private TableCellRenderer createRenderer() {
		TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DatePicker.getDATE_FORMAT_PATTERN());

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				if (value instanceof Date) {
					value = simpleDateFormat.format(value);
				}
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		return tableCellRenderer;
	}

	public enum CallsLogColumns {
		CALL_TYPE(0, COLUMNS_TITLES[0], true, false, getTableCellEditor(COLUMNS_TITLES[0])),//TODO: работает по разному для разных колонок
		CALLER(1, COLUMNS_TITLES[1], true, false, getTableCellEditor(COLUMNS_TITLES[1])),
		ADDRESSEE(2, COLUMNS_TITLES[2], true, false, getTableCellEditor(COLUMNS_TITLES[2])),
		START_DATE(3, COLUMNS_TITLES[3], true, true, getTableCellEditor(COLUMNS_TITLES[3])),
		END_DATE(4, COLUMNS_TITLES[4], true, true, getTableCellEditor(COLUMNS_TITLES[4])),
		ID(5, COLUMNS_TITLES[5], false, false, getTableCellEditor(COLUMNS_TITLES[5]));

		@Getter
		private int index;//TODO: лучше id
		@Getter
		private String title;
		@Getter
		private boolean visible;
		@Getter
		private boolean needRender;
		@Getter
		private TableCellEditor tableCellEditor;

		CallsLogColumns(int index, String title, boolean visible, boolean needRender, TableCellEditor tableCellEditor) {
			this.index = index;
			this.title = title;
			this.visible = visible;
			this.needRender = needRender;
			this.tableCellEditor = tableCellEditor;
		}

		private static TableCellEditor getTableCellEditor(String column) {
			if (column.equals(COLUMNS_TITLES[0])) {//TODO:завязка на название колонки
				return new DefaultCellEditor(createComboBox(Collections.singletonList(facade.getCallTypes())));
			} else if (column.equals(COLUMNS_TITLES[1]) || column.equals(COLUMNS_TITLES[2])) {
				return new DefaultCellEditor(createComboBox(Collections.singletonList(facade.getPersonsInfoDto())));
			} else if (column.equals(COLUMNS_TITLES[3]) || column.equals(COLUMNS_TITLES[4])) {
				return new DatePicker();
			} else {
				return null;
			}
		}
	}
}