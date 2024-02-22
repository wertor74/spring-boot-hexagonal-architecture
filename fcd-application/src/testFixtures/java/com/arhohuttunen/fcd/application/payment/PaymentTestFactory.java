package com.arhohuttunen.fcd.application.payment;

import com.arhohuttunen.fcd.application.order.Order;

import java.time.LocalDate;

import static com.arhohuttunen.fcd.application.payment.CreditCardTestFactory.aCreditCard;

public class PaymentTestFactory {
    public static Payment aPaymentForOrder(Order order) {
        return new Payment(order.getId(), aCreditCard(), LocalDate.now());
    }
}
