package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventoryApp {
    public static void main(String[] args) {
        // call method and load the products from the file into the inventory list
        ArrayList<Product> inventory = getInventory();
        Scanner myscanner = new Scanner(System.in);


        System.out.println("""
        ======  Welcome to the Cozy Cafe ======
        ======  What do you want to do? =======
                1- List all products
                2- Lookup a product by its id
                3- Find all products within a 
                price range
                4- Add a new product
                5- Quit the application
        ========================================
        Enter command:""");

        int userInput = myscanner.nextInt();
        // switch cases
        switch (userInput) {
            case 1:
                // List all products
                try {
                    BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
                    String line = bufReader.readLine();
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
                break;
            case 2:
                // Lookup a product by its id
                System.out.println("Please enter the item's id");
                int itemId = myscanner.nextInt();
                for (Product item : inventory) {
                    if (item.getId() == itemId) {
                        System.out.printf("%d %s %.2f%n", item.getId(), item.getName(), item.getPrice());
                    }
                }
                break;
            case 3:
                // Find all products within a price range
                System.out.println("Please enter lowest price range:");
                double lowerPrice = myscanner.nextDouble();
                System.out.println("Please enter higher price range:");
                double higherPrice = myscanner.nextDouble();
                for (Product item : inventory) {
                    if (item.getPrice() <= higherPrice && item.getPrice() >= lowerPrice) {
                        System.out.printf("%d %s %.2f%n", item.getId(), item.getName(), item.getPrice());
                    }
                }
                break;
            case 4:
                // Add a new product
                System.out.println("Please enter item id, name, and price:");
                int addId = myscanner.nextInt();
                String addName = myscanner.nextLine();
                double addPrice = myscanner.nextDouble();
            case 5:
                // Quit the application
                System.out.println("Application ended. Have a good day!");

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
