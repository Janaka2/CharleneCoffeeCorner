package org.charlen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharlenesCoffeeCornerTest {

    @Test
    public void testReceiptTotal() {
        double delta = 0.0001; // maximum delta allowed
        List<Item> items = new ArrayList<>();
        items.add(new Item("Large Coffee", 3.50));
        items.add(new Item("Extra Milk", 0.30));
        items.add(new Item("Small Coffee", 2.50));
        items.add(new Item("Special Roast", 0.90));
        items.add(new Item("Bacon Roll", 4.50));
        items.add(new Item("Orange Juice", 3.95));

        CharlenesCoffeeCorner.Receipt receipt = new CharlenesCoffeeCorner.Receipt(items);
        assertEquals(15.65, receipt.getTotal(), delta);
    }
}
