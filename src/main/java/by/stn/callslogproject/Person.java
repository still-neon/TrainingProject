package by.stn.callslogproject;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by EugenKrasotkin on 11/29/2017.
 */
public class Person {
    @Getter @Setter private Integer id;
    @Getter @Setter private String name;
    @Getter @Setter private String organization;
    @Getter @Setter private String phone;
    @Getter @Setter private String email;
    @Getter @Setter private Date creationDate;

    @Override
    public String toString() {
        return String.valueOf(id) + " " + name + " " + organization + " " + phone + " " + email + " " + String.valueOf(creationDate) + "\n";
    }
}
