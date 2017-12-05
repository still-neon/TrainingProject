package by.stn.callslogproject;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class PersonInfo {
    @Getter @Setter private String fullName;
    @Getter @Setter private String organizationName;
    @Getter @Setter private String phoneNumber;
    @Getter @Setter private String emailAddress;
    @Getter @Setter private Date creationDate;
}
