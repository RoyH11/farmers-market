/**
 * @author Roy Huang
 * @date July 30, 2025
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import produce.*;

public class FarmerTest {
    
    private Farmer farmer1;
    private Farmer farmer2;

    @BeforeEach
    public void setUp() {
        farmer1 = new Farmer("Alice");
        farmer2 = new Farmer("Bob");
    }

    @Test
    public void testFarmerCreation() {
        assertEquals("Alice", farmer1.getName());
        assertEquals("Bob", farmer2.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Farmer: Alice", farmer1.toString());
        assertEquals("Farmer: Bob", farmer2.toString());
    }
}