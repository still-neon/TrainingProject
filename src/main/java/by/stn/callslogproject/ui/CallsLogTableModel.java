package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogDaoImpl;
import by.stn.callslogproject.callslog.CallsLogEntry;
import lombok.Setter;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 1/8/2018.
 */
public class CallsLogTableModel implements TableModel {
    private static final int NUMBER_OF_COLUMNS = 6;
    @Setter
    private CallsLogDaoImpl callsLogDaoImpl;

    private Set<CallsLogEntry> callsLog;

    public CallsLogTableModel(Set<CallsLogEntry> callsLog) {
        this.callsLog = callsLog;
    }

    @Override
    public int getColumnCount() {
        return NUMBER_OF_COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "CallType";
            case 1:
                return "CallerId";
            case 2:
                return "AddresseeId";
            case 3:
                return "StartDate";
            case 4:
                return "EndDate";
            case 5:
                return "ID";
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
                return cl.getCallType();
            case 1:
                return cl.getCaller().getFullName();
            case 2:
                return cl.getAddressee().getFullName();
            case 3:
                return cl.getStartDate();
            case 4:
                return cl.getStartDate();
            case 5:
                return cl.getId();
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