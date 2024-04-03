package com.example.Microservices.controller;


import com.example.Microservices.model.Order;
import com.example.Microservices.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")

public class OrderController {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders (Order order){
        List<Order> allOrders = orderService.findAllOrders();
        return allOrders;
    }
    @GetMapping(path = "{orderId}")
    public Optional<Order> getOrderById(@PathVariable("orderId") Long orderId){
        return orderService.findOrderWithId(orderId);
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Order> getOrdersWithPagination(
            @PathVariable int offset,
            @PathVariable int pageSize)
    {
        Page<Order> ordersWithPagination = orderService.findOrdersWithPagination(offset, pageSize);
        return ordersWithPagination;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order){
        orderService.createNewOrder(order);
    }
}
