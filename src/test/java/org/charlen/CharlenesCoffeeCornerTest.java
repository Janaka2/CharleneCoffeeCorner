package org.charlen;

import org.charlen.items.beverages.LargeCoffee;
import org.charlen.items.beverages.MediumCoffee;
import org.charlen.discount.strategies.FreeBeverageDiscount;
import org.charlen.discount.strategies.FreeExtraDiscount;
import org.charlen.items.ExtraMilk;
import org.charlen.items.Item;
import org.charlen.items.snacks.BaconRoll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharlenesCoffeeCornerTest {

    @Test
    public void testReceiptTotal() {
        var items = new ArrayList<Item>();
        items.add(new LargeCoffee());
        items.add(new ExtraMilk(new LargeCoffee()));
        Customer customer = new Customer(0);
        var receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));
        System.out.println(receipt);

        assertEquals(7.30, receipt.getTotal());
        assertEquals(2, customer.getBeverageStamps());
    }

    @Test
    public void testFreeBeverageDiscount() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            items.add(new LargeCoffee());
        }

        Customer customer = new Customer(0);
        var receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));

        assertEquals(21.00, receipt.getTotal());
        assertEquals(2, customer.getBeverageStamps());
    }

    @Test
    public void testFreeExtraDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new BaconRoll());
        items.add(new ExtraMilk(new LargeCoffee()));

        Customer customer = new Customer(0);
        var receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));

        assertEquals(8.00, receipt.getTotal());
        assertEquals(1, customer.getBeverageStamps());
    }

    @Test
    public void testBeverageStamps() {
        List<Item> items = new ArrayList<>();

        items.add(new LargeCoffee());
        items.add(new LargeCoffee());

        items.add(new MediumCoffee());
        items.add(new MediumCoffee());

        items.add(new LargeCoffee());

        Customer customer = new Customer(0);
        var receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));

        assertEquals(13.50, receipt.getTotal());
        assertEquals(0, customer.getBeverageStamps());
    }
}
