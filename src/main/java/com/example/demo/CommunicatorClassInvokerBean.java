package com.example.demo;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.*;

/**
 * Created by root on 23/01/18.
 */
@Component

public class CommunicatorClassInvokerBean {

    @Autowired
    private UserRepository userRepository;

    private final String invClassName = "com.example.mypackage.Communicator";

    public Method getMethodById(Integer id) throws ClassNotFoundException {
        Class<?> executeClass = Class.forName(invClassName); // convert string classname to class
        try {
            Object communicator = executeClass.newInstance(); // invoke empty constructor
            String methodName  = userRepository.getAt(id);
            return communicator.getClass().getMethod(methodName);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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
