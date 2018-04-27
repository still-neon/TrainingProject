package by.stn.callslogproject;

import by.stn.callslogproject.callslog.CallsLogDao;
import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.personsinfo.PersonsDao;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class CallsLogService<T extends by.stn.callslogproject.callslog.CallsLogDao> {
    @Setter
    private CallsLogDao callsLogDao;
    @Setter
    private PersonsDao personsDao;

    public void saveInDB(Object[][] data) {
        List<CallsLogEntry> entities = toEntities(data);
        for(CallsLogEntry call: entities) {
            try {
                callsLogDao.saveOrUpdate((CallsLogEntry) call);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<CallsLogEntry> toEntities(Object[][] data) {//фасад конвертит
        List<CallsLogEntry> entities = new ArrayList<>();//сравнить то что в модели с тем что в базе

        for(Object[] entityData: data) {
            CallsLogEntry cl = new CallsLogEntry((Long) entityData[5]);
            cl.setCallType((CallsLogEntry.CallType) entityData[0]);
            try {
                cl.setCaller(personsDao.get((Long) entityData[1]));
                cl.setAddressee(personsDao.get((Long) entityData[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }

            cl.setStartDate((Date) entityData[3]);
            cl.setEndDate((Date) entityData[4]);
            entities.add((CallsLogEntry) cl);
        }
        return entities;
    }
}