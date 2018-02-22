package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogDao;
import by.stn.callslogproject.callslog.CallsLogEntry;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by EugenKrasotkin on 2/21/2018.
 */
public class CallsLogTableManager {
    private static final String[] COLUMN_NAMES = {"CallType", "Caller", "Addressee", "StartDate", "EndDate", "ID"};
    private DefaultTableModel model;
    @Setter
    private CallsLogDao callsLogDao;
    private boolean editEnabled;
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