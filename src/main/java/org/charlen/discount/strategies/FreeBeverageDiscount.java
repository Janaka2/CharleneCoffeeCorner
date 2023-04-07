package org.charlen.discount.strategies;

import org.charlen.*;
import org.charlen.beverages.Beverage;
import org.charlen.enums.BeverageType;
import org.charlen.items.Item;
import org.charlen.items.ItemDecorator;

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

        long beverageWithDecoratorCount = items.stream()
                .filter(item -> item instanceof ItemDecorator)
                .filter(item -> (((ItemDecorator) item).getItem()) instanceof Beverage)
                .filter(item -> ((Beverage) (((ItemDecorator) item).getItem())).getType() == BeverageType.COFFEE)
                .count();
        customer.addBeverageStamps((int) beverageWithDecoratorCount);

        if (customer.getBeverageStamps() >= 5) {
            items.stream()
                    .filter(item -> item instanceof Beverage)
                    .filter(item -> ((Beverage) item).getType() == BeverageType.COFFEE)
                    .min(comparingDouble(Item::getPrice))
                    .ifPresent(item -> item.setPrice(0.0));
            customer.useBeverageStamps(5);
        }
    }
}