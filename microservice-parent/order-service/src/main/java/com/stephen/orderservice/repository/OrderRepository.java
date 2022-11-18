package com.stephen.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephen.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}