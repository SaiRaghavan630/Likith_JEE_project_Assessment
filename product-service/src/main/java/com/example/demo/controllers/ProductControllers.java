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

//import com.example.demo.entity.MobilePlan;
import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/")
@AllArgsConstructor

public class ProductControllers {

	@Autowired 
	private ProductService service;
	
	@GetMapping("/list")
	public List<Product> getAll() {
		
		return this.service.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> add(@RequestBody Product product) {
		
		Product addedObj = service.add(product);
		
		URI location = ServletUriComponentsBuilder
		          .fromCurrentRequest()
		          .path("/{id}").buildAndExpand(product.getProductId())
		          .toUri();
		
	return ResponseEntity.created(location).body(addedObj);
	}
	
	@PutMapping("/save")
		
		public ResponseEntity<String> update(@RequestBody Product product){
			
			Product delObj = service.update(product);
			
			String msg = "record updated";
			
			return ResponseEntity.ok().body("record updated" + " " + delObj);
	}
			
	@GetMapping("/list/{name}")
	
	public List<Product> getProductByMerchant(@PathVariable("name") String merchantName){
		
	   return this.service.findByMerchant(merchantName);
		
	}
	
	@GetMapping("/list/available")
    
	public List<Product> getProductByInventory() {
		
		return this.service.getProductByInventory();
	}
	
	@GetMapping("/list/not-available")
	
	public List<Product> productNotAvailable() {
		
		return this.service.getProductByZeroInventory();
		
	}
	
	}
	

