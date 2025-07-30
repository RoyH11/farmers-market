public class Carrot extends Produce {
    public Carrot(double price, int quantity) {
        super("Carrot", price, quantity, "Vegetable");
    }

    @Override
    public String getDescription() {
        return "Crunchy, sweet carrots - perfect for snacking or cooking";
    }
    
}
