package by.stn.callslogproject;

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

    public CallsLogEntry(long id) {
        super(id);
    }

    public void setCallType(int stateNum) {
        callType = CallType.byId(stateNum);
    }

    public enum CallType {
        INCOMING(1), OUTGOING(2), CONFERENCE(3);

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