package org.charlen;

public class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        super(item.name, item.price);
        this.item = item;
    }

    @Override
    public double getPrice() {
        return item.getPrice() + price;
    }
}