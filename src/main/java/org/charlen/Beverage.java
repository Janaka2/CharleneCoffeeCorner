package org.charlen;

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
