package com.bansikah.ecommerce.service;

import com.bansikah.ecommerce.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order createOrder(Order order);

    List<Order> findAllOrders();

    Order getOrderById(Long id);

}

