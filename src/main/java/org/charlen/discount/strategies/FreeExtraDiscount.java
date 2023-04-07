package org.charlen.discount.strategies;

import org.charlen.*;
import org.charlen.beverages.Beverage;
import org.charlen.items.Item;
import org.charlen.items.ItemDecorator;
import org.charlen.snacks.BaconRoll;

import java.util.List;

import static java.util.Comparator.comparingDouble;

public class FreeExtraDiscount implements DiscountStrategy {

    @Override
    public void apply(Customer customer, List<Item> items) {
        boolean hasBeverage = items.stream().anyMatch(item -> item instanceof Beverage || (item instanceof ItemDecorator && ((ItemDecorator)item).getItem() instanceof Beverage ));
        boolean hasSnack = items.stream().anyMatch(item -> item instanceof BaconRoll);

        if (hasBeverage && hasSnack) {
            items.stream().filter(item -> item instanceof ItemDecorator).min(comparingDouble(Item::getPrice)).ifPresent(item -> item.setPrice( 0.0));
        }
    }
}