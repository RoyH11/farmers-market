public abstract class Produce {
	protected String name;
	protected double price;
	protected int quantity;
	protected String type;

	// constructor

	public Produce(String name, double price, int quantity, String type) {
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.type = type;
	}

	// getters
	public String getName() { return name; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	public String getType() { return type; }

	// setters 
	public void setPrice(double price) { this.price = price; }
	public void setQuantity(int quantity) { this.quantity = quantity; }

	// buy method 
	public boolean buy(int amount) {
		if (amount <= quantity && amount > 0) {
			quantity -= amount;
			return true;
		} 
		return false; // Return false if the purchase cannot be made
	}
	
	// stock method
	public void stock(int amount) {
		if (amount > 0) {
			quantity += amount;
		}
	}

	// abstract method - each produce type will implement its own description
	public abstract String getDescription();

	// toString method
	@Override
	public String toString() {
		return String.format("%s - $%.2f per unit (%d units available)", 
			name, price, quantity);
	}

}