
import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    // get a string input from user with validation
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Input cannot be empty. " + prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // get an integer input from user with validation
    public static int getIntInput(String prompt, int min, int max) {
        System.out.print(prompt);
        int input = Integer.parseInt(scanner.nextLine().trim());
        while (input < min || input > max) {
            System.out.printf("Input must be between %d and %d. %s", min, max, prompt);
            input = Integer.parseInt(scanner.nextLine().trim());
        }
        return input;
    }

    // get a double input from user with validation
    public static double getDoubleInput(String prompt, double min, double max) {
        System.out.print(prompt);
        double input = Double.parseDouble(scanner.nextLine().trim());
        while (input < min || input > max) {
            System.out.printf("Input must be between %.2f and %.2f. %s", min, max, prompt);
            input = Double.parseDouble(scanner.nextLine().trim());
        }
        return input;
    }

    // close the scanner
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
