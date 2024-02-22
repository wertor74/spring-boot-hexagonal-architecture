package com.arhohuttunen.fcd.config;

import com.arhohuttunen.fcd.application.out.Orders;
import com.arhohuttunen.fcd.application.out.Payments;
import com.arhohuttunen.fcd.application.out.stub.InMemoryOrders;
import com.arhohuttunen.fcd.application.out.stub.InMemoryPayments;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(DomainConfig.class)
public class DomainTestConfig {
    @Bean
    Orders orders() {
        return new InMemoryOrders();
    }

    @Bean
    Payments payments() {
        return new InMemoryPayments();
    }
}
