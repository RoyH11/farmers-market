/**
 * @author Roy Huang
 * @date July 29, 2025
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import produce.*;


public class ProduceTest {
    
    private Apple apple;
    private Carrot carrot;
    private Lettuce lettuce;
    private Orange orange;
    private Tomato tomato;

    @BeforeEach
    public void setUp() {
        apple = new Apple(1.50, 10);
        carrot = new Carrot(1.75, 20);
        lettuce = new Lettuce(2.00, 30);
        orange = new Orange(2.25, 40);
        tomato = new Tomato(2.50, 50);
    }

    @Test
    public void testProduceCreation() {
        assertEquals("Apple", apple.getName());
        assertEquals(1.50, apple.getPrice(), 0.01);
        assertEquals(10, apple.getQuantity());
        assertEquals("Fruit", apple.getType());

        assertEquals("Carrot", carrot.getName());
        assertEquals(1.75, carrot.getPrice(), 0.01);
        assertEquals(20, carrot.getQuantity());
        assertEquals("Vegetable", carrot.getType());

        assertEquals("Lettuce", lettuce.getName());
        assertEquals(2.00, lettuce.getPrice(), 0.01);
        assertEquals(30, lettuce.getQuantity());
        assertEquals("Vegetable", lettuce.getType());
        
        assertEquals("Orange", orange.getName());
        assertEquals(2.25, orange.getPrice(), 0.01);
        assertEquals(40, orange.getQuantity());
        assertEquals("Fruit", orange.getType());

        assertEquals("Tomato", tomato.getName());
        assertEquals(2.50, tomato.getPrice(), 0.01);
        assertEquals(50, tomato.getQuantity());
        assertEquals("Vegetable", tomato.getType());
    }

    @Test
    public void testBuyProduce() {
        assertTrue(apple.buy(5));
        assertEquals(5, apple.getQuantity());
        

        assertFalse(carrot.buy(25)); // Not enough quantity
        assertTrue(carrot.buy(15));
        assertEquals(5, carrot.getQuantity());

        assertTrue(lettuce.buy(10));
        assertEquals(20, lettuce.getQuantity());

        assertFalse(orange.buy(0)); // Invalid amount
        assertTrue(orange.buy(10));
        assertEquals(30, orange.getQuantity());

        assertTrue(tomato.buy(20));
        assertEquals(30, tomato.getQuantity());
    }

    @Test
    public void testStockProduce() {
        apple.stock(5);
        assertEquals(15, apple.getQuantity());

        carrot.stock(10);
        assertEquals(30, carrot.getQuantity());

        lettuce.stock(20);
        assertEquals(50, lettuce.getQuantity());

        orange.stock(0);
        assertEquals(40, orange.getQuantity()); // No change

        tomato.stock(-5);
        assertEquals(50, tomato.getQuantity()); // No change for negative stock
    }

    // @Test
    // public void testToString() {
    //     assertEquals("Apple - $1.50 (10)", apple.toString());
    //     assertEquals("Carrot - $1.75 (20)", carrot.toString());
    //     assertEquals("Lettuce - $2.00 (30)", lettuce.toString());
    //     assertEquals("Orange - $2.25 (40)", orange.toString());
    //     assertEquals("Tomato - $2.50 (50)", tomato.toString());
    // }

    // @Test
    // public void testToStringAfterBuyAndStock() {
    //     apple.buy(2);
    //     apple.stock(5);
    //     assertEquals("Apple - $1.50 (13)", apple.toString());

    //     carrot.buy(0);
    //     carrot.stock(10);
    //     assertEquals("Carrot - $1.75 (30)", carrot.toString());

    //     lettuce.buy(15);
    //     lettuce.stock(10);
    //     assertEquals("Lettuce - $2.00 (25)", lettuce.toString());

    //     orange.buy(100);
    //     orange.stock(5);
    //     assertEquals("Orange - $2.25 (45)", orange.toString());

    //     tomato.buy(30);
    //     tomato.stock(-5);
    //     assertEquals("Tomato - $2.50 (20)", tomato.toString());
    // }

}