package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lumen_orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ser_no")
	int serNo;
	
	@Column(name="order_id")
	int orderId;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="product_id")
	int ProductId;
	

}
