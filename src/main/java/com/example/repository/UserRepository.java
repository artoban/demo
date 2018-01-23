package com.example.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 23/01/18.
 */
@Component
public class UserRepository {

    private Map<Integer, String> database = new HashMap<>();

    public UserRepository()  {
        database.put(1, "sendEmail");
        database.put(2, "callPhone");
        database.put(3, "sendSMS");
    }

    public String getAt(Integer key) throws Exception{
        if (database.containsKey(key)) {
            return database.get(key);
        }
        else {
            //key does not exists
            throw new Exception("The key : %i does not exists !" + key);
        }
    }

    public void setAt(Integer key, String value ) throws Exception {
        if (!database.containsKey(key)) {
            database.put(key, value);
        }
        else {
            //key already exists
            throw new Exception("The key : %i already exists !" + key);
        }
    }

}
