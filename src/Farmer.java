/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

public class Farmer {
    private final String name;

    // constructor
    public Farmer(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Farmer: %s", name);
    }
}
