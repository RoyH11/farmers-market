/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import produce.*;

public class App {

    private static Market market = new Market();

    public static void main(String[] args) {
        // Welcome message
        System.out.println("""
                            \n
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

        Util.closeScanner();
        System.out.println("Thank you for visiting the Farmers Market!");

    }

    public static boolean showMainMenu() {
        System.out.println( """
                            \n=== FARMERS MARKET MENU ===
                            1. View Farmers Market
                            2. Create New Stand
                            0. Exit
                            """);
        
        int choice = Util.getIntInput("Enter your choice (0-2): ", 0, 2);

        switch (choice) {
            case 1 -> displayMarket(market);
            case 2 -> createNewStand();
            case 0 -> {
                return false; // exist the program
            }
            default -> System.out.println("Invalid choice. Please enter 0-2.");
        }    
            
        return true; // continue running
    }

    public static void createNewStand() {
        System.out.println("\n=== CREATE NEW STAND ===");

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

        System.out.println("Stand created successfully!");
        System.out.println("New stand: " + stand);
    }

    public static void addProduceToStand(Stand stand) {
        System.out.println("\n=== ADD PRODUCE TO STAND ===");
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

            // get price and quantity, validation handled in Util
            double price = Util.getDoubleInput("Enter price per unit ($): ", 0.0, 99.99);

            int quantity = Util.getIntInput("Enter quantity: ", 0, 999);

            // create produce 
            Produce produce = createProduce(choice, price, quantity);
            stand.addProduce(produce);
            System.out.println("Added " + produce.getName() + " to the stand.");
                
        }
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
