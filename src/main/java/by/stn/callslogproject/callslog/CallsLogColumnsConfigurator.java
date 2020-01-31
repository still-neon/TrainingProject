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

import static by.stn.callslogproject.callslog.CallsLogColumnsConfigurator.CallsLogColumns.*;

public class CallsLogColumnsConfigurator {
	@Setter
	private static Facade facade;
	private JTable table;

	public static String[] getColumnsNames() {
		String[] names = new String[CallsLogColumns.values().length];
		for (CallsLogColumns callsLogColumns : CallsLogColumns.values()) {
			names[callsLogColumns.ordinal()] = callsLogColumns.getName();
		}
		return names;
	}

	public void setUpTableColumns(JTable table) {
		this.table = table;

		for (CallsLogColumns column : CallsLogColumns.values()) {
			switch (column) {
				case CALL_TYPE:
					setUpColumnCellEditor(CALL_TYPE.getId(), createComboBoxCellEditor(Collections.singletonList(facade.getCallTypes())));
					break;
				case CALLER:
					setUpColumnCellEditor(CALLER.getId(), createComboBoxCellEditor(Collections.singletonList(facade.getPersonsInfoDto())));
					break;
				case ADDRESSEE:
					setUpColumnCellEditor(ADDRESSEE.getId(), createComboBoxCellEditor(Collections.singletonList(facade.getPersonsInfoDto())));
					break;
				case START_DATE:
					setUpColumnCellEditor(START_DATE.getId(), createDateCellEditor());
					setUpColumnCellRenderer(START_DATE.getId(), createDateCellRenderer());
					break;
				case END_DATE:
					setUpColumnCellEditor(END_DATE.getId(), createDateCellEditor());
					setUpColumnCellRenderer(END_DATE.getId(), createDateCellRenderer());
					break;
				case ID:
					hideColumn(ID.getId());
					break;
			}
		}
	}

	private TableCellEditor createComboBoxCellEditor(List<Object> options) {
		JComboBox comboBox = new JComboBox();

		for (Object option : (List<Object>) options.get(0)) {
			comboBox.addItem(option);
		}

		return new DefaultCellEditor(comboBox);
	}

	private TableCellEditor createDateCellEditor() {
		return new DatePicker();
	}

	private void setUpColumnCellEditor(int columnId, TableCellEditor cellEditor) {
		table.getColumnModel().getColumn(columnId).setCellEditor(cellEditor);
	}

	private void setUpColumnCellRenderer(int columnId, TableCellRenderer cellRenderer) {
		table.getColumnModel().getColumn(columnId).setCellRenderer(cellRenderer);
	}

	private void hideColumn(int columnId) {
		table.getColumnModel().getColumn(columnId).setMinWidth(0);
		table.getColumnModel().getColumn(columnId).setMaxWidth(0);
	}

	private TableCellRenderer createDateCellRenderer() {
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

	@Getter
	public enum CallsLogColumns {
		CALL_TYPE(0, "Call Type"),
		CALLER(1, "Caller"),
		ADDRESSEE(2, "Addressee"),
		START_DATE(3, "Start Date"),
		END_DATE(4, "End Date"),
		ID(5, "ID");

		private int id;
		private String name;

		CallsLogColumns(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}