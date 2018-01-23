package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication (scanBasePackages = { "com.example" })
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		CommunicatorClassInvokerBean execBean = ctx.getBean(CommunicatorClassInvokerBean.class);
        try {
            execBean.invokeMethodID(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        };
	}
}
