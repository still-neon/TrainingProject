package by.stn.callslogproject;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class CallsLogger {
    private String callerName;
    private String adresseeName;
    //add 12213

    private enum CallType {
        INCOMMING, OUTGOING, CONFERENCE
    }

    private String callStartDate;
    private String callEndDate;
}
