package org.charlen.items;

public class FoamedMilk extends ItemDecorator {
    public FoamedMilk(Item item) {
        super(item);
        name = "Foamed Milk";
        price = 0.50;
    }
}