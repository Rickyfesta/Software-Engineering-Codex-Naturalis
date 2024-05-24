package Controller;
//This class reads if a position of a image view is actually usable for a card to be placed.

import Model.Cards.CardJSON;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static Controller.GameBoard.imageViewList;

public class BoardManager {
    private static final Map<String, Point> Board = new HashMap<>(); // Map to track board
    //Want to do a list of the imageView already present on the board, so that if a card wants to be placed on one of them but it's not there it's rip.
    public static Map<String, Point> availableCorners = new HashMap<>();
    static int i = 0;
    public static void initializeBoard(CardJSON startingCard){
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
                Board.put(null, new Point(x, y));
            }
            //System.out.println("Just putted in the board the following: " +Board.get((new Point(x,y))));
        }
        //System.out.println("Here's what is on the starting position of the board: " +Board.get(target));
        ResourcesCounter.updateResources(startingCard);
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
            Point topRightCoordinates = new Point(1,0);
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

    public static boolean Place(CardJSON destination, CardJSON wantToBePlaced, String corner) {
        /*if(!ResourcesCounter.canPlaceCard(wantToBePlaced)){
            return false; //cannot place card so i have to return because i cannot place it.
            //TODO Resources Counter
        }*/
        Point coordinates = new Point(0,0);
        //do not find the card they want to place on
        if(destination != null){ //If it's the starting card i'm safe and i get them like that.
            coordinates = getCardPosition(destination);
            System.out.println(coordinates);
            Board.put(wantToBePlaced.getID(), coordinates);
        }else{
            switch (corner){
                case "topLeft":
                    //should probably use the available map to modify coordinates
                    coordinates.x--;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why topLeft?");
                    break;
                case "bottomLeft":
                    coordinates.y--;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why bottomLeft?");
                    break;
                case "topRight":
                    coordinates.y++;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Correct");
                    break;
                case "bottomRight":
                    coordinates.x++;
                    if (!Objects.equals(corner, "")) {
                        //TODO keep track of the loss of resource
                        System.out.println("I'm the guy: " +corner);
                        // Update the placement status
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));

                    }else{
                        //No loss of resources
                        Board.put(wantToBePlaced.getID(), coordinates);
                        System.out.println("No loss of resources! I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
                    }
                    //System.out.println("Why bottomRight?");
                    break;
            }
        }
        //System.out.println(Board.containsKey(destination));
        System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced.getID()));
        return true;
    }
    //If i pass starting card, everything is ok, but if i don't pass starting card trouble starts.
    private static Point getCardPosition(CardJSON destination) {
        return Board.get(destination.getID());
    }

}
