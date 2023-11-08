package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.Employeeservice;

class EmployeeServiceTest {
	
	private ApplicationContext appCtx;
	private DateFormat dateFormat;
	
	@BeforeEach
	void setUp() throws Exception {
		appCtx = new ClassPathXmlApplicationContext("Tx2.xml");
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	}

//	org.springframework.beans.factory.CannotLoadBeanClassException: Error loading class [org.springframework.orm.hibernate3.HibernateTransactionManager] for bean with name 'org.springframework.orm.hibernate3.HibernateTransactionManager#0' defined in class path resource [Tx.xml]: problem with class file or dependent class; nested exception is java.lang.NoClassDefFoundError: org/springframework/transaction/support/ResourceTransactionManager


	@AfterEach
	void tearDown() throws Exception {
		((ClassPathXmlApplicationContext) appCtx).close();
		
		
	}

	@Test
	void test() throws Exception{
//		fail("Not yet implemented");
		Employee e = new Employee("XYZ",dateFormat.parse("20-04-1997"),20000,'M',false);
		Employeeservice empSer =(Employeeservice) appCtx.getBean("empSer");
		e = empSer.createEmployee(e);
		System.out.println(e);
		e= empSer.incrementSalary(e, 5000);
		System.out.println(e);
	}

}
