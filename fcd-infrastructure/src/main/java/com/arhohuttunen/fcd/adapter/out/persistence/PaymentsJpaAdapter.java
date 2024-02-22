package com.arhohuttunen.fcd.adapter.out.persistence;

import com.arhohuttunen.fcd.adapter.out.persistence.entity.PaymentEntity;
import com.arhohuttunen.fcd.application.out.Payments;
import com.arhohuttunen.fcd.application.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentsJpaAdapter implements Payments {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment findPaymentByOrderId(UUID orderId) {
        return paymentJpaRepository.findByOrderId(orderId)
                .map(PaymentEntity::toDomain)
                .orElseThrow();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentJpaRepository.save(PaymentEntity.fromDomain(payment)).toDomain();
    }
}
