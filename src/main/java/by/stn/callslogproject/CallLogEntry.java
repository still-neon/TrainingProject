package by.stn.callslogproject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class CallLogEntry {
    @Getter @Setter private PersonInfo caller;
    @Getter @Setter private PersonInfo addressee;
    @Getter @Setter private CallType callType;
    @Getter @Setter private Date startDate;
    @Getter @Setter private Date endDate;

    private enum CallType {
        INCOMMING, OUTGOING, CONFERENCE
    }
}
