package by.stn.callslogproject;

import by.stn.callslogproject.callslog.CallsLogEntry;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 1/8/2018.
 */
public class CallsLogTableModel implements TableModel {

    private Set<CallsLogEntry> callsLog;

    public CallsLogTableModel(Set<CallsLogEntry> callsLog) {
        this.callsLog = callsLog;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "CallType";
            case 2:
                return "CallerId";
            case 3:
                return "AddresseeId";
            case 4:
                return "StartDate";
            case 5:
                return "EndDate";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return callsLog.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<CallsLogEntry> list = new ArrayList<>();
        list.addAll(callsLog);
        CallsLogEntry cl = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cl.getId();
            case 1:
                return cl.getCallType();
            case 2:
                return cl.getCaller().getId();
            case 3:
                return cl.getAddressee().getId();
            case 4:
                return cl.getStartDate();
            case 5:
                return cl.getStartDate();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}