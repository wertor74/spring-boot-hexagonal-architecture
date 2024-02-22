package com.arhohuttunen.fcd.adapter.in.rest.resource;

import com.arhohuttunen.fcd.application.order.Order;
import com.arhohuttunen.fcd.shared.Location;

import java.util.List;

public record OrderRequest(Location location, List<LineItemRequest> items) {
    public Order toDomain() {
        return new Order(location, items.stream().map(LineItemRequest::toDomain).toList());
    }
}
