package org.charlen.items.beverages;

import org.charlen.enums.BeverageType;
import org.charlen.items.Item;

public class Beverage extends Item {
    BeverageType type;

    public Beverage(String name, double price, BeverageType type) {
        super(name, price);
        this.type = type;
    }

    public BeverageType getType() {
        return type;
    }
}
