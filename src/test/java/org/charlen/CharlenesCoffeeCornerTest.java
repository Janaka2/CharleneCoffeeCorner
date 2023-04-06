//package org.charlen;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CharlenesCoffeeCornerTest {
//
//    @Test
//    public void testReceiptTotal() {
//        List<Item> items = new ArrayList<>();
//        items.add(new Beverage("Small Coffee", 2.50, BeverageType.COFFEE));
//        items.add(new Beverage("Large Coffee", 3.50, BeverageType.COFFEE));
//        items.add(new Beverage("Orange Juice", 3.95, BeverageType.OTHER));
//        items.add(new Item("Bacon Roll", 4.50));
//        items.add(new Item("Extra Milk", 0.30));
//        items.add(new Item("Special Roast", 0.90));
//
//        Receipt receipt = new Receipt(items);
//        assertEquals(14.35, receipt.getTotal());
//    }
//
//    @Test
//    public void testFreeBeverageDiscount() {
//        List<Item> items = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            items.add(new Beverage("Small Coffee", 2.50, Beverage.Type.COFFEE));
//        }
//
//        CharlenesCoffeeCorner.Receipt receipt = new CharlenesCoffeeCorner.Receipt(items);
//        assertEquals(10.00, receipt.getTotal());
//    }
//
//    @Test
//    public void testFreeExtraDiscount() {
//        List<Item> items = new ArrayList<>();
//        items.add(new Item("Bacon Roll", 4.50));
//        items.add(new Item("Extra Milk", 0.30));
//        items.add(new Beverage("Small Coffee", 2.50, Beverage.Type.COFFEE));
//
//        CharlenesCoffeeCorner.Receipt receipt = new CharlenesCoffeeCorner.Receipt(items);
//        assertEquals(6.50, receipt.getTotal());
//    }
//}
