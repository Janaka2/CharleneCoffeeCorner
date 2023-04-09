package org.charlen;

import org.charlen.items.beverages.LargeCoffee;
import org.charlen.items.beverages.MediumCoffee;
import org.charlen.items.beverages.OrangeJuice;
import org.charlen.items.beverages.SmallCoffee;
import org.charlen.discount.strategies.FreeBeverageDiscount;
import org.charlen.discount.strategies.FreeExtraDiscount;
import org.charlen.items.ExtraMilk;
import org.charlen.items.FoamedMilk;
import org.charlen.items.Item;
import org.charlen.items.SpecialRoast;
import org.charlen.items.snacks.BaconRoll;

import java.util.ArrayList;
import java.util.List;

public class CharlenesCoffeeCorner {

    public static void main(String[] args) {
        var customer = new Customer(0);

        // First purchase
        var items = new ArrayList<Item>();
        items.add(new LargeCoffee());
        items.add(new ExtraMilk(new LargeCoffee()));
        var receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));
        System.out.println(receipt);

        // Second purchase
        items = new ArrayList<>();
        items.add(new SmallCoffee());
        items.add(new BaconRoll());
        items.add(new SpecialRoast(new SmallCoffee()));
        receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));
        System.out.println(receipt);

        // Third purchase
        items = new ArrayList<>();
        items.add(new LargeCoffee());
        items.add(new SmallCoffee());
        items.add(new OrangeJuice());
        items.add(new BaconRoll());
        items.add(new ExtraMilk(new LargeCoffee()));
        items.add(new SpecialRoast(new SmallCoffee()));
        receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));
        System.out.println(receipt);


        // Forth purchase
        items = new ArrayList<>();
        items.add(new MediumCoffee());
        items.add(new SmallCoffee());
        items.add(new FoamedMilk(new LargeCoffee()));

        items.add(new OrangeJuice());
        items.add(new BaconRoll());
        items.add(new SpecialRoast(new SmallCoffee()));
        receipt = new Receipt(customer, items, List.of(new FreeBeverageDiscount(), new FreeExtraDiscount()));
        System.out.println(receipt);



    }
}