package Client.CLI;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CLICardTest extends TestCase {
private CLICard card;

    @BeforeEach
    public void setUp() {
        card = new CLICard("001", "Sample Card", Arrays.asList("Line1", "Line2"));
    }

    @Test
    public void testCardCreation() {
        assertEquals("001", card.getID());
        assertEquals("Sample Card", card.getDESCRIPTION());
        assertEquals(Arrays.asList("Line1", "Line2"), card.getASCII());
    }

    @Test
    public void testSetID() {
        card.setID("002");
        assertEquals("002", card.getID());
    }

    @Test
    public void testSetDescription() {
        card.setDESCRIPTION("Updated Description");
        assertEquals("Updated Description", card.getDESCRIPTION());
    }

    @Test
    public void testSetASCII() {
        card.setASCII(Arrays.asList("Updated Line1", "Updated Line2"));
        assertEquals(Arrays.asList("Updated Line1", "Updated Line2"), card.getASCII());
    }
}

