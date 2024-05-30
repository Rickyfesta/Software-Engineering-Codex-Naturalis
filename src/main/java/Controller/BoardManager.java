package Controller;
//This class reads if a position of a image view is actually usable for a card to be placed.

import Model.Cards.CardJSON;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Client.GUI.SceneControllers.GameBoard.MyPoints;
import static Client.GUI.SceneControllers.GameBoard.imageViewList;

public class BoardManager {
    public static Map<String, Point> Board = new HashMap<>(); // Map to track board
    //Want to do a list of the imageView already present on the board, so that if a card wants to be placed on one of them but it's not there it's rip.
    public static Map<String, Point> availableCorners = new HashMap<>();

    static int PointCounter = 0;

//For the points


    /**@ requires startingCard != null;
     @ requires resourceList != null;
     @ ensures Board != null;
     @ ensures availableCorners != null;
     @ ensures occupiedCorner == 0;
     @ ensures \forall ImageView imageView; imageViewList.contains(imageView);
     @ ensures \forall String id; availableCorners.containsKey(id) ==> availableCorners.get(id) != null;
     */
    public static void initializeBoard(CardJSON startingCard, List<Text> resourceList){
        //Initialize the board: put everything inside of it, the availableCorners function will make me know if i can place on it.

        for (ImageView imageView : imageViewList) {
            int x = 0, y = 0;
            //System.out.println(imageView);
            if (imageView.getId().equals("StartingCard")) {
                x = 0;
                y = 0;
            }else{
                String pattern = "(Left|Right|Up|Down)(\\d+)";

                // Compile the pattern
                Pattern compiledPattern = Pattern.compile(pattern);

                // Create a matcher for the input string
                Matcher matcher = compiledPattern.matcher(imageView.getId());
                // Iterate over all matches
                while (matcher.find()) {
                    // Group 1 is the direction
                    String direction = matcher.group(1);

                    // Group 2 is the number
                    int number = Integer.parseInt(matcher.group(2));

                    // Update x and y based on direction
                    switch (direction) {
                        case "Left":
                            x -= number;
                            break;
                        case "Right":
                            x += number;
                            break;
                        case "Up":
                            y += number;
                            break;
                        case "Down":
                            y -= number;
                            break;
                    }
                }
                if (imageView.getId().equals("StartingCard")) {
                    Board.put(startingCard.getID(), new Point(x, y));
                }else{
                    Board.put(imageView.getId(), new Point(x, y));
                }

            }
            //System.out.println("Just putted in the board the following: " +Board.get((new Point(x,y))));
        }
        //System.out.println("Here's what is on the starting position of the board: " +Board.get(target));
        //now i create for the starting card the coordinates of his corners, to be able to place a card on
        updateResources(startingCard, resourceList);
        String id = startingCard.getID();
        String topRight = startingCard.getTOPSYMBOL();
        String bottomLeft = startingCard.getBOTTOMSYMBOL();
        String topLeft = startingCard.getLEFTSYMBOL();
        String bottomRight = startingCard.getRIGHTSYMBOL();
        /* System.out.println(topRight);
        System.out.println(bottomRight);
        System.out.println(topLeft);
        System.out.println(bottomLeft);
        */
        if(topRight != null){
            Point topRightCoordinates = new Point(0,1);
            availableCorners.put(id +" topRight", topRightCoordinates);
            //id is in form S01 ecc
            //System.out.println("Available Corners: " + id + "  " + availableCorners.get(id + " topRight"));
            //System.out.println(availableCorners.get(id +" topRight"));
            //System.out.println("hello1");
        }
        if(bottomRight != null){
            Point bottomRightCoordinates = new Point(1,0);
            availableCorners.put(id +" bottomRight", bottomRightCoordinates);
            //System.out.println("hello2");
            //System.out.println("Available Corners: " + id + "  " + availableCorners.get(id + " bottomRight"));
        }
        if(topLeft != null){
            Point topLeftCoordinates = new Point(-1,0);
            availableCorners.put(id +" topLeft", topLeftCoordinates);
            //System.out.println("hello3");
            //System.out.println("Available Corners: " + id + "  " + availableCorners.get(id + " topLeft"));
        }
        if(bottomLeft != null){
            Point bottomLeftCoordinates = new Point(0,-1);
            availableCorners.put(id +" bottomLeft", bottomLeftCoordinates);
            //System.out.println("hello4");
            //System.out.println("Available Corners: " + id + "  " + availableCorners.get(id + " bottomLeft"));
        }
        //System.out.println("Available Corners: " + id + "  " + availableCorners.get(id + " topRight"));
        //System.out.println(availableCorners.containsKey(id+ " topRight"));
    }


