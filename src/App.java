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
        System.out.println();
        System.out.println("""
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            << WELCOME TO THE FARMERS MARKET APP >>
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");

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
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");

    }


    public static void initializeSampleMarket() {
        // create some farmers
        Farmer farmer1 = new Farmer("Alice");
        Farmer farmer2 = new Farmer("Bob");
        Farmer farmer3 = new Farmer("Charlie");

        // create some stands with farmers
        Stand stand1 = new Stand("Elliott Farm", farmer1);
        Stand stand2 = new Stand("NacSpace Farm", farmer2);
        Stand stand3 = new Stand("B2B Farm", farmer3);

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
                            ~~~~~~~~~~~~~~~~~~~~~~~~~
                            << FARMERS MARKET MENU >>
                            ~~~~~~~~~~~~~~~~~~~~~~~~~
                            1. View Farmers Market
                            2. Create New Stand
                            3. Remove a Stand
                            4. Visit a Stand
                            5. Search for Produce
                            0. Exit Farmers Market
                            ~~~~~~~~~~~~~~~~~~~~~~~~~""");
        
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
    
    
    // 1st choice: show all stands and details ===============================================================
    public static void displayMarket(Market market) {
        System.out.println();
        System.out.println("=== Market Overview ===");
                
        // display all stands
        if (market.hasStands()) {
            displayAllStands(market);
        } else {
            System.out.println("No stands available in the market.");
        }
        System.out.println("=======================");

    }

    
    // 2nd choice: create a new stand ===============================================================
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
        System.out.println("<< Stand created successfully! >>");
        System.out.println(stand);
    }


    // 3rd choice: remove a stand ===============================================================
    public static void removeAStand() {
        System.out.println();
        System.out.println("=== REMOVE A STAND ===");

        // if no stands, nothing to remove
        if (!market.hasStands()) {
            System.out.println("No stands available to remove.");
            return; // nothing to remove
        }

        // display all stands
        displayAllStands(market);
        System.out.println("0. Cancel removal");
        System.out.println("======================");

        // get stand index to remove
        int maxIndex = market.getAllStands().size();
        int userInput = Util.getIntInput("Enter stand number to remove (0-" + maxIndex + "): ", 0, maxIndex);
        int standIndex = userInput - 1; // convert to zero-based index

        // if user chose to cancel
        if (userInput == 0) {
            return; // nothing to remove
        }

        // remove the stand
        market.removeStand(standIndex);
        
        // display success message
        System.out.println();
        System.out.println("<<< Stand removed successfully! >>>");
        System.out.println("Removed stand at index: " + (userInput));
    }


    // 4rd choice: visit a stand (buy and stock) ===============================================================
    public static void visitAStand() {
        boolean visiting = true;
        while (visiting) {
            System.out.println();
            System.out.println("=== VISIT A STAND ===");

            if (market.hasStands()) {
                // display all stands
                displayAllStands(market);
                System.out.println("0. Exit visit");
                System.out.println("=====================");
            } else {
                System.out.println("No stands available in the market.");
                return; // nothing to visit
            }

            // get user choice, validation handled in Util
            // System.out.println();
            int maxIndex = market.getAllStands().size();
            int userInput = Util.getIntInput("Select a stand to visit (0-" + maxIndex + "): ", 0, maxIndex);
            int standIndex = userInput - 1; // convert to zero-based index

            // done visiting
            if (userInput == 0) {
                visiting = false;
                continue; // exit visit
            }

            // next logic: add produce or remove produce
            standInteraction(market.getStand(standIndex));
        }
    }

    public static void standInteraction(Stand stand) {
        boolean interacting = true;
        while (interacting) {
            System.out.println();
            System.out.println("=== INTERACT WITH STAND ===");
            System.out.println(stand);
            System.out.println("""
                            1. Add/Stock Produce
                            2. Purchae Produce
                            0. Exit Interaction
                            ===========================""");

            // get user choice, validation handled in Util
            int choice = Util.getIntInput("Select an option (0-2): ", 0, 2);
            switch (choice) {
                case 1 -> addProduceToStand(stand);
                case 2 -> removeProduceFromStand(stand);
                case 0 -> {
                    interacting = false; // exit interaction
                    continue;
                }
                default -> {
                    interacting = false; // should not reach here, but just in case
                    continue;
                }
            }
        }
    }


    // 5th choice: search for a produce ===============================================================
    public static void searchForProduce() {
        boolean searching = true;
        while (searching) {
            System.out.println();
            System.out.println("""
                    === SEARCH FOR PRODUCE ===
                    Available produce types:
                    1. Apple
                    2. Orange
                    3. Carrot
                    4. Lettuce
                    5. Tomato
                    0. Exit search
                    ==========================""");

            // get user choice, validation handled in Util
            int choice = Util.getIntInput("Select produce type (0-5): ", 0, 5);

            // done
            if (choice == 0) {
                searching = false; // done searching
                continue;
            }

            // get produce name
            String produceName = getProduceName(choice);

            // desplay search results
            displaySearchResults(produceName);
        }
    }

    public static void displaySearchResults(String produceName) {
        System.out.println();
        System.out.println("=== SEARCH RESULTS FOR " + produceName.toUpperCase() + " ===");

        boolean found = false;

        // search through all stands
        for (int i = 0; i < market.getAllStands().size(); i++) {
            Stand stand = market.getStand(i);
            Produce produce = findProduceByName(stand, produceName);

            // only display if produce is found
            if (produce != null) {
                found = true;
                System.out.println(String.format("%d. %-30s %-20s %s", 
                                                (i + 1),
                                                "Stand: " + stand.getName(), 
                                                "Farmer: " + stand.getFarmer().getName(), 
                                                "Produce: " + produce.toString()));
            }
        }

        if (!found) {
            System.out.println(produceName + " not available in any stand.");
        }
    }


    public static void addProduceToStand(Stand stand) {
        
        boolean addingProduce = true;
        while (addingProduce) {
            System.out.println();
            System.out.println("=== ADD PRODUCE TO STAND ===");
            System.out.println(stand);
            System.out.println("""
                    Available produce types:
                    1. Apple
                    2. Orange
                    3. Carrot
                    4. Lettuce
                    5. Tomato
                    0. Done adding produce
                    ============================""");

            // get user choice, validation handled in Util
            // System.out.println();
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
                System.out.println(produceName + " already exists in the stand.");
                System.out.println(stand);
                
                // provide option to stock, Util handles validation
                // System.out.println();
                int stockQuantity = Util.getIntInput("Enter quantity to stock (current: " + existingProduce.getQuantity() + "): ", 0, 999);

                existingProduce.stock(stockQuantity);
                System.out.println();
                System.out.println("<<< Stocked " + stockQuantity + " " + produceName + " to the stand! >>>");

            } else {
                // get price and quantity, validation handled in Util
                double price = Util.getDoubleInput("Enter price per unit ($): ", 0.0, 99.99);

                int quantity = Util.getIntInput("Enter quantity: ", 0, 999);

                // create produce 
                Produce produce = createProduce(choice, price, quantity);
                stand.addProduce(produce);
                System.out.println();
                System.out.println("<<< Added " + produce.getName() + " to the stand! >>>");
            }

            // display current produce in the stand
            System.out.println(stand);
        }
    }

    public static void removeProduceFromStand(Stand stand) {
        boolean removingProduce = true;
        while (removingProduce) {
            System.out.println();
            System.out.println("=== PURCHASE PRODUCE FROM STAND ===");
            System.out.println(stand);
            
            if (!stand.hasProduce()) {
                System.out.println("No produce available in this stand.");
                return; // nothing to remove
            }

            // display all produce in the stand
            for (int i = 0; i < stand.getProduceList().size(); i++) {
                Produce produce = stand.getProduceList().get(i);
                System.out.println((i + 1) + ". " + produce);
            }
            System.out.println("0. Done purchase produce");
            System.out.println("===================================");

            // get user choice, validation handled in Util
            int maxIndex = stand.getProduceList().size();
            // System.out.println();
            int userInput = Util.getIntInput("Select produce to purchase (0-" + maxIndex + "): ", 0, maxIndex);
            int produceIndex = userInput - 1; // convert to zero-based index

            // done removing
            if (userInput == 0) {
                removingProduce = false; // done removing produce
                continue;
            }

            // ask how many units to remove
            int currentQuantity = stand.getProduceList().get(produceIndex).getQuantity();
            int purchaseQuantity = Util.getIntInput("Enter quantity to purchase (current: " + currentQuantity + "): ", 0, currentQuantity);

            // remove the produce
            Produce produceToRemove = stand.getProduceList().get(produceIndex);
            produceToRemove.buy(purchaseQuantity);

            // if quantity is zero, remove the produce from the stand
            if (produceToRemove.getQuantity() == 0) {
                stand.removeProduce(produceIndex);
            }

            // display success message
            System.out.println();
            System.out.println("<<< Purchased " + purchaseQuantity + " " + produceToRemove.getName() + " from the stand! >>>");

            // display current produce in the stand
            System.out.println(stand);
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

    public static void displayAllStands(Market market) {
        for (int i = 0; i < market.getAllStands().size(); i++) {
            Stand stand = market.getStand(i);
            System.out.println((i + 1) + ". " + stand);
        }
    }

    
}
