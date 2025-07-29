import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    public void testBasicAssertion() {
        assertEquals(2, 1 + 1);
        assertTrue(true);
        assertFalse(false);
        System.out.println("Junit is working!");
    }
}