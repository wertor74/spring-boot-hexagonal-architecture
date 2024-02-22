package com.arhohuttunen.fcd.adapter.in.rest;

import com.arhohuttunen.fcd.adapter.in.rest.resource.PaymentRequest;
import com.arhohuttunen.fcd.adapter.in.rest.resource.PaymentResponse;
import com.arhohuttunen.fcd.application.in.CreateProfileByDeal;
import com.arhohuttunen.fcd.application.payment.CreditCard;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Month;
import java.time.Year;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final CreateProfileByDeal createProfileByDeal;

    @PutMapping("/payment/{id}")
    ResponseEntity<PaymentResponse> payOrder(@PathVariable UUID id, @Valid @RequestBody PaymentRequest request) {
        var payment = createProfileByDeal.payOrder(id,
                new CreditCard(
                        request.cardHolderName(),
                        request.cardNumber(),
                        Month.of(request.expiryMonth()),
                        Year.of(request.expiryYear())
                )
        );
        return ResponseEntity.ok(PaymentResponse.fromDomain(payment));
    }
}
