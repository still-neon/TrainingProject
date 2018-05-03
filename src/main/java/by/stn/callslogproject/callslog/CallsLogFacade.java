package by.stn.callslogproject.callslog;

import by.stn.callslogproject.personsinfo.PersonsDao;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by EugenKrasotkin on 4/30/2018.
 */
public class CallsLogFacade {
    @Setter
    private PersonsDao personsDao;

    public List<CallsLogEntry> convert(Object[][] data) {
        List<CallsLogEntry> entities = new ArrayList<>();

        for(Object[] entity: data) {
            CallsLogEntry callsLogEntry = new CallsLogEntry((Long) entity[5]);
            callsLogEntry.setCallType((CallsLogEntry.CallType) entity[0]);
            try {
                callsLogEntry.setCaller(personsDao.get((Long) entity[1]));
                callsLogEntry.setAddressee(personsDao.get((Long) entity[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }

            callsLogEntry.setStartDate((Date) entity[3]);
            callsLogEntry.setEndDate((Date) entity[4]);
            entities.add(callsLogEntry);
        }
        return entities;
    }
}