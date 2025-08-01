
import java.util.Scanner;
import produce.Apple;
import produce.Carrot;
import produce.Lettuce;
import produce.Orange;
import produce.Produce;
import produce.Tomato;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    // get a string input from user with validation
    public static String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    // get an integer input from user with validation
    public static int getIntInput(String prompt, int min, int max) {
        while (true) { 
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input < min || input > max) {
                    System.out.println(String.format("Input must be between %d and %d.", min, max));
                    continue; // prompt again
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // get a double input from user with validation
    public static double getDoubleInput(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            try {
                double input = Double.parseDouble(scanner.nextLine().trim());
                if (input < min || input > max) {
                    System.out.println(String.format("Input must be between %.2f and %.2f.", min, max));
                    continue; // prompt again
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // close the scanner
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
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
