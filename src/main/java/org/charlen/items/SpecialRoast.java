package org.charlen.items;

public class SpecialRoast extends ItemDecorator {
    public SpecialRoast(Item item) {
        super(item);
        name = "Special Roast";
        price = 0.90;
    }
}