package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;

@Controller
public class OrderController {

	@Autowired
	private RestTemplate template;
	@Autowired
	private Orders order;
	public OrderController(Orders order) {
		super();
		this.order=order;
	}
	
	@RequestMapping(path = "/orders", method = RequestMethod.GET)
	public String Orders() {
		return "orders";
	}
	
	@GetMapping(path="/orders/showordersbyuser")
	public String ShowOrdersByUser() {
		return "filterordersbyuser";
	}
	
	@PostMapping(path="/orders/showordersbyuser")
	public String ShowOrdersByUser(Model model,@RequestParam("orderedPerson") String orderedPerson) {
		model.addAttribute("list",template.getForObject("http://localhost:5090/list/"+orderedPerson,Orders[].class));
		return "filterordersbyuser";
	}
	
	@GetMapping(path="/orders/showordersbyorderid")
	public String ShowOrderByOrderId() {
		return "filterordersbyid";
	}
	

	@PostMapping(path="/orders/showordersbyorderid")
	public String ShowOrderByOrderId(Model model,@RequestParam("orderId") int id) {
		model.addAttribute("list",template.getForObject("http://localhost:5090/"+id,Orders[].class));
		return "filterordersbyid";
	}
	
	@GetMapping(path = "/orders/add-order")
	public String addOrder(Model model) {
		model.addAttribute("command",order);
		model.addAttribute("list",template.getForObject("http://localhost:4090/list/available",Products[].class));
		return "add-order";
	}
	@RequestMapping(path="/orders/add-order",method = RequestMethod.POST)
	public String addOrder(@ModelAttribute("command") Orders obj,Model model) {
		model.addAttribute("list",template.getForObject("http://localhost:4090/list/available",Products[].class));
		template.postForLocation("http://localhost:5090/save", obj);
		model.addAttribute("message","Order Placed");
		return "add-order";
	}
	
	@GetMapping(path = "/orders/update-order")
	public String updateOrder(Model model) {
		model.addAttribute("command",order);
		model.addAttribute("list",template.getForObject("http://localhost:4090/list/available",Products[].class));
		return "update-order";
	}
	
	@RequestMapping(path="/orders/update-order",method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute("command") Orders obj,Model model) {
		model.addAttribute("list",template.getForObject("http://localhost:4090/list/available",Products[].class));
		template.postForLocation("http://localhost:5090/save", obj);
		model.addAttribute("message","Updated Existing Order");
		return "update-order";
	}
	
	
}
