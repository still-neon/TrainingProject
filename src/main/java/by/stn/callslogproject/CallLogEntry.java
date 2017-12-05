package by.stn.callslogproject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class CallLogEntry {
    private PersonInfo caller;
    private PersonInfo addressee;
    private CallType callType;
    @Getter @Setter private Date startDate;
    @Getter @Setter private Date endDate;

    private enum CallType {
        INCOMMING, OUTGOING, CONFERENCE
    }
}
