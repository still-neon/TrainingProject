package by.stn.callslogproject.callslog;

import by.stn.callslogproject.personsinfo.PersonsDao;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import by.stn.callslogproject.ui.DatePicker;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by EugenKrasotkin on 2/21/2018.
 */
public class CallsLogTableManager {
    private static final String[] COLUMN_NAMES = {"CallType", "Caller", "Addressee", "StartDate", "EndDate", "ID"};
    private static final String[] callType = {CallsLogEntry.CallType.INCOMING.name(),CallsLogEntry.CallType.OUTGOING.name(),CallsLogEntry.CallType.CONFERENCE.name()};
    private DefaultTableModel model;
    @Setter
    private CallsLogDao callsLogDao;
    @Setter
    private PersonsDao personsDao;
    private boolean editEnabled = true;
    private JTable table;
    //int r;

    public JTable createTable() {
        model = new DefaultTableModel(getTableData(), COLUMN_NAMES) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return editEnabled;
            }
        };
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
        table.getRowSorter().toggleSortOrder(Arrays.asList(COLUMN_NAMES).indexOf("ID"));


        TableColumn callTypeColumn = table.getColumnModel().getColumn(0);
        TableColumn callerColumn = table.getColumnModel().getColumn(1);
        TableColumn addresseeColumn = table.getColumnModel().getColumn(2);
        TableColumn startDateColumn = table.getColumnModel().getColumn(3);

        startDateColumn.setCellEditor(new DatePicker());


        JComboBox comboBox = new JComboBox();
        JComboBox comboBox1 = new JComboBox();
        JComboBox comboBox2 = new JComboBox();
        for(String call: callType) {

            comboBox.addItem(call);
        }

        ArrayList<PersonsInfo> personsInfo = null;
        try {
            personsInfo = (ArrayList<PersonsInfo>) personsDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(PersonsInfo p:personsInfo) {
            comboBox1.addItem(p.getFullName());
        }

        callTypeColumn.setCellEditor(new DefaultCellEditor(comboBox));
        callerColumn.setCellEditor(new DefaultCellEditor(comboBox1));
        addresseeColumn.setCellEditor(new DefaultCellEditor(comboBox1));

        //startDateColumn.setCellEditor(new DatePicker());


        
        return table;
    }

    public void deleteRow() {
        try {
            callsLogDao.delete((long) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), model.getColumnCount() - 1));
            model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRow() {
        String[] str = {};
        model.addRow(str);
        //model.moveRow(0,0,table.getSelectedRow()+1);
    }

    public void editRow() {
        int selrow = table.getSelectedRow();
        table.setRowSelectionInterval(2, 2);
        table.setRequestFocusEnabled(true);

        editEnabled = true;
    }

    private Object[][] getTableData() {
        ArrayList<CallsLogEntry> calls = null;
        try {
            calls = (ArrayList<CallsLogEntry>) callsLogDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] tableData = new Object[calls.size()][COLUMN_NAMES.length];

        for (int i = 0; i< calls.size(); i++) {
            CallsLogEntry entry = calls.get(i);
            tableData[i] = new Object[] {entry.getCallType(), entry.getCaller().getFullName(), entry.getAddressee().getFullName(), entry.getStartDate(), entry.getEndDate(), entry.getId()};
        }
        return tableData;
    }
}