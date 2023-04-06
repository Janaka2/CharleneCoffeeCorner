package org.charlen;

import java.util.List;

public interface DiscountStrategy {
    void apply(Customer customer, List<Item> items);
}