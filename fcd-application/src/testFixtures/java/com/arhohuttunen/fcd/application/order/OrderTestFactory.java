package com.arhohuttunen.fcd.application.order;

import com.arhohuttunen.fcd.shared.Drink;
import com.arhohuttunen.fcd.shared.Location;
import com.arhohuttunen.fcd.shared.Milk;
import com.arhohuttunen.fcd.shared.Size;

import java.util.List;

public class OrderTestFactory {
    public static Order anOrder() {
        return new Order(Location.TAKE_AWAY, List.of(new LineItem(Drink.LATTE, Milk.WHOLE, Size.LARGE, 1)));
    }

    public static Order aPaidOrder() {
        return anOrder()
                .markPaid();
    }

    public static Order anOrderInPreparation() {
        return aPaidOrder()
                .markBeingPrepared();
    }

    public static Order aReadyOrder() {
        return anOrderInPreparation()
                .markPrepared();
    }
}
