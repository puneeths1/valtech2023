package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;
import com.valtech.training.spring.line;

class iocTest {
	
	private ApplicationContext appCtx;
	private ApplicationContext childAppCtx;
	
	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("ioc.xml");
		childAppCtx =  new ClassPathXmlApplicationContext(new String[]{"ioc_check.xml"},appCtx);
	}
	
	
	@Test
	void testChildAppCtx() {
		line l = (line) childAppCtx.getBean("line");
		System.out.println(l);
	}
	
//	@Test
//	void testline() {
//		System.out.println(appCtx.getBean("l1"));
//	}
//	
	
	@Test
	void testUtils() {
		UtilsBean ub = (UtilsBean)appCtx.getBean(UtilsBean.class);
		System.out.println(ub.getNames());
		System.out.println(ub.getSettings());
		System.out.println(ub.getPoints());
	}
	
	@Test
	void testline() {
		System.out.println(appCtx.getBean("l2"));
	}
	
	@Test
	void testSimpleInterest() {
		SimpleInterest s1 = (SimpleInterest)appCtx.getBean(SimpleInterest.class);
		System.out.println(s1.computeInterest(200, 2, 10));
	}
	
	@Test
	 private void testPointSetterInjection() {
		// TODO Auto-generated method stub
		System.out.println(appCtx.getBean("p2"));

	}

	@Test
	void test() {
		//fail("Not yet implemented");
//		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ioc.xml");
		HelloWorld hw = (HelloWorld) appCtx.getBean("hw");
		assertEquals("HelloWorld",hw.hello("World"));
//		assertEquals(appCtx.getBean("hw"),appCtx.getBean("abc"));
	}
	
	@Test
	void testPoint() {
		System.out.println(appCtx.getBean("p1"));
		assertEquals(appCtx.getBean("p1"),appCtx.getBean("p1"));
	}

}
