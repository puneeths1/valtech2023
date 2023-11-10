package com.valtech.training.firstspringboot.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.repos.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@PostConstruct
	public void populateOrders() {
		orderRepo.save(new Order("MACBOOK PRO",25,"FOR Entire Team",LocalDate.of(2023, 11, 3)));
		orderRepo.save(new Order("Asus",2,"FOR personal use",LocalDate.of(2023, 10, 5)));
		orderRepo.save(new Order("Google Pixel",1,"FOR Team as a bonus",LocalDate.of(2023, 12, 29)));
	}
	
	@Override
	public Order createOrder(Order order) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);
	}
	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}
	@Override
	public Order getOrder(long orderID) {
		return orderRepo.getReferenceById(orderID);
	}
	@Override
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
	
	

}
