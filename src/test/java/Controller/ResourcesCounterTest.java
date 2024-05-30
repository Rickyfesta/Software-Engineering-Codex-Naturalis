package Controller;

import javafx.scene.text.Text;
import junit.framework.TestCase;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ResourcesCounterTest extends TestCase {

    private FakeCardJSON fakeCard;
    private List<Text> resourceList;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        fakeCard = new FakeCardJSON();
        resourceList = Arrays.asList(
                new Text("0"), // Mushrooms
                new Text("0"), // Animals
                new Text("0"), // Insects
                new Text("0"), // Plants
                new Text("0"), // Potions
                new Text("0"), // Feathers
                new Text("0")  // Scrolls
        );

        // Reset static variables before each test
        resetResources();
    }

    private void resetResources() {
        setResourceCounter("mushrooms", 0);
        setResourceCounter("animals", 0);
        setResourceCounter("insects", 0);
        setResourceCounter("plants", 0);
        setResourceCounter("potion", 0);
        setResourceCounter("feather", 0);
        setResourceCounter("scroll", 0);
    }

    private void setResourceCounter(String fieldName, int value) {
        try {
            Field field = ResourcesCounter.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setInt(null, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testUpdateResources() {
        fakeCard.setSymbol("Animal + Plant + Insect");
        fakeCard.setLeftSymbol("Mushroom");
        fakeCard.setRightSymbol(null);
        fakeCard.setTopSymbol(null);
        fakeCard.setBottomSymbol(null);

        ResourcesCounter.updateResources(fakeCard, resourceList);

        assertEquals("1", resourceList.get(0).getText()); // Mushrooms
        assertEquals("1", resourceList.get(1).getText()); // Animals
        assertEquals("1", resourceList.get(2).getText()); // Insects
        assertEquals("1", resourceList.get(3).getText()); // Plants
        assertEquals("0", resourceList.get(4).getText()); // Potions
        assertEquals("0", resourceList.get(5).getText()); // Feathers
        assertEquals("0", resourceList.get(6).getText()); // Scrolls
    }

    public void testCanPlaceCard_NotEnoughResources() {
        fakeCard.setRequired(Arrays.asList("Animal", "Plant"));
        boolean canPlace = ResourcesCounter.canPlaceCard(fakeCard, null, resourceList);
        assertFalse(canPlace);
    }

    public void testCanPlaceCard_EnoughResources() {
        fakeCard.setRequired(Arrays.asList("Animal", "Plant"));

        // Simulate having enough resources
        setResourceCounter("animals", 1);
        setResourceCounter("plants", 1);

        boolean canPlace = ResourcesCounter.canPlaceCard(fakeCard, null, resourceList);
        assertTrue(canPlace);
    }

    public void testGetFeather() {
        assertEquals(0, ResourcesCounter.getFeather());
    }

    public void testGetPotion() {
        assertEquals(0, ResourcesCounter.getPotion());
    }

    public void testGetScroll() {
        assertEquals(0, ResourcesCounter.getScroll());
    }

    public void testUpdateResourceCount() {
        ResourcesCounter.updateResourceCount("animal");
        ResourcesCounter.updateResourceCount("plant");
        ResourcesCounter.updateResourceCount("mushroom");
        ResourcesCounter.updateResourceCount("insect");

        try {
            assertEquals(1, getResourceCounter("animals"));
            assertEquals(1, getResourceCounter("plants"));
            assertEquals(1, getResourceCounter("mushrooms"));
            assertEquals(1, getResourceCounter("insects"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getResourceCounter(String fieldName) throws Exception {
        Field field = ResourcesCounter.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getInt(null);
    }
}
