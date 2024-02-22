package com.arhohuttunen.fcd.application.out;

import com.arhohuttunen.fcd.application.payment.Payment;

import java.util.UUID;

public interface Payments {
    Payment findPaymentByOrderId(UUID orderId);
    Payment save(Payment payment);
}
