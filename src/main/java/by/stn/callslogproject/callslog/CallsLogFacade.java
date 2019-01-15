package by.stn.callslogproject.callslog;

import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class CallsLogFacade {
    @Setter
    private CallsLogService callsLogService;


    public void save(Object[][] data) {

    }

    public Object[][] getTableData() {
        return getConvertedTableData(callsLogService.getCallsLogEntries());
    }

    public List<CallsLogEntry.CallType> getCallTypes() {
        return Arrays.asList(callsLogService.getCALL_TYPES());
    }

//    public List<CallsLogEntry> convert(Object[][] data) {//сохранять в фасаде и перекидыва ть в сервис список
//        List<CallsLogEntry> entities = new ArrayList<>();
//
//        for(Object[] entity: data) {
//            CallsLogEntry callsLogEntry = new CallsLogEntry((Long) entity[5]);
//            callsLogEntry.setCallType((CallsLogEntry.CallType) entity[0]);
//            try {
//                callsLogEntry.setCaller(personsDao.get((Long) entity[1]));
//                callsLogEntry.setAddressee(personsDao.get((Long) entity[2]));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            callsLogEntry.setStartDate((Date) entity[3]);
//            callsLogEntry.setEndDate((Date) entity[4]);
//            entities.add(callsLogEntry);
//        }
//        return entities;
//    }

    private Object[][] getConvertedTableData(List<CallsLogEntry> callsLogEntries) {
        Object[][] tableData = new Object[callsLogEntries.size()][CallsLogTableManager.getCOLUMN_NAMES().length];

        for (CallsLogEntry callsLogEntry : callsLogEntries) {
            tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType(), callsLogEntry.getCaller().getFullName(), callsLogEntry.getAddressee().getFullName(), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
        }
        return tableData;
    }
}