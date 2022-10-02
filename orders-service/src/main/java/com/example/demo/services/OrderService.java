package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.ifaces.OrderRepository;

@Service
public class OrderService {
	
	
	private OrderRepository repo;
	
	@Autowired
	private OrderService(OrderRepository repo) {
		super();
		this.repo=repo;
	}
	
	public List<Order> findAll() {
		
		return this.repo.findAll();
	}
	
	public Order add(Order order) {
		
		return this.repo.save(order);
		
	}
	
	public Order update(Order order) {
		
		return this.repo.save(order);
	}
	
	public List<Order> findByUserName(String user) {
		
		return this.repo.findByUserName(user);
	}
	
	public List<Order> findByOrderId(int id) {
		
		return this.repo.findByOrderId(id);
	}
	
	

}
