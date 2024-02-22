package com.arhohuttunen.fcd.application;

import com.arhohuttunen.architecture.UseCase;
import com.arhohuttunen.fcd.application.in.BusinessObject;
import com.arhohuttunen.fcd.application.order.Order;
import com.arhohuttunen.fcd.application.out.Orders;

import java.util.UUID;

@UseCase
public class CoffeeMachine implements BusinessObject {
    private final Orders orders;

    public CoffeeMachine(Orders orders) {
        this.orders = orders;
    }

    @Override
    public Order startPreparingOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markBeingPrepared());
    }

    @Override
    public Order finishPreparingOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markPrepared());
    }
}
