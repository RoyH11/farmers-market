/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import produce.*;

public class MarketTest {
    
    private Market market;
    private Stand stand1;
    private Stand stand2;
    private Farmer farmer1;
    private Farmer farmer2;

    @BeforeEach
    public void setUp() {
        market = new Market();
        farmer1 = new Farmer("Alice");
        farmer2 = new Farmer("Bob");
        stand1 = new Stand("Stand 1", farmer1);
        stand2 = new Stand("Stand 2", farmer2);
    }

    @Test
    public void testEmptyMarketCreation() {
        assertNotNull(market);
        assertNull(market.getAllStands());
        assertFalse(market.hasStands());
    }

    @Test
    public void testAddStand() {
        market.addStand(stand1);
        assertTrue(market.hasStands());
        assertEquals(1, market.getAllStands().size());
        assertEquals(stand1, market.getStand(0));
    }

    @Test
    public void testAddMultipleStands() {
        market.addStand(stand1);
        market.addStand(stand2);
        assertTrue(market.hasStands());
        assertEquals(2, market.getAllStands().size());
        assertEquals(stand1, market.getStand(0));
        assertEquals(stand2, market.getStand(1));
    }

    @Test
    public void testRemoveStand() {
        market.addStand(stand1);
        market.addStand(stand2);

        market.removeStand(stand1);
        assertEquals(1, market.getAllStands().size());
        assertEquals(stand2, market.getStand(0));
    }

    @Test
    public void testRemoveStandByIndex() {
        market.addStand(stand1);
        market.addStand(stand2);

        market.removeStand(0); // Remove first stand
        assertEquals(1, market.getAllStands().size());
        assertEquals(stand2, market.getStand(0));
    }

    @Test
    public void testRemoveAllStands() {
        market.addStand(stand1);
        market.addStand(stand2);

        market.testRemoveAllStands();
        assertFalse(market.hasStands());
        assertNull(market.getAllStands());
    }

    @Test
    public void testRemoveStandFromEmptyMarket() {
        market.removeStand(stand1); // Should not throw an error
        assertFalse(market.hasStands());
        assertNull(market.getAllStands());

        market.removeStand(0); // Should not throw an error
        assertFalse(market.hasStands());
        assertNull(market.getAllStands());
    }

    @Test
    public void testRemoveStandByInvalidIndex() {
        market.addStand(stand1);
        market.removeStand(1); // Invalid index, should not throw an error
        assertEquals(1, market.getAllStands().size());
        assertEquals(stand1, market.getStand(0));

        market.removeStand(-1); // Negative index, should not throw an error
        assertEquals(1, market.getAllStands().size());
        assertEquals(stand1, market.getStand(0));
    }

    @Test
    public void testGetStandByIndex() {
        market.addStand(stand1);
        market.addStand(stand2);
        assertEquals(stand1, market.getStand(0));
        assertEquals(stand2, market.getStand(1));
    }

    @Test
    public void testGetStandByInvalidIndex() {
        market.addStand(stand1);
        assertNull(market.getStand(1)); // Index out of bounds
        assertNull(market.getStand(-1)); // Negative index
    }

    @Test
    public void testGetStandFromEmptyMarket() {
        assertNull(market.getStand(0)); // Should return null if no stands exist
    }

    @Test
    public void testGetAllStandsFromEmptyMarket() {
        assertNull(market.getAllStands()); // Should return null if no stands exist
    }

    @Test
    public void testGetAllStandsReturnsDefensiveCopy() {
        market.addStand(stand1);
        List<Stand> stands = market.getAllStands();
        assertNotSame(stands, market.getAllStands()); // Should return a new list
        assertEquals(1, stands.size());
        assertEquals(stand1, stands.get(0));

        stands.clear();
        assertTrue(market.hasStands()); // Original market should still have stands
        assertEquals(1, market.getAllStands().size());
    }
    
    @Test
    public void testHasStands() {
        assertFalse(market.hasStands()); // Initially no stands
        market.addStand(stand1);
        assertTrue(market.hasStands()); // After adding a stand
        market.removeStand(stand1);
        assertFalse(market.hasStands()); // After removing the stand
    }
}
