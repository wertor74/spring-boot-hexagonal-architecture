package com.arhohuttunen.fcd.adapter.in.rest.resource;

import com.arhohuttunen.fcd.application.order.LineItem;
import com.arhohuttunen.fcd.shared.Drink;
import com.arhohuttunen.fcd.shared.Milk;
import com.arhohuttunen.fcd.shared.Size;

public record LineItemResponse(Drink drink, Milk milk, Size size, Integer quantity) {
    public static LineItemResponse fromDomain(LineItem lineItem) {
        return new LineItemResponse(
                lineItem.drink(),
                lineItem.milk(), lineItem.size(), lineItem.quantity()
        );
    }
}
