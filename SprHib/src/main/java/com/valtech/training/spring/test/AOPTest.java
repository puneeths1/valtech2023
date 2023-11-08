package com.valtech.training.spring.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;
import com.valtech.training.spring.DivideByZeroException;

class AOPTest {
	
	private ClassPathXmlApplicationContext appCtx;
	
	@BeforeEach
	private void initialize() {
		// TODO Auto-generated method stub
		appCtx = new ClassPathXmlApplicationContext("AOP.xml");
	}
	
	@AfterEach
	void close() {
		appCtx.close();
	}

	@Test
	void test() {
//		fail("Not yet implemented");
		Arithmetic arith = (Arithmetic)appCtx.getBean(Arithmetic.class);
		System.out.println(arith.getClass().getName());
		System.out.println(arith);
		assertEquals(5,arith.add(-2, -3));
		assertEquals(-1,arith.sub(2, 3));
		assertEquals(-2,arith.sub(-8, -6));
		assertEquals(5,arith.add(5, 0));
		try {
			arith.div(5, 0);
			fail("NO Exception Occured");
		}catch(Exception e){
			
		}
	}

}
