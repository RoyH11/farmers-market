
import java.util.Scanner;

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
}
