public class Apple extends Produce {
    public Apple(double price, int quantity) {
        super("Apple", price, quantity, "Fruit");
    }

    @Override
    public String getDescription() {
        return "Fresh, crisp apples - perfect for snacking";
    }
}