    static Point coordinates = new Point(0,0);

    /**@ requires destination != null;
      @ requires wantToBePlaced != null;
      @ requires corner != null;
      @ requires resourcesList != null;
      @ ensures Board.containsKey(wantToBePlaced.getID());
      @ ensures availableCorners.containsKey(wantToBePlaced.getID() + " topLeft") == (wantToBePlaced.getLEFTSYMBOL() != null && !corner.equals("bottomRight"));
      @ ensures availableCorners.containsKey(wantToBePlaced.getID() + " topRight") == (wantToBePlaced.getTOPSYMBOL() != null && !corner.equals("bottomLeft"));
      @ ensures availableCorners.containsKey(wantToBePlaced.getID() + " bottomLeft") == (wantToBePlaced.getBOTTOMSYMBOL() != null && !corner.equals("topRight"));
      @ ensures availableCorners.containsKey(wantToBePlaced.getID() + " bottomRight") == (wantToBePlaced.getRIGHTSYMBOL() != null && !corner.equals("topLeft"));
      @ ensures addPoint(wantToBePlaced, occupiedCorner);
      */
    public static boolean Place(CardJSON destination, CardJSON wantToBePlaced, String corner, List<Text> resourcesList){
        int occupiedCorner = 0;

        //System.out.println("BOARD MANAGER 143: This is the destination card " +destination.getID());

        if(destination.getID().startsWith("S")){//I'm on the starting card
            //Here everything is ok
            //System.out.println("100  " +availableCorners.get(destination.getID() + " topRight"));
            switch (corner){
                case "topLeft":
                    coordinates.x--;
                    if (placingTopLeft(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    //System.out.println("Why topLeft?");
                    break;
                case "bottomLeft":
                    coordinates.y--;
                    if (placingBottomLeft(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    //System.out.println("Why bottomLeft?");
                    break;
                case "topRight":
                    coordinates.y++;
                    if (placingTopRight(destination, wantToBePlaced, corner, resourcesList, coordinates)) return false;
                    //System.out.println("Correct");
                    break;
                case "bottomRight":
                    coordinates.x++;
                    if (PlacingBottomRight(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    //System.out.println("Why bottomRight?");
                    break;
            }
            //Now I update the available corners, adding the ones coming from the card i just placed and removing the others
            String topLeft = wantToBePlaced.getLEFTSYMBOL();
            String topRight = wantToBePlaced.getTOPSYMBOL();
            String bottomLeft = wantToBePlaced.getBOTTOMSYMBOL();
            String bottomRight = wantToBePlaced.getRIGHTSYMBOL();
            //System.out.println(destination.getID());
            if(topLeft != null && !corner.equals("bottomRight")){
                availableCorners.put(wantToBePlaced.getID() +" topLeft", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()-1), (int) availableCorners.get(destination.getID() + " " +corner).getY()));
                //System.out.println("BOARD MANAGER 181: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " topLeft"));
            }
            if(topRight != null && !corner.equals("bottomLeft")){
                availableCorners.put(wantToBePlaced.getID() +" topRight", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()), (int) availableCorners.get(destination.getID() + " " +corner).getY()+1));
                //System.out.println("BOARD MANAGER 185: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " topRight"));
            }
            if(bottomLeft != null && !corner.equals("topRight")){
                availableCorners.put(wantToBePlaced.getID() +" bottomLeft", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()), (int) availableCorners.get(destination.getID() + " " +corner).getY()-1));
                //System.out.println("BOARD MANAGER 189: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " bottomLeft"));
            }
            if(bottomRight != null  && !corner.equals("topLeft")){
                availableCorners.put(wantToBePlaced.getID() +" bottomRight", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()+1), (int) availableCorners.get(destination.getID()  + " " +corner).getY()));
                //System.out.println("BOARD MANAGER 193: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " bottomRight"));
            }
            //System.out.println("197 " +corner);

