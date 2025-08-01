/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import java.util.List;
import produce.*;

public class App {

    private static Market market = new Market();

    public static void main(String[] args) {
        // Welcome message
        System.out.println();
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

        // Close the scanner
        Util.closeScanner();

        // Exit message
        System.out.println();
        System.out.println("""
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            << Good Bye! Thank you for visiting the Farmers Market! >>
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            """);

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


    public static boolean showMainMenu() {
        System.out.println();
        System.out.println( """
                            === FARMERS MARKET MENU ===
                            1. View Farmers Market
                            2. Create New Stand
                            3. Remove a Stand
                            4. Visit a Stand
                            5. Search for Produce
                            0. Exit
                            """);
        
        int choice = Util.getIntInput("Enter your choice (0-5): ", 0, 5);

        switch (choice) {
            case 1 -> displayMarket(market);
            case 2 -> createNewStand();
            case 3 -> removeAStand();
            case 4 -> visitAStand();
            case 5 -> searchForProduce();
            case 0 -> {
                return false; // exist the program
            }
            default -> {
                return true; // should not reach here, but just in case
            }
        }    
            
        return true; // continue running
    }
    
    
    // 1st choice ===============================================================
    public static void displayMarket(Market market) {
        System.out.println();
        System.out.println("=== Market Overview ===");
                
        if (market.hasStands()) {
            for (int i = 0; i < market.getAllStands().size(); i++) {
                Stand stand = market.getStand(i);
                System.out.println((i + 1) + ". " + stand);
            }
        } else {
            System.out.println("No stands available in the market.");
        }
    }

    
    // 2nd choice ===============================================================
    public static void createNewStand() {
        System.out.println();
        System.out.println("=== CREATE NEW STAND ===");

        // get stand name
        String standName = Util.getStringInput("Enter stand name: ");

        // get farmer name
        String farmerName = Util.getStringInput("Enter farmer name: ");
        
        // create farmer and stand
        Farmer farmer = new Farmer(farmerName);
        Stand stand = new Stand(standName, farmer);

        // add produce to stand
        addProduceToStand(stand);

        // add stand to market
        market.addStand(stand);

        // display success message
        System.out.println();
        System.out.println("=== Stand created successfully! ===");
        System.out.println("New " + stand);
    }


    // 3rd choice ===============================================================
    public static void removeAStand() {
        displayMarket(market);
        System.out.println();
        System.out.println("=== REMOVE A STAND ===");

        // if no stands, nothing to remove
        if (!market.hasStands()) {
            System.out.println("No stands available to remove.");
            return; // nothing to remove
        }

        // get stand index to remove
        int maxIndex = market.getAllStands().size();
        int userInput = Util.getIntInput("Enter stand number to remove (1-" + maxIndex + "): ", 1, maxIndex);
        int standIndex = userInput - 1; // convert to zero-based index

        // remove the stand
        market.removeStand(standIndex);
        
        // display success message
        System.out.println();
        System.out.println("=== Stand removed successfully! ===");
        System.out.println("Removed stand at index: " + (userInput));
    }


    // 4rd choice ===============================================================
    public static void visitAStand() {
        displayMarket(market);
        System.out.println();
        System.out.println("=== VISIT A STAND ===");
    }


    // 5th choice ===============================================================
    public static void searchForProduce() {
        System.out.println();
        System.out.println("=== SEARCH FOR PRODUCE ===");
    }

    public static void addProduceToStand(Stand stand) {
        System.out.println();
        System.out.println("=== ADD PRODUCE TO STAND ===");
        boolean addingProduce = true;
        while (addingProduce) {
            System.out.println("""
                    Available produce types:
                    1. Apple
                    2. Orange
                    3. Carrot
                    4. Lettuce
                    5. Tomato
                    0. Done adding produce
                    """);

            // get user choice, validation handled in Util
            int choice = Util.getIntInput("Select produce type (0-5): ", 0, 5);

            // done
            if (choice == 0) {
                addingProduce = false; // done adding produce
                continue;
            }

            // check if produce is already in the stand
            String produceName = getProduceName(choice);
            Produce existingProduce = findProduceByName(stand, produceName);

            // if produce already exists, just show the existing produce
            if (existingProduce != null) {
                System.out.println();
                System.out.println("Produce already exists in the stand: " + existingProduce);
                System.out.println();
                continue; // skip to next iteration
            }

            // get price and quantity, validation handled in Util
            double price = Util.getDoubleInput("Enter price per unit ($): ", 0.0, 99.99);

            int quantity = Util.getIntInput("Enter quantity: ", 0, 999);

            // create produce 
            Produce produce = createProduce(choice, price, quantity);
            stand.addProduce(produce);
            System.out.println();
            System.out.println("Added " + produce.getName() + " to the stand.");

            // display current produce in the stand
            List<Produce> currentProduces = stand.getProduceList();
            System.out.println("Current produce in the stand: " + currentProduces);
            System.out.println();
        }
    }

    public static String getProduceName(int choice) {
        return switch (choice) {
            case 1 -> "Apple";
            case 2 -> "Orange";
            case 3 -> "Carrot";
            case 4 -> "Lettuce";
            case 5 -> "Tomato";
            default -> null; // should not reach here, but just in case
        };
    }

    public static Produce findProduceByName(Stand stand, String name) {
        for (Produce item : stand.getProduceList()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item; // found existing produce
            }
        }
        return null; // not found
    }

    public static Produce createProduce(int choice, double price, int quantity) {
        return switch (choice) {
            case 1 -> new Apple(price, quantity);
            case 2 -> new Orange(price, quantity);
            case 3 -> new Carrot(price, quantity);
            case 4 -> new Lettuce(price, quantity);
            case 5 -> new Tomato(price, quantity);
            default -> null; // should not reach here, but just in case
        }; 
    }

    
}
