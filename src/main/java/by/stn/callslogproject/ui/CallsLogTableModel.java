package by.stn.callslogproject.ui;

import by.stn.callslogproject.callslog.CallsLogEntry;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by EugenKrasotkin on 1/8/2018.
 */
public class CallsLogTableModel extends DefaultTableModel implements TableModel {
    public static final String[] COLUMN_NAMES = {"calltype", "callerid", "addresseeid", "startdate", "enddate", "id"};
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();


    private static final int NUMBER_OF_COLUMNS = 6;

    private Set<CallsLogEntry> callsLog;

    public CallsLogTableModel(Set<CallsLogEntry> callsLog) {
        super(COLUMN_NAMES, 0);
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
        //юзать этот метод, вызывать при переключении на дугую ячейку
    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}