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

    public void save(Object[][] data) {
        List<CallsLogEntry> newData = facade.convert(data);

        try {
            List<CallsLogEntry> oldData = callsLogDao.getAll();

            for (CallsLogEntry callsLogEntry : getDeletedData(newData, oldData)) {
                callsLogDao.delete(callsLogEntry.getId());
            }

            for (CallsLogEntry callsLogEntry : getUpdatedData(newData, oldData)) {
                callsLogDao.saveOrUpdate(callsLogEntry);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CallsLogEntry> getUpdatedData(List<CallsLogEntry> newData, List<CallsLogEntry> dbData) {
        List<CallsLogEntry> updatedData = new ArrayList<>(newData);

        for (CallsLogEntry callsLogEntry : dbData) {
            if (updatedData.contains(callsLogEntry)) {
                updatedData.remove(callsLogEntry);
            }
        }
        return updatedData;
    }

    private List<CallsLogEntry> getDeletedData(List<CallsLogEntry> newData, List<CallsLogEntry> dbData) {
        List<CallsLogEntry> deletedData = new ArrayList<>();

        for (CallsLogEntry callsLogEntry : dbData) {
            if (isNotPresent(newData, callsLogEntry.getId())) {
                deletedData.add(callsLogEntry);
            }
        }
        return deletedData;
    }

    private boolean isNotPresent(List<CallsLogEntry> newData, long id) {
        for (CallsLogEntry callsLogEntry : newData) {
            if (callsLogEntry.getId() == id)
                return false;
        }
        return true;
    }
}