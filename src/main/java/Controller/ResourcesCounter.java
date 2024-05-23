package Controller;

import Model.Cards.CardJSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcesCounter {
    private static int mushrooms = 0;
    private static int insects = 0;
    private static int animals = 0;
    private static int plants = 0;

    //TODO: For points to add later feather and potion and scroll
    //TODO: View for seeing how many points I have

    //Once I placed the card I get the resource it gives me
    public static void updateResources(CardJSON cardToRead){
        String[] symbols = {
                cardToRead.getLEFTSYMBOL(),
                cardToRead.getRIGHTSYMBOL(),
                cardToRead.getTOPSYMBOL(),
                cardToRead.getBOTTOMSYMBOL(),
                cardToRead.getSYMBOL()
        };
        for (String symbol : symbols) {
            //updateResourceCount(symbol.toLowerCase());
        }
    }

    //update the count
    private static void updateResourceCount(String symbol) {
        if (symbol.contains("animal")) {
            animals++;
        }
        if (symbol.contains("insect")) {
            insects++;
        }
        if (symbol.contains("plant")) {
            plants++;
        }
        if (symbol.contains("mushroom")) {
            mushrooms++;
        }
    }
    //Check if I have enough resources
    public static boolean canPlaceCard(CardJSON cardToPlace) {
        List<String> requiredResources = cardToPlace.getREQUIRED();
        Map<String, Integer> requiredCount = new HashMap<>();

        // Count occurrences of each required resource
        for (String resource : requiredResources) {
            resource = resource.toLowerCase();
            requiredCount.put(resource, requiredCount.getOrDefault(resource, 0) + 1);
        }

        // Check if available resources meet the required counts
        for (Map.Entry<String, Integer> entry : requiredCount.entrySet()) {
            String resource = entry.getKey();
            int count = entry.getValue();
            if (!hasEnoughResource(resource, count)) {
                return false; //Cannot place card so need to teleport it to the hand
            }
        }
        return true; //Can place card so actually place it there
    }

    private static boolean hasEnoughResource(String resource, int requiredCount) {
        switch (resource) {
            case "animal":
                return animals >= requiredCount;
            case "plant":
                return plants >= requiredCount;
            case "mushroom":
                return mushrooms >= requiredCount;
            case "insect":
                return insects >= requiredCount;
            default:
                return false; // Unknown resource
        }
    }

}
