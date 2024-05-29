package Cards;


import Model.Cards.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    private Card card;

    @BeforeEach
    public void setUp() {
        card = new Card("Red", "TopSymbol", "LeftSymbol", "RightSymbol", "BottomSymbol", "Resource", "Symbol", 10);
    }

    @Test
    public void testCardCreation() {
        assertEquals("Red", card.getMainResource());
        assertEquals("Resource", card.getType());
        assertEquals(10, card.getPoints());
        assertEquals("TopSymbol", card.getTop());
        assertEquals("LeftSymbol", card.getLeft());
        assertEquals("RightSymbol", card.getRight());
        assertEquals("BottomSymbol", card.getBottom());
        assertNull(card.getSymbol());
    }

    @Test
    public void testGetCorner() {
        assertTrue(card.getCorner("TopSymbol"));
        assertFalse(card.getCorner(null));
    }

    @Test
    public void testGetMainResource() {
        assertEquals("Red", card.getMainResource());
    }

    @Test
    public void testFlipCard() {
        card.FlipCard(false);
        assertTrue(card.isFlipped());
        assertEquals("", card.getTop());
        assertEquals("", card.getLeft());
        assertEquals("", card.getRight());
        assertEquals("", card.getBottom());
        assertEquals("Red", card.getSymbol());

        card.FlipCard(false);
        assertFalse(card.isFlipped());
        assertEquals("TopSymbol", card.getTop());
        assertEquals("LeftSymbol", card.getLeft());
        assertEquals("RightSymbol", card.getRight());
        assertEquals("BottomSymbol", card.getBottom());
        assertNull(card.getSymbol());
    }

}