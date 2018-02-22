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
public class TableConfigurator {
    private static final String[] COLUMN_NAMES = {"CallType", "Caller", "Addressee", "StartDate", "EndDate", "ID"};
    private DefaultTableModel model;
    @Setter
    private CallsLogDao callsLogDao;
    private boolean editEnabled;
    int r;

    public void config(JTable table) {
        model = new DefaultTableModel(getTableData(), COLUMN_NAMES) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return editEnabled;
            }
        };

        table.setModel(model);
        table.setAutoCreateRowSorter(true);
        table.getRowSorter().toggleSortOrder(Arrays.asList(COLUMN_NAMES).indexOf("ID"));
    }

    public void deleteRow(JTable table) {
        try {
            callsLogDao.delete((long) model.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), model.getColumnCount() - 1));
            model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRow(JTable table) {
        String[] str = {};
        model.addRow(str);
        //model.moveRow(0,0,table.getSelectedRow()+1);
    }

    public void editRow(JTable table) {
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

        for (int call = 0; call < calls.size(); call++) {
            for (int value = 0; value < COLUMN_NAMES.length; value++) {
                switch (COLUMN_NAMES[value]) {
                    case "CallType":
                        tableData[call][value] = calls.get(call).getCallType();
                        break;
                    case "Caller":
                        tableData[call][value] = calls.get(call).getCaller().getFullName();
                        break;
                    case "Addressee":
                        tableData[call][value] = calls.get(call).getAddressee().getFullName();
                        break;
                    case "StartDate":
                        tableData[call][value] = calls.get(call).getStartDate();
                        break;
                    case "EndDate":
                        tableData[call][value] = calls.get(call).getEndDate();
                        break;
                    case "ID":
                        tableData[call][value] = calls.get(call).getId();
                        break;
                }
            }
        }
        return tableData;
    }
}