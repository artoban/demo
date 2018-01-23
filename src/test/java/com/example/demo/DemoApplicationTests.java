package com.example.demo;


import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;

@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() throws Exception {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, new String());
		CommunicatorClassInvokerBean execBean = ctx.getBean(CommunicatorClassInvokerBean.class);
        Method method = execBean.getMethodById(1);
        assertNotNull(method);
	}

}
