package com.example.Microservices.repository;

import com.example.Microservices.model.Order;
import com.example.Microservices.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
