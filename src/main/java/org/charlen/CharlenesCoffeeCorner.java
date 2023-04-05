package org.charlen;

import java.util.ArrayList;
import java.util.List;

public class CharlenesCoffeeCorner {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Large Coffee", 3.50));
        items.add(new Item("Extra Milk", 0.30));
        items.add(new Item("Small Coffee", 2.50));
        items.add(new Item("Special Roast", 0.90));
        items.add(new Item("Bacon Roll", 4.50));
        items.add(new Item("Orange Juice", 3.95));

        Receipt receipt = new Receipt(items);
        System.out.println(receipt);
    }

    public static class Receipt {
        private final List<Item> items;
        private double total;

        public Receipt(List<Item> items) {
            this.items = items;
            calculateTotal();
        }

        private void calculateTotal() {
            total = 0;
            for (Item item : items) {
                total += item.getPrice();
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Charlene's Coffee Corner\n");
            sb.append("------------------------\n");

            for (Item item : items) {
                sb.append(String.format("%-20s %6.2f CHF\n", item.getName(), item.getPrice()));
            }

            sb.append("------------------------\n");
            sb.append(String.format("Total: %15.2f CHF\n", total));

            return sb.toString();
        }
        public double getTotal() {
            return total;
        }
    }
}
