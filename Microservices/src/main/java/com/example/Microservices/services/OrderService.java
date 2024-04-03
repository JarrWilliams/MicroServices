package com.example.Microservices.services;

import com.example.Microservices.model.Order;
import com.example.Microservices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }
    public Page<Order> findOrdersWithPagination(int offset, int pageSize){
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Order> orders = orderRepository.findAll(pageable);

        return orders;
    }
    public Optional<Order> findOrderWithId (long orderId){
        boolean exists = orderRepository.existsById(orderId);
        if (!exists){
            throw new IllegalStateException("Product with id " + orderId + " does not exist");
        }
        return orderRepository.findById(orderId);
    }
    public void createNewOrder(Order order){
        orderRepository.save(order);
    }


}
