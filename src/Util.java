
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

    // close the scanner
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
