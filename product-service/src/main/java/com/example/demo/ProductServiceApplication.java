package com.example.demo;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.example.demo.entity.Product;
//import com.example.demo.ifaces.ProductRepository;


@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
//@Bean
//	
//	public CommandLineRunner runnner() {
//		
//		return new CommandLineRunner() {
//			
//			
//			@Autowired
//			ProductRepository repo;
//			
//			@Override
//			public void run(String... args) throws Exception {
//				
//                repo.save(new Product(1,10,"ram","goodday",120));
//				
//			}
//		}; 
//	}
}
