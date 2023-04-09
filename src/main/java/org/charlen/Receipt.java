package org.charlen;

import org.charlen.discount.strategies.DiscountStrategy;
import org.charlen.items.Item;
import org.charlen.items.ItemDecorator;

import java.util.List;

public class Receipt {

    private final List<Item> items;
    public double total;

    public Receipt(Customer customer, List<Item> items, List<DiscountStrategy> discountStrategies) {
        this.items = items;
        // Apply discounts
        discountStrategies.forEach(discountStrategy -> discountStrategy.apply(customer, items));
        // Calculate total
        total = items.stream().mapToDouble(Item::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Charlene's Coffee Corner\n");
        sb.append("------------------------\n");

        for (Item item : items) {
            if (item instanceof ItemDecorator) {
                Item decoratedItem = ((ItemDecorator) item).getItem();
                sb.append(decoratedItem.getName()).append(" : ").append(String.format("%.2f", decoratedItem.getPrice())).append(" + ( ").append(item.getName()).append(" : ").append(String.format("%.2f", item.getPrice()-decoratedItem.getPrice())).append(" )").append(" : ").append(String.format("%.2f", item.getPrice())).append(" CHF\n");
            } else {
                sb.append(item.getName()).append(" : ").append(String.format("%.2f", item.getPrice())).append(" CHF\n");
            }
        }

        sb.append("------------------------\n");
        sb.append("Total: ").append(String.format("%.2f", total)).append(" CHF\n");

        return sb.toString();
    }

    public double getTotal() {
        return total;
    }
}