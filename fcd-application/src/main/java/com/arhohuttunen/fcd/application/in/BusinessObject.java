package com.arhohuttunen.fcd.application.in;

import com.arhohuttunen.fcd.application.order.Order;

import java.util.UUID;

public interface BusinessObject {
    Order startPreparingOrder(UUID orderId);
    Order finishPreparingOrder(UUID orderId);
}
