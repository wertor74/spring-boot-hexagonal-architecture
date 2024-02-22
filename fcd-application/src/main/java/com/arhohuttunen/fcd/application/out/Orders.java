package com.arhohuttunen.fcd.application.out;

import com.arhohuttunen.fcd.application.order.Order;

import java.util.UUID;

public interface Orders {
    Order findOrderById(UUID orderId) throws OrderNotFound;
    Order save(Order order);
    void deleteById(UUID orderId);
}
