package by.stn.callslogproject.callslog;

import by.stn.callslogproject.entity.AbstractEntity;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */

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

    public void setCallType(int stateNum) {
        callType = CallType.byId(stateNum);
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