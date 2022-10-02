package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.ProductRepository;


@Service
public class ProductService {
	
	private ProductRepository repo;
	
	@Autowired
	private ProductService(ProductRepository repo) {
		
		super();
	
		this.repo=repo;
		
	}
	
	public Product add(Product obj) {
		
		return this.repo.save(obj);
	}
	
	public List<Product> findAll(){
		
		return this.repo.findAll();
	}
	
	public List<Product> findByMerchant(String name){
		
		return this.repo.findByMerchant(name);
	}
	
	public Product update(Product product) {
		
		return this.repo.save(product);
	}
	
	public List<Product> getProductByInventory(){
		
		return this.repo.getProductByInventory();
	}
	
	public List<Product> getProductByZeroInventory() {
		
		return this.repo.getProductByZeroInventory();
	}
	
	

}
