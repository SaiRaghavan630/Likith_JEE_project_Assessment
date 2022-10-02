package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Products;

@Controller
public class ProductController {

	@Autowired
	private RestTemplate template;
	@Autowired
	private Products products;
	
	public ProductController(Products products) {
		super();
		this.products =  products;
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String welcomePage() {
		
		return "index";
		
	}
	
	@RequestMapping(path = "/products", method = RequestMethod.GET)
	public String Products() {
		return "products";
	}
	
	@GetMapping(path = "/products/productslist")
	public String getProductsList(Model model) {
		model.addAttribute("list",template.getForObject("http://localhost:4090/list",Products[].class));
		return "productscatalog";
	}
	
	@GetMapping(path = "/products/add-product")
	public String initPage(Model model) {
		model.addAttribute("command",products);
		return "add-product";
	}
	
	@PostMapping(path = "/products/add-product")
	public String onSubmit(@ModelAttribute("command") Products obj,Model model ) {
		template.postForLocation("http://localhost:4090/save", obj);
		model.addAttribute("message","one new product added to catalog");
		System.out.println(obj);
		return "add-product";
	}
	
	@GetMapping(path = "/products/update-product")
	public String initPageUpdate(Model model) {
		model.addAttribute("command",products);
		return "update-product";
	}
	
	@PostMapping(path = "/products/update-product")
	public String onSubmitUpdate(@ModelAttribute("command") Products obj,Model model ) {
		template.postForLocation("http://localhost:4090/save", obj);
		model.addAttribute("message","one new product from catalog updated");
		System.out.println(obj);
		return "update-product";
	}
	
	@GetMapping(path = "/products/showproductbymerchantname")
	public String getProductByMerchantName() {
		return "getproductsbymerchantname";
	}
	
	@PostMapping(path="/products/showproductbymerchantname")
	public String getProductByMerchantName(@RequestParam("merchantName")String merchantName,Model model) {
		model.addAttribute("list",template.getForObject("http://localhost:4090/list/"+merchantName,Products[].class));
		return "getproductsbymerchantname";
	}
	
	
	
	
}
