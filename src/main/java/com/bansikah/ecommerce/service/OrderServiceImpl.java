package com.bansikah.ecommerce.service;

import com.bansikah.ecommerce.domain.Order;
import com.bansikah.ecommerce.repository.OrderItemRepository;
import com.bansikah.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;  // Assuming you have a ProductService

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // ... business logic for order creation (e.g., calculate total amount, save order items using ProductService)
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
