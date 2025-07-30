/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */


import java.util.ArrayList;
import java.util.List;

public class Stand {
    private Farmer farmer;
    private final List<Produce> produceList;

    // constructor - empty stand
    public Stand() {
        this.farmer = null; 
        this.produceList = new ArrayList<>(); 
    }

    // constructor - with a farmer
    public Stand(Farmer farmer) {
        this.farmer = farmer;
        this.produceList = new ArrayList<>();
    }

    // getters
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
}
