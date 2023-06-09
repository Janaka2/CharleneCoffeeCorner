package org.charlen.discount.strategies;

import org.charlen.Customer;
import org.charlen.items.Item;

import java.util.List;
@FunctionalInterface
public interface DiscountStrategy {
    void apply(Customer customer, List<Item> items);
}