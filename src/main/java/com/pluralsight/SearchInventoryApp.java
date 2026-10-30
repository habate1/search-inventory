package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventoryApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        for (Product item :inventory) {
            System.out.printf("%d %s %.2f%n", item.getId(), item.getName(), item.getPrice());

        }
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            String line = bufReader.readLine();
            /*
            for each line read from the file:
            split the line into pieces wherever the | character appears
                (store the pieces in a String array called tokens)

            take piece 0 and convert it from text to a whole number -> id
            take piece 1 and keep it as text                        -> name
            take piece 2 and convert it from text to a decimal      -> price

            create a new Product using id, name, price
            add that Product to the inventory list
             */
            //String[] tokens = line.split("\\|");
            while (line != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);

                inventory.add(new Product(id, name, price));

                //System.out.println(line);
                //line.trim();
                line = bufReader.readLine();
            }
            for (Product item : inventory) {
                System.out.printf("%d %s %.2f%n", item.getId(), item.getName(), item.getPrice());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
