package com.example.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 24/01/18.
 */
public class UserTable {

    public Map<Integer, Map<Integer, String>> getTableReposit() {
        return tableReposit;
    }

    private Map<Integer, Map<Integer, String>> tableReposit = new HashMap<>();



    public void Create(String tableName) throws Exception {

        Map<Integer, String> table = new HashMap<>();

        table.put(1, "sendEmail");
        table.put(2, "callPhone");
        table.put(3, "sendSMS");

        setAt(1, table);

    }

    public String getAt(Integer key) throws Exception{
        if (tableReposit.containsKey(key)) {
            Map<Integer, String> innerRep = tableReposit.get(key);
            return innerRep.get(key);
        }
        else {
            //key does not exists
            throw new Exception("The key : %i does not exists !" + key);
        }
    }

    public void setAt(Integer key, Map<Integer, String> value ) throws Exception {
        if (!tableReposit.containsKey(key)) {
            tableReposit.put(key, value);
        }
        else {
            //key already exists
            throw new Exception("The key : %i already exists !" + key);
        }
    }

}
