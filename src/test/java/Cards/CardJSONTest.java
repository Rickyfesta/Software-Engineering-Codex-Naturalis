package Cards;

import Model.Cards.CardJSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardJSONTest {
    private CardJSON card;

    @BeforeEach
    public void setUp() {
        card = new CardJSON();
        card.setID("001");
        card.setCARDTYPE("Sample Card");
        card.setASCII(Arrays.asList("Line1", "Line2"));
        card.setSYMBOL("Sample Symbol");
        card.setPOINTS("10");
        card.setTOPSYMBOL("Top Symbol");
        card.setLEFTSYMBOL("Left Symbol");
        card.setRIGHTSYMBOL("Right Symbol");
        card.setBOTTOMSYMBOL("Bottom Symbol");
        card.setCOLOUR("Red");
        card.setREQUIRED(Arrays.asList("Req1", "Req2"));
    }

    @Test
    public void testCardCreation() {
        assertEquals("001", card.getID());
        assertEquals("Sample Card", card.getCARDTYPE());
        assertEquals(Arrays.asList("Line1", "Line2"), card.getASCII());
        assertEquals("Sample Symbol", card.getSYMBOL());
        assertEquals("10", card.getPOINTS());
        assertEquals("Top Symbol", card.getTOPSYMBOL());
        assertEquals("Left Symbol", card.getLEFTSYMBOL());
        assertEquals("Right Symbol", card.getRIGHTSYMBOL());
        assertEquals("Bottom Symbol", card.getBOTTOMSYMBOL());
        assertEquals("Red", card.getCOLOUR());
        assertEquals(Arrays.asList("Req1", "Req2"), card.getREQUIRED());
    }

    @Test
    public void testSetID() {
        card.setID("002");
        assertEquals("002", card.getID());
    }

    @Test
    public void testSetCARDTYPE() {
        card.setCARDTYPE("Updated Card Type");
        assertEquals("Updated Card Type", card.getCARDTYPE());
    }

    @Test
    public void testSetASCII() {
        card.setASCII(Arrays.asList("Updated Line1", "Updated Line2"));
        assertEquals(Arrays.asList("Updated Line1", "Updated Line2"), card.getASCII());
    }

    @Test
    public void testSetSYMBOL() {
        card.setSYMBOL("Updated Symbol");
        assertEquals("Updated Symbol", card.getSYMBOL());
    }

    @Test
    public void testSetPOINTS() {
        card.setPOINTS("20");
        assertEquals("20", card.getPOINTS());
    }

    @Test
    public void testSetTOPSYMBOL() {
        card.setTOPSYMBOL("Updated Top Symbol");
        assertEquals("Updated Top Symbol", card.getTOPSYMBOL());
    }

    @Test
    public void testSetLEFTSYMBOL() {
        card.setLEFTSYMBOL("Updated Left Symbol");
        assertEquals("Updated Left Symbol", card.getLEFTSYMBOL());
    }

    @Test
    public void testSetRIGHTSYMBOL() {
        card.setRIGHTSYMBOL("Updated Right Symbol");
        assertEquals("Updated Right Symbol", card.getRIGHTSYMBOL());
    }

    @Test
    public void testSetBOTTOMSYMBOL() {
        card.setBOTTOMSYMBOL("Updated Bottom Symbol");
        assertEquals("Updated Bottom Symbol", card.getBOTTOMSYMBOL());
    }

    @Test
    public void testSetCOLOUR() {
        card.setCOLOUR("Blue");
        assertEquals("Blue", card.getCOLOUR());
    }

    @Test
    public void testSetREQUIRED() {
        card.setREQUIRED(Arrays.asList("Updated Req1", "Updated Req2"));
        assertEquals(Arrays.asList("Updated Req1", "Updated Req2"), card.getREQUIRED());
    }
}
