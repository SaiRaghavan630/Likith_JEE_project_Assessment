package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/")
@AllArgsConstructor
public class OrderController {

	
	@Autowired
	private OrderService service;
	
	@GetMapping("/list")
	public List<Order> getAll() {
		
		return this.service.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Order> add(@RequestBody Order order) {
		
		Order addedObj = service.add(order);
		
		URI location = ServletUriComponentsBuilder
		          .fromCurrentRequest()
		          .path("/{id}").buildAndExpand(order.getOrderId())
		          .toUri();
		
		return ResponseEntity.created(location).body(addedObj);
	}
	
	@PutMapping("/save")
	public ResponseEntity<String> update(@RequestBody Order order){
		
		Order delObj = service.update(order);
		
		return ResponseEntity.ok().body("record updated" + " " + delObj);
		
	}
	
	@GetMapping("/{orderId}")
	public List<Order> findByOrderId(@PathVariable("orderId") int id) {
		
		return this.service.findByOrderId(id);
	}
	
	@GetMapping("/list/{user}")
	public List<Order> findByUserName(@PathVariable("user") String user){
		
		return this.service.findByUserName(user);
	}
	
}
