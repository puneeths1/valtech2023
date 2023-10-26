package com.valtech.training.day2.test;

import com.valtech.training.day2.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("testing arithmetic")
class ArithmeticTest {
	
	private Arithmetic arithmetic;//; = new ArithmeticImpl();
	
	@BeforeAll
	static void beforeAll(){ 
		System.out.println("before all....");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After all....");
	}
	
	@BeforeEach
	void anything() {
		System.out.println("Init....");
		arithmetic = new ArithmeticImpl();
	}
	
	@AfterEach
	void destroy() {
		System.out.println("Destroy....");
		
	}
	
	
	@Test @DisplayName("Checking add method")
	void testAdd() {
		assertEquals(5,arithmetic.add(2, 3));
		assertEquals(5,arithmetic.add(3, 2));
		assertEquals(5,arithmetic.add(5, 0));
		assertEquals(5,arithmetic.add(5, -0));
	
		assertEquals(-5,arithmetic.add(-2, -3));
		assertEquals(-5,arithmetic.add(-8, 3));
//		fail("Not yet implemented");
	}

	@Test
	void testSub() {
//		fail("Not yet implemented");
	}

	@Test
	void testMul() {
//		fail("Not yet implemented");
	}
	
	

	@Test
	void testDiv() {
		
		assertEquals(1.666,5.0/3.0,001);
		assertEquals(2,arithmetic.div(4, 2));
		assertEquals(2,arithmetic.div(-6, -3));
		try {
			assertEquals(2,arithmetic.div(4, 0));
			fail("Should have throws ArithmeticException");
		}catch(DivideByZeroException ex){
			
		}
//		fail("Not yet implemented");
	}
	
	@Test
	void testDivByZero() {
		assertThrows(DivideByZeroException.class,() ->arithmetic.div(3, 0));
	}

}
