package com.arhohuttunen.fcd.adapter.in.rest.resource;

import com.arhohuttunen.fcd.application.order.LineItem;
import com.arhohuttunen.fcd.shared.Drink;
import com.arhohuttunen.fcd.shared.Milk;
import com.arhohuttunen.fcd.shared.Size;

public record LineItemRequest(Drink drink, Milk milk, Size size, Integer quantity) {
    public LineItem toDomain() {
        return new LineItem(drink, milk, size, quantity);
    }
}
