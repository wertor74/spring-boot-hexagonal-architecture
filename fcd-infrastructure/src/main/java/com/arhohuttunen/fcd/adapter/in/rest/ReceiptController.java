package com.arhohuttunen.fcd.adapter.in.rest;

import com.arhohuttunen.fcd.adapter.in.rest.resource.OrderResponse;
import com.arhohuttunen.fcd.adapter.in.rest.resource.ReceiptResponse;
import com.arhohuttunen.fcd.application.in.CreateProfileByDeal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ReceiptController {
    private final CreateProfileByDeal createProfileByDeal;

    @GetMapping("/receipt/{id}")
    ResponseEntity<ReceiptResponse> readReceipt(@PathVariable UUID id) {
        var receipt = createProfileByDeal.readReceipt(id);
        return ResponseEntity.ok(ReceiptResponse.fromDomain(receipt));
    }

    @DeleteMapping("/receipt/{id}")
    ResponseEntity<OrderResponse> completeOrder(@PathVariable UUID id) {
        var order = createProfileByDeal.takeOrder(id);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }
}
