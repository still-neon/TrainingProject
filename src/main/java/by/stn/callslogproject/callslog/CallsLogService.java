package by.stn.callslogproject.callslog;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class CallsLogService {
    @Setter
    private CallsLogFacade facade;
    @Setter
    private CallsLogDao callsLogDao;

    public void saveInDB(Object[][] data) {
        try {
            for (CallsLogEntry callsLogEntry : getDataToSave(data)) {
                callsLogDao.saveOrUpdate(callsLogEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CallsLogEntry> getDataToSave(Object[][] data) throws Exception {
        List<CallsLogEntry> newData = facade.convert(data);

        for(CallsLogEntry callsLogEntry: callsLogDao.getAll()) {
            if(newData.contains(callsLogEntry)) {
                newData.remove(callsLogEntry);
            }
        }
        return newData;
    }

    private List<CallsLogEntry> getDataToDelete (List<CallsLogEntry> data) {
        List<CallsLogEntry> dataToDelete = new ArrayList<>();
        try {
            List<CallsLogEntry> old = callsLogDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(CallsLogEntry callsLogEntry: data) {

        }
        return dataToDelete;
    }
}