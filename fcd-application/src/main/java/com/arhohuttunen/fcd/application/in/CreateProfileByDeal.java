package com.arhohuttunen.fcd.application.in;

import com.arhohuttunen.fcd.application.order.Order;
import com.arhohuttunen.fcd.application.payment.CreditCard;
import com.arhohuttunen.fcd.application.payment.Payment;
import com.arhohuttunen.fcd.application.payment.Receipt;

import java.util.UUID;

public interface CreateProfileByDeal {
    Order placeOrder(Order order);
    Order updateOrder(UUID orderId, Order order);
    void cancelOrder(UUID orderId);
    Payment payOrder(UUID orderId, CreditCard creditCard);
    Receipt readReceipt(UUID orderId);
    Order takeOrder(UUID orderId);
}
