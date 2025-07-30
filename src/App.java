/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import produce.*;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Farmers Market App ===\n");

        // create the market
        Market market = new Market();

        // create some farmers
        Farmer farmer1 = new Farmer("Alice");
        Farmer farmer2 = new Farmer("Bob");
        Farmer farmer3 = new Farmer("Charlie");

        // create some stands with farmers
        Stand stand1 = new Stand("Fruit Stand", farmer1);
        Stand stand2 = new Stand("Vegetable Stand", farmer2);
        Stand stand3 = new Stand("Mixed Produce Stand", farmer3);

        // Stock the stands with produce
        stand1.addProduce(new Apple(1.0, 10));
        stand1.addProduce(new Orange(1.5, 20));

        stand2.addProduce(new Carrot(0.5, 30));
        stand2.addProduce(new Lettuce(0.75, 25));
        stand2.addProduce(new Tomato(0.6, 15));

        stand3.addProduce(new Apple(1.2, 5));
        stand3.addProduce(new Carrot(0.8, 10));

        // Add stands to the market
        market.addStand(stand1);
        market.addStand(stand2);
        market.addStand(stand3);

        // Display the market
        displayMarket(market);

    }

    public static void displayMarket(Market market) {
        System.out.println("=== Market Overview ===");
        if (market.hasStands()) {
            for (Stand stand : market.getAllStands()) {
                System.out.println(stand);
            }
        } else {
            System.out.println("No stands available in the market.");
        }
        System.out.println("========================\n");
    }
}
