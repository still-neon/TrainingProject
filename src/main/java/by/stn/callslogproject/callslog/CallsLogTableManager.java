package by.stn.callslogproject.callslog;

import by.stn.callslogproject.personsinfo.PersonsDao;
import by.stn.callslogproject.personsinfo.PersonsInfo;
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
	private static final String[] COLUMN_NAMES = {"CallType", "Caller", "Addressee", "StartDate", "EndDate", "ID"};
	@Getter
	private static final CallsLogEntry.CallType[] CALL_TYPES = {CallsLogEntry.CallType.INCOMING, CallsLogEntry.CallType.OUTGOING, CallsLogEntry.CallType.CONFERENCE};
	private DefaultTableModel tableModel;
	@Setter
	private CallsLogService service;
	@Setter
	private CallsLogDao callsLogDao;
	@Setter
	private PersonsDao personsDao;
	private JTable table;
	private boolean editEnabled = true;

	public CallsLogTableManager() {

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
		service.save(getModelData());
	}

	public void refresh() {
//        fillTable();
	}

	public DefaultTableModel createTableModel() {
		tableModel = new DefaultTableModel(getTableData(), COLUMN_NAMES) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return editEnabled;
			}
		};
		return tableModel;
	}

	public void setUpTableModel(JTable table) {
		this.table = table;
		JComboBox[] comboBoxes = createComboBoxes();

		setUpTableColumnCellEditor(0, new DefaultCellEditor(comboBoxes[0]));
		setUpTableColumnCellEditor(1, new DefaultCellEditor(comboBoxes[1]));
		setUpTableColumnCellEditor(2, new DefaultCellEditor(comboBoxes[1]));
		setUpTableColumnCellEditor(3, new DatePicker());
		setUpTableColumnCellEditor(4, new DatePicker());

		setUpTableColumnCellRenderer(3, getRenderer());
		setUpTableColumnCellRenderer(4, getRenderer());
	}

	private JComboBox[] createComboBoxes() {
		JComboBox callTypeSelect = new JComboBox();
		JComboBox personSelect = new JComboBox();
		JComboBox[] comboBoxes = {callTypeSelect, personSelect};

		for (CallsLogEntry.CallType callType : CallsLogTableManager.getCALL_TYPES()) {
			callTypeSelect.addItem(callType);
		}

		for (PersonsInfo personInfo : getPersonsData()) {
			personSelect.addItem(personInfo.getId());
		}
		return comboBoxes;
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

	//TODO: methods below move to Service?

	private List<PersonsInfo> getPersonsData() {
		List<PersonsInfo> personsInfo = null;
		try {
			personsInfo = personsDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personsInfo;
	}


	private Object[][] getTableData() {
		List<CallsLogEntry> callsLogEntries = null;
		try {
			callsLogEntries = callsLogDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[][] tableData = new Object[callsLogEntries.size()][COLUMN_NAMES.length];

		for (int i = 0; i < callsLogEntries.size(); i++) {
			CallsLogEntry entry = callsLogEntries.get(i);
			tableData[i] = new Object[]{entry.getCallType(), entry.getCaller().getId(), entry.getAddressee().getId(), entry.getStartDate(), entry.getEndDate(), entry.getId()};
		}
		return tableData;
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