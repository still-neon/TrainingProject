package by.stn.callslogproject;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class PersonsInfo extends AbstractEntity {
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String organizationName;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Date creationDate;

    public PersonsInfo(Long id) {
        super(id);
    }
}