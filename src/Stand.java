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
        // remove by reference
        produceList.remove(item);
    }

    public void removeProduce(int index) {
        // remove by index
        if (index < 0 || index >= produceList.size()) {
            return; // nothing to remove
        }
        produceList.remove(index);
    }

    // utility methods
    public boolean hasFarmer() {
        return farmer != null;
    }

    public boolean hasProduce() {
        return !produceList.isEmpty();
    }

    public Produce findProduceByName(String name) {
        for (Produce item : produceList) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item; // found the produce
            }
        }
        return null; // not found
    }

    // toString method
    @Override
    public String toString() {
        String farmerInfo = hasFarmer() ? farmer.getName() : "No Farmer";
        String produceInfo = hasProduce() ? produceList.toString() : "No Produce";
        
        return String.format("%-30s %-20s %s", 
            "Stand: " + name, 
            "Farmer: " + farmerInfo, 
            "Produce: " + produceInfo);
    }
}
