package by.stn.callslogproject;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class Tester {
    public static void main(String[] args) {
        Set persons = new HashSet();
        PersonDao test = new PersonDaoImpl();
        persons = test.getAllPerson();
        System.out.print(persons.toString());
    }
}
