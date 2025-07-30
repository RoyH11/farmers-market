public class Tomato extends Produce{
    public Tomato(double price, int quantity) {
        super("Tomato", price, quantity, "Vegetable");
    }

    @Override
    public String getDescription() {
        return "Ripe, juicy tomatoes - great for salads";
    }
}
