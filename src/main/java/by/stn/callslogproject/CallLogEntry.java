package by.stn.callslogproject;

import java.util.Date;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class CallLogEntry {
    private PersonInfo caller;
    private PersonInfo addressee;
    private CallType callType;
    private Date startDate;
    private Date endDate;

    private enum CallType {
        INCOMMING, OUTGOING, CONFERENCE
    }
}
