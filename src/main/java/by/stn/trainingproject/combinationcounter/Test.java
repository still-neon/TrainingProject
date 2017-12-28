package by.stn.trainingproject.combinationcounter;

import by.stn.callslogproject.CallsLogEntry;
import by.stn.callslogproject.PersonsInfo;

/**
 * Created by EugenKrasotkin on 12/27/2017.
 */
public class Test {
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET %s WHERE id=%s";
    private static final String[] PERSON_COLUMN_NAMES = {"id","calltype", "callerid","addresseeid","startdate","enddate"};

    public String[] getColumnsNames() {
        return PERSON_COLUMN_NAMES;
    }

    public int getColumnsNumber() {
        return PERSON_COLUMN_NAMES.length;
    }


    public String queryBuilder(String query, CallsLogEntry entity) {
        String temp = "";
        for(String str:getColumnsNames()) {
            temp = temp + str + "= ?,";
        }
        temp = temp.substring(0,temp.length()-1);
        System.out.println(temp);
        return temp;
    }
}

class Start {
    public static void main(String[] args) {
        Test t = new Test();
        t.queryBuilder("UPDATE %s SET %s WHERE id=%s", new CallsLogEntry(1));
        //System.out.println(t);
    }
}
