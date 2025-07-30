/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StandTest {
    
    private Stand emptyStand;
    private Stand standWithFarmer;
    private Farmer farmer1;
    private Farmer farmer2;

    @BeforeEach
    public void setUp() {
        farmer1 = new Farmer("Alice");
        farmer2 = new Farmer("Bob");
        emptyStand = new Stand("Empty Stand");
        standWithFarmer = new Stand("Stand With Farmer", farmer2);
    }

    @Test
    public void testEmptyStandCreation() {
        assertNotNull(emptyStand);
    }

    @Test
    public void testStandWithFarmerCreation() {
        assertNotNull(standWithFarmer);
    }

    @Test
    public void testGetName() {
        assertEquals("Empty Stand", emptyStand.getName());
        assertEquals("Stand With Farmer", standWithFarmer.getName());
    }

    @Test
    public void testGetFarmer() {
        assertNull(emptyStand.getFarmer());
        assertEquals(farmer2, standWithFarmer.getFarmer());
    }

    @Test
    public void testGetProduceList() {
        assertTrue(emptyStand.getProduceList().isEmpty());
        assertTrue(standWithFarmer.getProduceList().isEmpty());
    }
    
    @Test
    public void testSetFarmer() {
        emptyStand.setFarmer(farmer1);
        assertTrue(emptyStand.hasFarmer());
        assertEquals(farmer1, emptyStand.getFarmer());
    }

    @Test
    public void testHasFarmer() {
        assertFalse(emptyStand.hasFarmer());
        assertTrue(standWithFarmer.hasFarmer());
        emptyStand.setFarmer(farmer1);
        assertTrue(emptyStand.hasFarmer());
    }

    @Test
    public void testHasProduce() {
        assertFalse(emptyStand.hasProduce());
        assertFalse(standWithFarmer.hasProduce());

        Produce apple = new Apple(1.50, 10);
        emptyStand.addProduce(apple);
        assertTrue(emptyStand.hasProduce());

        Produce carrot = new Carrot(2.00, 20);
        standWithFarmer.addProduce(carrot);
        assertTrue(standWithFarmer.hasProduce());
    }

    @Test
    public void testAddProduce() {
        emptyStand.setFarmer(farmer1);
        Produce apple = new Apple(1.50, 10);
        emptyStand.addProduce(apple);
        assertTrue(emptyStand.hasProduce());
        assertEquals(1, emptyStand.getProduceList().size());
        assertEquals(apple, emptyStand.getProduceList().get(0));

        Produce carrot = new Carrot(2.00, 20);
        standWithFarmer.addProduce(carrot);
        assertTrue(standWithFarmer.hasProduce());
        assertEquals(1, standWithFarmer.getProduceList().size());
        assertEquals(carrot, standWithFarmer.getProduceList().get(0));

        Produce lettuce = new Lettuce(2.50, 30);
        standWithFarmer.addProduce(lettuce);
        assertEquals(2, standWithFarmer.getProduceList().size());
        assertEquals(lettuce, standWithFarmer.getProduceList().get(1));
    }

    @Test
    public void testRemoveProduce() {
        emptyStand.setFarmer(farmer1);
        Produce apple = new Apple(1.50, 10);
        emptyStand.addProduce(apple);
        assertTrue(emptyStand.hasProduce());
        assertEquals(1, emptyStand.getProduceList().size());
        emptyStand.removeProduce(apple);
        assertFalse(emptyStand.hasProduce());
        assertEquals(0, emptyStand.getProduceList().size());

        Produce carrot = new Carrot(2.00, 20);
        Produce lettuce = new Lettuce(2.50, 30);
        standWithFarmer.addProduce(carrot);
        standWithFarmer.addProduce(lettuce);
        assertTrue(standWithFarmer.hasProduce());
        assertEquals(2, standWithFarmer.getProduceList().size());
        standWithFarmer.removeProduce(carrot);
        assertEquals(1, standWithFarmer.getProduceList().size());
        assertEquals(lettuce, standWithFarmer.getProduceList().get(0));
    }
}
