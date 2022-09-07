package com.husseinabdallah287.springdatajparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husseinabdallah287.springdatajparelationships.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findByOrderTrackingNumber(String orderTrackingNumber);
}
