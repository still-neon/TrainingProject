package by.stn.callslogproject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 1/3/2018.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        PersonsInfo ps = new PersonsInfo(2);
        ps.setCreationDate(new java.sql.Date(new java.util.Date().getTime()));
        ps.setEmail("a@tut.by");
        ps.setFullName("Sly");
        ps.setOrganizationName("Rambo");
        ps.setPhone("20-30-40");

        CallsLogEntry cl = new CallsLogEntry(3);
        cl.setAddressee(ps);
        cl.setCaller(ps);
        cl.setCallType(3);

        cl.setEndDate(new java.sql.Date(new java.util.Date().getTime()));
        cl.setStartDate(new java.sql.Date(new java.util.Date().getTime()));

        Set<CallsLogEntry> scl = new HashSet<>();
        scl.add(cl);

        //new CallsLogDaoImpl().saveOrUpdate(cl);
        //System.out.println(new CallsLogDaoImpl().saveOrUpdate(cl));
        //System.out.println(new CallsLogDaoImpl().delete(15));
        //System.out.println(new CallsLogDaoImpl().get(16));
        //System.out.println(new CallsLogDaoImpl().getAll(scl));
        System.out.println(new PersonsDaoImpl().saveOrUpdate(ps));


    }
}
