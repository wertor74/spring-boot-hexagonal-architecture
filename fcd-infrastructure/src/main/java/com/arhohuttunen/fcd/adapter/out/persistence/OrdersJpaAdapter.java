package com.arhohuttunen.fcd.adapter.out.persistence;

import com.arhohuttunen.fcd.adapter.out.persistence.entity.OrderEntity;
import com.arhohuttunen.fcd.application.order.Order;
import com.arhohuttunen.fcd.application.out.OrderNotFound;
import com.arhohuttunen.fcd.application.out.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrdersJpaAdapter implements Orders {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order findOrderById(UUID orderId) {
        return orderJpaRepository.findById(orderId)
                .map(OrderEntity::toDomain)
                .orElseThrow(OrderNotFound::new);
    }

    @Override
    public Order save(Order order) {
        return orderJpaRepository.save(OrderEntity.fromDomain(order)).toDomain();
    }

    @Override
    public void deleteById(UUID orderId) {
        orderJpaRepository.deleteById(orderId);
    }
}
