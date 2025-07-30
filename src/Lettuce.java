public class Lettuce extends Produce {
    public Lettuce(double price, int quantity) {
        super("Lettuce", price, quantity, "Vegetable");
    }

    @Override
    public String getDescription() {
        return "Fresh, crisp lettuce - perfect for salads and sandwiches";
    }
    
}
