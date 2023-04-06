package org.charlen;

public class Customer {
    int beverageStamps;

    public Customer(int beverageStamps) {
        this.beverageStamps = beverageStamps;
    }

    public void addBeverageStamps(int count) {
        beverageStamps = beverageStamps + count;
    }

    public boolean isFreeCoffee() {
        return beverageStamps % 5 == 0;
    }

    public void useBeverageStamps(int count){
        beverageStamps=beverageStamps-5;
    }

    public int getBeverageStamps() {
        return beverageStamps;
    }
}