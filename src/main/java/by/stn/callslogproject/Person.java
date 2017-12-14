package by.stn.callslogproject;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class Person extends AbstractEntity {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String organization;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Date creationDate;

    public Person(long id) {
        super(id);
    }
}