package com.example.repository;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 23/01/18.
 */
@Component
public class UserRepository {

    private Map<String, UserTable> database = new HashMap<>();

    public UserRepository()  {
    }

    @PostConstruct
    void init() {
        CreateTable("com.example.mypackage.Communicator");
    }

    public boolean CreateTable(String tableName) {

        UserTable table = new UserTable();
        try {
            table.Create(tableName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        database.put(tableName, table);

        return true;

    }

    public UserTable getTable(String tableName) {
        return database.get(tableName);
    }



}
