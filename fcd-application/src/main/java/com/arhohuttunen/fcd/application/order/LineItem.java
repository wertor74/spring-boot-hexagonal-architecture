package com.arhohuttunen.fcd.application.order;

import com.arhohuttunen.fcd.shared.Drink;
import com.arhohuttunen.fcd.shared.Milk;
import com.arhohuttunen.fcd.shared.Size;

import java.math.BigDecimal;

public record LineItem(Drink drink, Milk milk, Size size, int quantity) {
    // For simplicity every small drink costs 4.0 and large 5.0
    BigDecimal getCost() {
        var price = BigDecimal.valueOf(4.0);
        if (size == Size.LARGE) {
            price = price.add(BigDecimal.ONE);
        }
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
