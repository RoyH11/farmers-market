/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Market {
    private final List<Stand> stands;

    // constructor
    public Market() {
        this.stands = new ArrayList<>();
    }

    // getters
    public List<Stand> getAllStands() {
        if (stands.isEmpty()) {
            return null;
        }
        return new ArrayList<>(stands);
    }

    public Stand getStand(int index) {
        if (stands.isEmpty() || index < 0 || index >= stands.size()) {
            return null;
        }
        return stands.get(index);
    }

    // stand management methods
    public void addStand(Stand stand) {
        stands.add(stand);
    }

    public void removeStand(Stand stand) {
        // remove by reference
        if (stand == null || !stands.contains(stand)) {
            return; // nothing to remove
        }
        stands.remove(stand);
    }

    public void removeStand(int index) {
        // remove by index
        if ( index < 0 || index >= stands.size()) {
            return; // nothing to remove
        }
        stands.remove(index);
    }

    public void testRemoveAllStands() {
        stands.clear();
    }

    // utility methods
    public boolean hasStands() {
        return !stands.isEmpty();
    }    

}
