package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.service.OrderService;
import com.valtech.training.firstspringboot.service.OrderServiiceImpl;

@SpringBootTest
class FirstSpringBootApplicationTests {
		
		@Autowired
		private HelloWorld helloWorld;
		
		@Autowired
		private EmployeeDAO employeeDAO;
		
		@Autowired 
		private OrderService orderService;
		
		@Autowired
		private SimpleInterest simpleInterest;
		
		
		@Test
		void testSI() {
			simpleInterest.computeInterest(2000, 4, 5);
			System.out.println(simpleInterest.computeInterest(2000, 4, 5));
		}
		
//		@Test
//		void testOrders() {
//			Order o = orderService.createOrder(new Order("MACBOOK PRO",25,"FOR ENtire Team",LocalDate.of(2023, 11, 3)));
//			assertNotEquals(0, o.getId());
//			assertTrue(orderService.getAllOrders().size()>0);
//		}
//		
//		@Test
//		void testEmployeeDAO() {
//			assertEquals(3, employeeDAO.count());
//			assertEquals(3, employeeDAO.getAllEmployees().size());
//			System.out.println(employeeDAO.getAllEmployees());
//		}
	 
		@Test
		void contextLoads() {
			assertNotNull(helloWorld);
			assertEquals("Hello Spring Boot", helloWorld.hello());
			System.out.println(helloWorld.hello());
		}
		
}
