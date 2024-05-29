package Controller;

import Model.Cards.CardJSON;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcesCounter {
    private static int mushrooms = 0;
    private static int insects = 0;
    private static int animals = 0;
    private static int plants = 0;
    private static int potion = 0;
    private static int feather = 0;
    private static int scroll = 0;

    //TODO: For points to add later feather and potion and scroll
    //TODO: View for seeing how many points I have
    /**@ ensures \result >= 0; */
    public static int getFeather() {
        return feather;
    }
    /**@ ensures \result >= 0; */
    public static int getPotion() {
        return potion;
    }
    /**@ ensures \result >= 0; */
    public static int getScroll() {
        return scroll;
    }

    //Once I placed the card I get the resource it gives me
    /**@ requires cardToRead != null;
      @ requires resourceList != null;
      @ ensures resourceList.size() >= 7;
      */
    public static void updateResources(CardJSON cardToRead, List<Text> resourceList){
        String[] symbols = getStrings(cardToRead);
        for (String symbol : symbols) {
            //System.out.println(symbol);
            if(symbol !=null ){
                switch (symbol){
                    case "Animal":
                        //System.out.println("Updating animals");
                        animals++;
                        //System.out.println(animals);
                        resourceList.get(1).setText(String.valueOf(animals));
                        break;
                    case "Plant":
                        plants++;
                        //System.out.println("Updating Plants");
                        //System.out.println(plants);
                        resourceList.get(3).setText(String.valueOf(plants));
                        break;
                    case "Insect":
                        insects++;
                        //System.out.println("Updating insects");
                        resourceList.get(2).setText(String.valueOf(insects));
                        break;
                    case "Mushroom":
                        mushrooms++;
                       //System.out.println("Updating mushrooms");
                        resourceList.get(0).setText(String.valueOf(mushrooms));
                        break;
                    case "Potion":
                        potion++;
                        resourceList.get(4).setText(String.valueOf(potion));
                        break;
                    case "Scroll":
                        scroll++;
                        resourceList.get(6).setText(String.valueOf(scroll));
                        break;
                    case "Feather":
                        feather++;
                        resourceList.get(4).setText(String.valueOf(feather));
                        break;
                }
            }
        }
    }

    //update the count
    /**@ requires cardToPlace != null;
      @ requires resourceList != null;
      @ ensures resourceList.size() >= 7;
      @ ensures (\result == false) ==> (\exists String resource; cardToPlace.getREQUIRED().contains(resource); !hasEnoughResource(resource.toLowerCase(), requiredCount.get(resource.toLowerCase())));
      @ ensures (\result == true) ==> (\forall String resource; cardToPlace.getREQUIRED().contains(resource); hasEnoughResource(resource.toLowerCase(), requiredCount.get(resource.toLowerCase())));
      */
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
    public static boolean canPlaceCard(CardJSON cardToPlace, String losingRes, List<Text> resourceList) {
        List<String> requiredResources = cardToPlace.getREQUIRED();
        //System.out.println(cardToPlace.getREQUIRED());
        Map<String, Integer> requiredCount = new HashMap<>();
        //System.out.println("88: Checking for requirements");
        if(requiredResources!= null){
            //System.out.println("89: This card has some requirements");
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
        }
        if(losingRes!=null){
            switch (losingRes){
                case "Animal":
                    //System.out.println("Updating animals");
                    animals--;
                    //System.out.println(animals);
                    resourceList.get(1).setText(String.valueOf(animals));
                    break;
                case "Plant":
                    plants--;
                    //System.out.println("Updating Plants");
                    //System.out.println(plants);
                    resourceList.get(3).setText(String.valueOf(plants));
                    break;
                case "Insect":
                    insects--;
                    //System.out.println("Updating insects");
                    resourceList.get(2).setText(String.valueOf(insects));
                    break;
                case "Mushroom":
                    mushrooms--;
                    //System.out.println("Updating mushrooms");
                    resourceList.get(0).setText(String.valueOf(mushrooms));
                    break;
                case "Potion":
                    potion--;
                    resourceList.get(4).setText(String.valueOf(potion));
                    break;
                case "Scroll":
                    scroll--;
                    resourceList.get(6).setText(String.valueOf(scroll));
                    break;
                case "Feather":
                    feather--;
                    resourceList.get(4).setText(String.valueOf(feather));
                    break;
            }
        }
        String[] symbolsToAdd = getStrings(cardToPlace);
        for (String symbol : symbolsToAdd) {
            if(symbol !=null ){
                switch (symbol){
                    case "Animal":
                        //System.out.println("Updating animals");
                        animals++;
                        //System.out.println(animals);
                        resourceList.get(1).setText(String.valueOf(animals));
                        break;
                    case "Plant":
                        plants++;
                        //System.out.println("Updating Plants");
                        //System.out.println(plants);
                        resourceList.get(3).setText(String.valueOf(plants));
                        break;
                    case "Insect":
                        insects++;
                        //System.out.println("Updating insects");
                        resourceList.get(2).setText(String.valueOf(insects));
                        break;
                    case "Mushroom":
                        mushrooms++;
                        //System.out.println("Updating mushrooms");
                        resourceList.get(0).setText(String.valueOf(mushrooms));
                        break;
                    case "Potion":
                        potion++;
                        resourceList.get(4).setText(String.valueOf(potion));
                        break;
                    case "Scroll":
                        scroll++;
                        resourceList.get(6).setText(String.valueOf(scroll));
                        break;
                    case "Feather":
                        feather++;
                        resourceList.get(4).setText(String.valueOf(feather));
                        break;
                }
            }
        }
        return true; //Can place card so actually place it there
    }
    /**@ requires resource != null;
         @ ensures \result == (resource.equals("animal") ? animals >= requiredCount
                 : resource.equals("plant") ? plants >= requiredCount
                 : resource.equals("mushroom") ? mushrooms >= requiredCount
                 : resource.equals("insect") ? insects >= requiredCount
                 : false);
         */
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

    /**@ requires cardToRead != null;
         @ ensures \result.length == 7;
         @ ensures \result[0] == cardToRead.getLEFTSYMBOL();
         @ ensures \result[1] == cardToRead.getRIGHTSYMBOL();
         @ ensures \result[2] == cardToRead.getTOPSYMBOL();
         @ ensures \result[3] == cardToRead.getBOTTOMSYMBOL();
         @ ensures \result[4] == (cardToRead.getSYMBOL() != null ? cardToRead.getSYMBOL().split(" \\+ ")[0] : null);
         @ ensures \result[5] == (cardToRead.getSYMBOL() != null && cardToRead.getSYMBOL().split(" \\+ ").length > 1 ? cardToRead.getSYMBOL().split(" \\+ ")[1] : null);
         @ ensures \result[6] == (cardToRead.getSYMBOL() != null && cardToRead.getSYMBOL().split(" \\+ ").length > 2 ? cardToRead.getSYMBOL().split(" \\+ ")[2] : null);
         */
    private static String[] getStrings(CardJSON cardToRead) {
        String[] parts = cardToRead.getSYMBOL() != null ? cardToRead.getSYMBOL().split(" \\+ ") : new String[0];
        String part1 = parts.length > 0 ? parts[0] : null;
        String part2 = parts.length > 1 ? parts[1] : null;
        String part3 = parts.length > 2 ? parts[2] : null;
        return new String[]{
                cardToRead.getLEFTSYMBOL(),
                cardToRead.getRIGHTSYMBOL(),
                cardToRead.getTOPSYMBOL(),
                cardToRead.getBOTTOMSYMBOL(),
                part1,
                part2,
                part3
        };
    }

}
