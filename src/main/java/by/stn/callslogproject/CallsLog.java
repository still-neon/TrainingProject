package by.stn.callslogproject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class CallsLog extends AbstractEntity {
    @Getter
    @Setter
    private CallType callType;
    @Getter
    @Setter
    private Person callerId;
    @Getter
    @Setter
    private Person addresseeId;
    @Getter
    @Setter
    private Date startDate;
    @Getter
    @Setter
    private Date endDate;

    public CallsLog(long id) {
        super(id);
    }

    private enum CallType {
        INCOMING, OUTGOING, CONFERENCE
    }
}