package com.pluralsight;

import java.util.ArrayList;

public class SearchInventoryApp {
    public static void main(String[] args) {

    }

    public static ArrayList<Product> getInventory() {
        /*
        create an initial inventory of
        at least 5 products. An ArrayList's size can change and will continue to grow as long
        as you have the energy to place products in the list.
         */

        ArrayList<Product> inventory = new ArrayList<Product>();
        Product latte = new Product(101, "Latte", 4.75);
        Product muffin = new Product(102, "Blueberry muffin", 3.25);
        Product beans = new Product(103, "Bag of coffee beans", 11.99);
        Product mug = new Product(104, "Travel mug", 15.00);
        Product icedTea = new Product(105, "Iced tea", 2.99);

        inventory.add(latte);
        inventory.add(muffin);
        inventory.add(beans);
        inventory.add(mug);
        inventory.add(icedTea);

        return inventory;

    }
}