            //Remove the corner which the card is being placed on
            occupiedCorner = removeCorners(destination, corner, occupiedCorner);
        }else{
            System.out.println(" ");
            System.out.println("BOARD MANAGER 201: Hey so the destination is not starting");
            //System.out.println(destination.getID());
            switch (corner){
                case "topLeft":
                    //should probably use the available map to modify coordinates
                    coordinates = getCardPosition(destination);
                    if (placingTopLeft(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    break;
                case "bottomLeft":
                    coordinates = getCardPosition(destination);
                    if (placingBottomLeft(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    //System.out.println("Why bottomLeft?");
                    break;
                case "topRight":
                    coordinates = getCardPosition(destination);
                    if (placingTopRight(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    //System.out.println("Correct");
                    break;
                case "bottomRight":
                    coordinates = getCardPosition(destination);
                    //System.out.println("Those are the coordinates; " +coordinates);
                    //System.out.println(Board.get(coordinates)); //This gives out null
                    if (PlacingBottomRight(destination, wantToBePlaced, corner, resourcesList, coordinates))
                        return false;
                    //System.out.println("Why bottomRight?");
                    break;
            }
            //Now I update the available corners, adding the ones coming from the card i just placed and removing the others
            String topLeft = wantToBePlaced.getLEFTSYMBOL();
            String topRight = wantToBePlaced.getTOPSYMBOL();
            String bottomLeft = wantToBePlaced.getBOTTOMSYMBOL();
            String bottomRight = wantToBePlaced.getRIGHTSYMBOL();
            //System.out.println(destination.getID());
            if(topLeft != null && !corner.equals("bottomRight")){
                availableCorners.put(wantToBePlaced.getID() +" topLeft", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()-1), (int) availableCorners.get(destination.getID() + " " +corner).getY()));
                System.out.println("BOARD MANAGER 239: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " bottomRight"));
            }
            if(topRight != null && !corner.equals("bottomLeft")){
                availableCorners.put(wantToBePlaced.getID() +" topRight", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()), (int) availableCorners.get(destination.getID() + " " +corner).getY()+1));
                System.out.println("BOARD MANAGER 243: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " topRight"));
            }
            if(bottomLeft != null && !corner.equals("topRight")){
                availableCorners.put(wantToBePlaced.getID() +" bottomLeft", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()), (int) availableCorners.get(destination.getID() + " " +corner).getY()-1));
                System.out.println("BOARD MANAGER 247: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " bottomLeft"));
            }
            if(bottomRight != null && !corner.equals("topLeft")){
                availableCorners.put(wantToBePlaced.getID() +" bottomRight", new Point((int) (availableCorners.get(destination.getID() + " " +corner).getX()+1), (int) availableCorners.get(destination.getID() + " " +corner).getY()));
                System.out.println("BOARD MANAGER 251: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " bottomRight"));
            }
            //Remove the corner on which the card is being placed on
            occupiedCorner = removeCorners(destination, corner, occupiedCorner);
        }
        addPoint(wantToBePlaced, occupiedCorner);
        //System.out.println("324 " + availableCorners.get(destination.getID() + " topRight"));
        //System.out.println(Board.containsKey(destination));
        //System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
        return true;
    }

    private static boolean placingTopLeft(CardJSON destination, CardJSON wantToBePlaced, String corner, List<Text> resourcesList, Point coordinates) {
        if (!Objects.equals(corner, "")) {
            //TODO keep track of the loss of resource
            String losingRes = destination.getLEFTSYMBOL();
            if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                return true;
            }
            System.out.println("BOARD MANAGER 270: I'm the guy: " + corner);
            if(Board.containsKey(coordinates)){
                System.out.println("BOARD MANAGER 272:" + corner + "already has some here");
                return true;
            }
            // Update the placement status
            Board.put(wantToBePlaced.getID(), coordinates);
            //availableCorners.remove(destination.getID() + " topLeft");
            System.out.println("BOARD MANAGER 278: I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
        }
        return false;
    }

    private static int removeCorners(CardJSON destination, String corner, int occupiedCorner) {
        switch (corner){
            case "topLeft":
                availableCorners.remove(destination.getID() + " topLeft");
                occupiedCorner++;
                break;
            case "topRight":
                availableCorners.remove(destination.getID() + " topRight");
                occupiedCorner++;
                break;
            case "bottomLeft":
                availableCorners.remove(destination.getID() + " bottomLeft");
                occupiedCorner++;
                break;
            case "bottomRight":
                availableCorners.remove(destination.getID() + " bottomRight");
                occupiedCorner++;
                break;

        }
        return occupiedCorner;
    }

    private static boolean placingBottomLeft(CardJSON destination, CardJSON wantToBePlaced, String corner, List<Text> resourcesList, Point coordinates) {
        if (!Objects.equals(corner, "")) {
            //TODO keep track of the loss of resource
            String losingRes = destination.getBOTTOMSYMBOL();
            if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                return true;
            }
            System.out.println("BOARD MANAGER 312: I'm the guy: " +corner);
            if(Board.containsKey(coordinates)){
                System.out.println("BOARD MANAGER 314:" + corner + " already has some here");
                return false;
            }
            // Update the placement status
            Board.put(wantToBePlaced.getID(), coordinates);
            //availableCorners.remove(destination.getID() + " bottomLeft");
            System.out.println("BOARD MANAGER 320: I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

        }
        return false;
    }

    private static boolean placingTopRight(CardJSON destination, CardJSON wantToBePlaced, String corner, List<Text> resourcesList, Point coordinates) {
        if (!Objects.equals(corner, "")) {
            String losingRes = destination.getTOPSYMBOL();
            if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                return true;
            }
            //System.out.println("BOARD MANAGER 332: I'm the guy: " +corner);
            if(Board.containsKey(coordinates)){
                //System.out.println("BOARD MANAGER 334: "+ corner + " already has some here");
                return false;
            }
            // Update the placement status
            Board.put(wantToBePlaced.getID(), coordinates);
            //availableCorners.remove(destination.getID() + " topRight");
            //System.out.println("BOARD MANAGER 340: I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));


        }
        return false;
    }

    private static boolean PlacingBottomRight(CardJSON destination, CardJSON wantToBePlaced, String corner, List<Text> resourcesList, Point coordinates) {
        if (!Objects.equals(corner, "")) {
            String losingRes = destination.getRIGHTSYMBOL();
            if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                return true;
            }
            System.out.println("BOARD MANAGER 353: I'm the guy: " +corner);
            // Update the placement status
            if(Board.containsKey(coordinates)){
                System.out.println("BOARD MANAGER 356:" + corner + " already has some here");
                return false;
            }
            Board.put(wantToBePlaced.getID(), coordinates);
            //availableCorners.remove(destination.getID() + " bottomRight");
            System.out.println("BOARD MANAGER 361: I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

        }
        return false;
    }

    /**@ ensures Board.containsKey(destination.getID()) ==> \result != null;
      */

    private static int mushrooms = 0;
    private static int insects = 0;
    private static int animals = 0;
    private static int plants = 0;
    private static int potion = 0;
    private static int feather = 0;
    private static int scroll = 0;

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

    public static void addPoint(CardJSON PlacedCard, int occupiedCorner){
        if (PlacedCard.getPOINTS().matches("\\d+")) {
            // Input is a single number
            PointCounter += Integer.parseInt(PlacedCard.getPOINTS());
        } else {
            Pattern pattern = Pattern.compile("(\\d+)\\s+for each\\s+(\\w)");
            Matcher matcher = pattern.matcher(PlacedCard.getPOINTS());

            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group(1));
                String letter = String.valueOf(matcher.group(2).charAt(0));

                switch (letter.toLowerCase()){
                    case "p":
                        int Potion = getPotion();
                        PointCounter += Potion*number;
                        break;
                    case "f":
                        int Feather = getFeather();
                        PointCounter += Feather*number;
                        break;
                    case "s":
                        int Scroll = getScroll();
                        PointCounter += Scroll*number;
                        break;
                    case "a": //It's 2 points for each angle that the card occupies
                        PointCounter += 2*occupiedCorner;
                        System.out.println("POINT COUNTER 41: Occupied Corner of the card " + occupiedCorner);
                        break;
                }
            } else {
                System.out.println("Invalid input format.");
            }
        }
        //System.out.println("Player points: " + PointCounter);
        MyPoints.get(0).setText(String.valueOf(PointCounter));
    }

    //If i pass starting card, everything is ok, but if i don't pass starting card trouble starts.
    private static Point getCardPosition(CardJSON destination) {
        return Board.get(destination.getID());
    }




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
