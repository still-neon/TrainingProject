package by.stn.callslogproject.callslog;

import by.stn.callslogproject.personsinfo.*;
import by.stn.callslogproject.ui.DatePicker;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by EugenKrasotkin on 2/21/2018.
 */
public class CallsLogTableManager {
    private static final String[] COLUMN_NAMES = {"CallType", "Caller", "Addressee", "StartDate", "EndDate", "ID"};
    private static final CallsLogEntry.CallType[] CALL_TYPES = {CallsLogEntry.CallType.INCOMING, CallsLogEntry.CallType.OUTGOING, CallsLogEntry.CallType.CONFERENCE};
    private DefaultTableModel tableModel;
    private JTable table;
    @Setter
    private CallsLogService service;
    @Setter
    private CallsLogDao callsLogDao;
    @Setter
    private PersonsDao personsDao;
    private boolean editEnabled = true;
   
    public CallsLogTableManager() {
        table = new JTable();
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
        getTable();
    }

    public JTable getTable() {
        configureTable();//возможно нужно передавать table и тд тк непонятно что за методы
        configureModel();
        setRender();
        return table;
    }

    private void configureTable() {
        tableModel = new DefaultTableModel(getTableData(), COLUMN_NAMES) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return editEnabled;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
        table.getRowSorter().toggleSortOrder(Arrays.asList(COLUMN_NAMES).indexOf("ID"));
    }

    private void configureModel() {
        List<PersonsInfo> personsInfo = null;
        try {
            personsInfo = personsDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JComboBox callTypeSelect = new JComboBox();
        JComboBox personSelect = new JComboBox();

        for (CallsLogEntry.CallType callType : CallsLogTableManager.CALL_TYPES) {
            callTypeSelect.addItem(callType);
        }

        for (PersonsInfo personInfo : personsInfo) {
            personSelect.addItem(personInfo.getId());
        }

        TableColumn callTypeColumn = table.getColumnModel().getColumn(0);
        TableColumn callerColumn = table.getColumnModel().getColumn(1);
        TableColumn addresseeColumn = table.getColumnModel().getColumn(2);
        TableColumn startDateColumn = table.getColumnModel().getColumn(3);
        TableColumn endDateColumn = table.getColumnModel().getColumn(4);

        callTypeColumn.setCellEditor(new DefaultCellEditor(callTypeSelect));
        callerColumn.setCellEditor(new DefaultCellEditor(personSelect));
        addresseeColumn.setCellEditor(new DefaultCellEditor(personSelect));
        startDateColumn.setCellEditor(new DatePicker());
        endDateColumn.setCellEditor(new DatePicker());
    }

    private void setRender() {
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if( value instanceof Date) {
                    value = f.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
            }
        };

        table.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(tableCellRenderer);
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
        for(int i = 0; i < modelData.length; i++) {
            for(int j = 0; j < tableModel.getColumnCount(); j++) {
                modelData[i][j] = tableModel.getValueAt(i,j);

            }
        }
        return modelData;
    }
}