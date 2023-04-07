package org.charlen.items;

public class ItemDecorator extends Item {
    private Item item;

    public ItemDecorator(Item item) {
        super(item.name, item.price);
        this.item = item;
    }

    @Override
    public double getPrice() {
        return item.getPrice() + price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}