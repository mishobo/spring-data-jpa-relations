package com.husseinabdallah287.springdatajparelationships.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husseinabdallah287.springdatajparelationships.models.Order;
import com.husseinabdallah287.springdatajparelationships.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping("/addOrder")
	public Order createOrder(@Valid @RequestBody Order order ) {
		return orderRepository.save(order);
	}
	
	@GetMapping("/getOrderById/{id}")
	public Optional<Order> getOrderById(@PathVariable(value="id") Long orderId ) {
		return orderRepository.findById(orderId);
	}

}
