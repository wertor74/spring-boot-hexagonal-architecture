package com.arhohuttunen.fcd.adapter.out.persistence.config;

import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

public class TransactionalUseCaseExecutor {
    @Transactional
    <T> T executeInTransaction(Supplier<T> execution) {
        return execution.get();
    }
}
