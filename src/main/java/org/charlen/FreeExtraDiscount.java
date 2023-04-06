package org.charlen;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingDouble;

public class FreeExtraDiscount implements DiscountStrategy {

    @Override
    public void apply(Customer customer, List<Item> items) {
        boolean hasBeverage = items.stream().anyMatch(item -> item instanceof Beverage);
        boolean hasSnack = items.stream().anyMatch(item -> item instanceof BaconRoll);

        if (hasBeverage && hasSnack) {
            items.stream().filter(item -> item instanceof ItemDecorator).min(comparingDouble(Item::getPrice)).ifPresent(item -> item.price = 0.0);
        }
    }
}