public class Orange extends Produce {
    public Orange(double price, int quantity) {
        super("Orange", price, quantity, "Fruit");
    }

    @Override
    public String getDescription() {
        return "Juicy, sweet oranges - perfect for breakfast or snacking";
    }
    
}
