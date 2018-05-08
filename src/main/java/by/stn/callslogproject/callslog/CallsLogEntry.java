package by.stn.callslogproject.callslog;

import by.stn.callslogproject.Entity;
import by.stn.callslogproject.entity.AbstractEntity;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */

@Entity(tableName = "callslog", columnsNames = {"calltype", "callerid", "addresseeid", "startdate", "enddate"})
public class CallsLogEntry extends AbstractEntity {
    @Getter
    @Setter
    private CallType callType;
    @Getter
    @Setter
    private PersonsInfo caller;
    @Getter
    @Setter
    private PersonsInfo addressee;
    @Getter
    @Setter
    private Date startDate;
    @Getter
    @Setter
    private Date endDate;

    public CallsLogEntry(Long id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CallsLogEntry)) {
            return false;
        }

        CallsLogEntry callsLogEntry = (CallsLogEntry) o;

        return callsLogEntry.getId() == getId() && callsLogEntry.getCallType().equals(getCallType()) && callsLogEntry.getCaller().getId() == getCaller().getId() &&
                callsLogEntry.getAddressee().getId() == getAddressee().getId() && callsLogEntry.getStartDate().equals(getStartDate()) && callsLogEntry.getEndDate().equals(getEndDate());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = (int) (31 * result + getId());
        result = 31 * result + getCallType().hashCode();
        result = 31 * result + getCaller().hashCode();
        result = 31 * result + getAddressee().hashCode();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + getEndDate().hashCode();
        return result;
    }

    public void setCallType(int stateNum) {
        callType = CallType.byId(stateNum);
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }



    public enum CallType {
        INCOMING(0), OUTGOING(1), CONFERENCE(2);

        @Getter
        private int id;

        CallType(int id) {
            this.id = id;
        }

        public static CallType byId(int id) {
            for (CallType val : CallType.values()) {
                if (val.id == id) {
                    return val;
                }
            }
            throw new IllegalStateException("CallType{id=" + id + "} is not supported!");
        }
    }
}