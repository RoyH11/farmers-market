/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */


import java.util.ArrayList;
import java.util.List;
import produce.*;

public class Stand {
    private final String name; 
    private Farmer farmer;
    private final List<Produce> produceList;

    // constructor - empty stand
    public Stand(String name) {
        this.name = name;
        this.farmer = null; 
        this.produceList = new ArrayList<>(); 
    }

    // constructor - with a farmer
    public Stand(String name, Farmer farmer) {
        this.name = name;
        this.farmer = farmer;
        this.produceList = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public List<Produce> getProduceList() {
        return produceList;
    }

    // setters 
    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    // produce management
    public void addProduce(Produce item) {
        produceList.add(item);
    }

    public void removeProduce(Produce item) {
        produceList.remove(item);
    }

    // utility methods
    public boolean hasFarmer() {
        return farmer != null;
    }

    public boolean hasProduce() {
        return !produceList.isEmpty();
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stand: ").append(name);

        if (hasFarmer()) {
            sb.append(", Farmer: ").append(farmer.getName());
        } else {
            sb.append(", No Farmer Assigned");
        }

        if (hasProduce()) {
            sb.append(", Produce: ").append(produceList);
        } else {
            sb.append(", No Produce Available");
        }

        return sb.toString();
    }
}
