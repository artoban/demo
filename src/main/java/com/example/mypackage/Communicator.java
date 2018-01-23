package com.example.mypackage;

import org.springframework.stereotype.Component;

/**
 * Created by root on 23/01/18.
 */
@Component
public class Communicator {

    public Communicator() {
    }

    public void sendEmail() {
        System.out.println("The email is sending ...");
    }

    public void callPhone() {
        System.out.println("The phone call is made ...");
    }

    public void sendSMS() {
        System.out.println("The SMS message is sending ...");
    }

}
