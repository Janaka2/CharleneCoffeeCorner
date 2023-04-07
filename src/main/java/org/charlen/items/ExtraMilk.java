package org.charlen.items;

public class ExtraMilk extends ItemDecorator {
    public ExtraMilk(Item item) {
        super(item);
        name = "Extra Milk";
        price = 0.30;
    }
}
