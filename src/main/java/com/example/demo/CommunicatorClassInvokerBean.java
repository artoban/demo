package com.example.demo;


import com.example.repository.UserRepository;
import com.example.repository.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import com.example.mypackage.Invoker;

import java.lang.reflect.*;
import java.util.Map;

/**
 * Created by root on 23/01/18.
 */
@Component
@Invoker
public class CommunicatorClassInvokerBean {

    @Autowired
    private UserRepository userRepository;

    private  String invClassName;

    public CommunicatorClassInvokerBean(String invClassName) {
        this.invClassName = invClassName;
    }


    public Method getMethodById(Integer id) throws ClassNotFoundException {
        Class<?> executeClass = Class.forName(invClassName); // convert string classname to class
        try {
            UserTable table = userRepository.getTable(invClassName);
            Map<Integer, Map<Integer, String>> tableReposit = table.getTableReposit();
            Map<Integer, String> methods = tableReposit.get(1);
            return ReflectionUtils.findMethod(executeClass, methods.get(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void invokeMethodID(Integer id) throws ClassNotFoundException {

        Method setNameMethod = getMethodById(id);
        Class<?> executeClass = Class.forName(invClassName); // convert string classname to class

        try {
            Object communicator = executeClass.newInstance(); // invoke empty constructor
            setNameMethod.invoke(communicator); // pass args is omitted

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
