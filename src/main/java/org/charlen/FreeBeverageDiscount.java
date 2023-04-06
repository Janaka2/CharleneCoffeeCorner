package org.charlen;

import java.util.List;

import static java.util.Comparator.comparingDouble;

// Discount strategies
public class FreeBeverageDiscount implements DiscountStrategy {

    @Override
    public void apply(Customer customer, List<Item> items) {
        long coffeeCount = items.stream()
                .filter(item -> item instanceof Beverage)
                .filter(item -> ((Beverage) item).getType() == BeverageType.COFFEE)
                .count();
        customer.addBeverageStamps((int) coffeeCount);

        if (customer.getBeverageStamps() >= 5) {
            items.stream()
                    .filter(item -> item instanceof Beverage)
                    .filter(item -> ((Beverage) item).getType() == BeverageType.COFFEE)
                    .min(comparingDouble(Item::getPrice))
                    .ifPresent(item -> item.price = 0.0);
            customer.useBeverageStamps(5);
        }
    }
}