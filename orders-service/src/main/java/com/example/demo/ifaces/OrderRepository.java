package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
	
	public List<Order> findByUserName(String user);
	
	public List<Order> findByOrderId(int Id);

}
