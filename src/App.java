/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import java.util.Scanner;
import produce.*;

public class App {

    private static Market market = new Market();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                           << WELCOME TO THE FARMERS MARKET APP >>
                           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                           """);

        // initialize with some sample data
        initializeSampleMarket();

        // Main menu loop 
        boolean running = true;
        while (running) {
            running = showMainMenu();
        }

        scanner.close();
        System.out.println("Thank you for visiting the Farmers Market!");

    }

    public static boolean showMainMenu() {
        System.out.println( """
                            \n=== FARMERS MARKET MENU ===
                            1. View Farmers Market
                            2. Create New Stand
                            3. Exit
                            """);
        System.out.print("Enter your choice (1-3): ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1: 
                    displayMarket(market);
                    break;
                case 2:
                    createNewStand();
                    break;
                case 3:
                    return false; // exist the program
                default: 
                    System.out.println("Invalid choice. Please enter 1-3.");    
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a whole number 1-3.");
        }

        return true; // continue running
    }

    public static void createNewStand() {
        System.out.println("\n=== CREATE NEW STAND ===");

        // get stand name
        System.out.print("Enter stand name: ");
        String standName = scanner.nextLine().trim();

        if (standName.isEmpty()) {
            System.out.println("Stand name cannont be empty.");
            return;
        }

        // get farmer name
        System.out.print("Enter farmer name: ");
        String farmerName = scanner.nextLine().trim();

        if (farmerName.isEmpty()) {
            System.out.println("Farmer name cannot be empty.");
            return;
        }

        // create farmer and stand
        Farmer farmer = new Farmer(farmerName);
        Stand stand = new Stand(standName, farmer);

        // add produce to stand
        // addProduceToStand(stand);

        // add stand to market
        market.addStand(stand);

        System.out.println("Stand created successfully!");
        System.out.println("New stand: " + stand);
    }

    public static void initializeSampleMarket() {
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
    }

    public static void displayMarket(Market market) {
        System.out.println("Market Overview");
                
        if (market.hasStands()) {
            for (int i = 0; i < market.getAllStands().size(); i++) {
                Stand stand = market.getStand(i);
                System.out.println((i + 1) + ". " + stand);
            }
        } else {
            System.out.println("No stands available in the market.");
        }
        System.out.println("\n");
    }
}
