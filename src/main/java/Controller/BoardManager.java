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

import static Controller.GameBoard.imageViewList;
import static Controller.PointCounter.addPoint;
import static Controller.ResourcesCounter.canPlaceCard;

public class BoardManager {
    private static final Map<String, Point> Board = new HashMap<>(); // Map to track board
    //Want to do a list of the imageView already present on the board, so that if a card wants to be placed on one of them but it's not there it's rip.
    public static Map<String, Point> availableCorners = new HashMap<>();

    static int occupiedCorner = 0;
    public static void initializeBoard(CardJSON startingCard, List<Text> resourceList){
        //Initialize the board: put everything inside of it, the availableCorners function will make me know if i can place on it.
        //TODO add the other missing cards
        for (ImageView imageView : imageViewList) {
            int x = 0, y = 0;
            if (imageView.getId().equals("StartingCard")) {
                x = 0;
                y = 0;
            } else if (imageView.getId().startsWith("Left")) {
                int n = Integer.parseInt(imageView.getId().substring(4));
                x = -n;
                y = 0;
            } else if (imageView.getId().startsWith("Right")) {
                int n = Integer.parseInt(imageView.getId().substring(5));
                x = n;
                y = 0;
            } else if (imageView.getId().startsWith("Up")) {
                int n = Integer.parseInt(imageView.getId().substring(2));
                x = 0;
                y = n;
            } else if (imageView.getId().startsWith("Down")) {
                int n = Integer.parseInt(imageView.getId().substring(4));
                x = 0;
                y = -n;
            }
            if (imageView.getId().equals("StartingCard")) {
                Board.put(startingCard.getID(), new Point(x, y));
            }else{
                Board.put(imageView.getId(), new Point(x, y));
            }
            //System.out.println("Just putted in the board the following: " +Board.get((new Point(x,y))));
        }
        //System.out.println("Here's what is on the starting position of the board: " +Board.get(target));
        ResourcesCounter.updateResources(startingCard, resourceList);
        //now i create for the starting card the coordinates of his corners, to be able to place a card on
        String id = startingCard.getID();
        String topRight = startingCard.getRIGHTSYMBOL();
        String bottomLeft = startingCard.getLEFTSYMBOL();
        String topLeft = startingCard.getTOPSYMBOL();
        String bottomRight = startingCard.getBOTTOMSYMBOL();
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
        }
        if(topLeft != null){
            Point topLeftCoordinates = new Point(-1,0);
            availableCorners.put(id +" topLeft", topLeftCoordinates);
            //System.out.println("hello3");
        }
        if(bottomLeft != null){
            Point bottomLeftCoordinates = new Point(0,-1);
            availableCorners.put(id +" bottomLeft", bottomLeftCoordinates);
            //System.out.println("hello4");
        }
        //System.out.println("Available Corners: " + id + "  " + availableCorners.get(id + " topRight"));
        //System.out.println(availableCorners.containsKey(id+ " topRight"));
    }



    public static boolean Place(CardJSON destination, CardJSON wantToBePlaced, String corner, List<Text> resourcesList){
        /*if(!ResourcesCounter.canPlaceCard(wantToBePlaced)){
            return false; //cannot place card so i have to return because i cannot place it.
            //TODO Resources Counter
        }*/
        Point coordinates = new Point(0,0);
        if(destination.getID().startsWith("S")){//I'm on the starting card
            //Here everything is ok
            //System.out.println("100  " +availableCorners.get(destination.getID() + " topRight"));
            switch (corner){
                case "topLeft":
                    coordinates.x--;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        String losingRes = destination.getLEFTSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topLeft");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                        System.out.println("112 " + availableCorners.get(destination.getID() + " topLeft"));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topLeft");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why topLeft?");
                    break;
                case "bottomLeft":
                    coordinates.y--;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        String losingRes = destination.getBOTTOMSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomLeft");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomLeft");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why bottomLeft?");
                    break;
                case "topRight":
                    coordinates.y++;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        String losingRes = destination.getTOPSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //System.out.println("147  " + availableCorners.get(destination.getID() + " topRight"));
                        //
                        //System.out.println("149  " + availableCorners.get(destination.getID() + " topRight"));
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                        System.out.println("150 " + availableCorners.get(destination.getID() + " topRight"));
                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topRight");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Correct");
                    break;
                case "bottomRight":
                    coordinates.x++;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        String losingRes = destination.getRIGHTSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomRight");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomRight");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why bottomRight?");
                    break;
            }
            //Now I update the available corners, adding the ones coming from the card i just placed and removing the others
            String topLeft = wantToBePlaced.getLEFTSYMBOL();
            String topRight = wantToBePlaced.getTOPSYMBOL();
            String bottomLeft = wantToBePlaced.getBOTTOMSYMBOL();
            String bottomRight = wantToBePlaced.getRIGHTSYMBOL();
            //System.out.println(destination.getID());
            if(topLeft != null && availableCorners.get(destination.getID() + " topLeft") != null){
                availableCorners.put(wantToBePlaced.getID() +" topLeft", new Point((int) (availableCorners.get(destination.getID() +" topLeft").getX()-1), (int) availableCorners.get(destination.getID() +" topLeft").getY()));
            }
            if(topRight != null && availableCorners.get(destination.getID() + " topRight") != null){
                availableCorners.put(wantToBePlaced.getID() +" topRight", new Point((int) (availableCorners.get(destination.getID() +" topRight").getX()), (int) availableCorners.get(destination.getID() +" topRight").getY()+1));
                System.out.println("303: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " topRight"));
            }
            if(bottomLeft != null && availableCorners.get(destination.getID() + " bottomLeft") != null){
                availableCorners.put(wantToBePlaced.getID() +" bottomLeft", new Point((int) (availableCorners.get(destination.getID() +" bottomLeft").getX()), (int) availableCorners.get(destination.getID() +" bottomLeft").getY()-1));
            }
            if(bottomRight != null && availableCorners.get(destination.getID() + " bottomRight") != null){
                availableCorners.put(wantToBePlaced.getID() +" bottomRight", new Point((int) (availableCorners.get(destination.getID() +" bottomRight").getX()+1), (int) availableCorners.get(destination.getID() +" bottomRight").getY()));
            }
            System.out.println("197 " +corner);

            //Remove the corner which the card is being placed on
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
        }else{
            System.out.println(" ");
            System.out.println("Hey so the destination is not starting");
            switch (corner){
                case "topLeft":
                    //should probably use the available map to modify coordinates
                    coordinates = getCardPosition(destination);
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        String losingRes = destination.getLEFTSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topLeft");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topLeft");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }
                    break;
                case "bottomLeft":
                    coordinates = getCardPosition(destination);
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        String losingRes = destination.getBOTTOMSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomLeft");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomLeft");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why bottomLeft?");
                    break;
                case "topRight":
                    coordinates = getCardPosition(destination);
                    if (!Objects.equals(corner, "")) {
                        String losingRes = destination.getTOPSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topRight");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));


                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " topRight");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Correct");
                    break;
                case "bottomRight":
                    coordinates = getCardPosition(destination);
                    if (!Objects.equals(corner, "")) {
                        String losingRes = destination.getRIGHTSYMBOL();
                        if(!canPlaceCard(wantToBePlaced, losingRes, resourcesList)){
                            return false;
                        }
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomRight");
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        //availableCorners.remove(destination.getID() + " bottomRight");
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why bottomRight?");
                    break;
            }
            //Now I update the available corners, adding the ones coming from the card i just placed and removing the others
            String topLeft = wantToBePlaced.getLEFTSYMBOL();
            String topRight = wantToBePlaced.getTOPSYMBOL();
            String bottomLeft = wantToBePlaced.getBOTTOMSYMBOL();
            String bottomRight = wantToBePlaced.getRIGHTSYMBOL();
            //System.out.println(destination.getID());
            if(topLeft != null && availableCorners.get(destination.getID() + " topLeft") != null){
                availableCorners.put(wantToBePlaced.getID() +" topLeft", new Point((int) (availableCorners.get(destination.getID() +" topLeft").getX()-1), (int) availableCorners.get(destination.getID() +" topLeft").getY()));
            }
            if(topRight != null && availableCorners.get(destination.getID() + " topRight") != null){
                availableCorners.put(wantToBePlaced.getID() +" topRight", new Point((int) (availableCorners.get(destination.getID() +" topRight").getX()), (int) availableCorners.get(destination.getID() +" topRight").getY()+1));
                System.out.println("303: Just created a new corner here: " +availableCorners.get(wantToBePlaced.getID() + " topRight"));
            }
            if(bottomLeft != null && availableCorners.get(destination.getID() + " bottomLeft") != null){
                availableCorners.put(wantToBePlaced.getID() +" bottomLeft", new Point((int) (availableCorners.get(destination.getID() +" bottomLeft").getX()), (int) availableCorners.get(destination.getID() +" bottomLeft").getY()-1));
            }
            if(bottomRight != null && availableCorners.get(destination.getID() + " bottomRight") != null){
                availableCorners.put(wantToBePlaced.getID() +" bottomRight", new Point((int) (availableCorners.get(destination.getID() +" bottomRight").getX()+1), (int) availableCorners.get(destination.getID() +" bottomRight").getY()));
            }
            //Remove the corner on which the card is being placed on
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
        }
        addPoint(wantToBePlaced, occupiedCorner);
        //System.out.println("324 " + availableCorners.get(destination.getID() + " topRight"));
        //System.out.println(Board.containsKey(destination));
        //System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
        return true;
    }
    //If i pass starting card, everything is ok, but if i don't pass starting card trouble starts.
    private static Point getCardPosition(CardJSON destination) {
        return Board.get(destination.getID());
    }

}
