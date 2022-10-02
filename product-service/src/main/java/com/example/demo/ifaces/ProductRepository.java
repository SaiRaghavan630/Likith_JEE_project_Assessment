package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByMerchant(String name);
	
	@Query(value="select * from lumen_products where inventory> 0",nativeQuery=true)
	List<Product> getProductByInventory();
	
	@Query(value="select * from lumen_products where inventory=0",nativeQuery=true)
	List<Product> getProductByZeroInventory();
	

}
