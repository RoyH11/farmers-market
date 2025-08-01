/**
 * @author Roy Huang
 * @date July 31, 2025
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import produce.*;

public class IntegrationTest {
    
    private Market market;
    private Farmer farmer1;
    private Farmer farmer2;
    private Farmer farmer3;
    private Stand stand1;
    private Stand stand2;
    private Stand stand3;
    
    @BeforeEach
    public void setUp() {
        market = new Market();
        farmer1 = new Farmer("Alice");
        farmer2 = new Farmer("Bob");
        farmer3 = new Farmer("Charlie");
        stand1 = new Stand("Fruit Stand", farmer1);
        stand2 = new Stand("Vegetable Stand", farmer2);
        stand3 = new Stand("Mixed Stand", farmer3);
    }

    @Test
    public void testCompleteMarketWorkflow() {
        // test creating a complete market from scratch

        // 1. Start with empty market
        assertFalse(market.hasStands());

        // 2. Add stands to the market
        market.addStand(stand1);
        market.addStand(stand2);
        market.addStand(stand3);

        assertTrue(market.hasStands());
        assertEquals(3, market.getAllStands().size());

        // 3. Add produce to stands
        stand1.addProduce(new Apple(1.0, 25));
        stand1.addProduce(new Orange(1.25, 30));

        stand2.addProduce(new Carrot(0.75, 50));
        stand2.addProduce(new Lettuce(2.00, 20));

        stand3.addProduce(new Tomato(0.5, 10));
        stand3.addProduce(new Orange(0.6, 15));

        assertEquals(2, stand1.getProduceList().size());
        assertEquals(2, stand2.getProduceList().size());
        assertEquals(2, stand3.getProduceList().size());

        assertEquals("Apple", stand1.getProduceList().get(0).getName());
        assertEquals("Carrot", stand2.getProduceList().get(0).getName());
        assertEquals("Tomato", stand3.getProduceList().get(0).getName());

        assertTrue("Alice".equals(stand1.getFarmer().getName()));
        assertTrue("Bob".equals(stand2.getFarmer().getName()));
        assertTrue("Charlie".equals(stand3.getFarmer().getName()));
    }

    
}
