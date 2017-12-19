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
    private PersonsInfo callerId;
    @Getter
    @Setter
    private PersonsInfo addresseeId;
    @Getter
    @Setter
    private Date startDate;
    @Getter
    @Setter
    private Date endDate;

    public CallsLogEntry(long id) {
        super(id);
    }

    private enum CallType {
        INCOMING(), OUTGOING(), CONFERENCE();
    }

    public void setCallType(int stateNum) {
        switch (stateNum) {
            case 1:
                callType = callType.INCOMING;
            case 2:
                callType = callType.OUTGOING;
            case 3:
                callType = callType.CONFERENCE;
        }
    }
}