package Controller;
//This class reads if a position of a image view is actually usable for a card to be placed.

import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static Controller.GameBoard.imageViewList;

public class BoardManager {
    private static final Map<CardJSON, Point> Board = new HashMap<>(); // Map to track board
    private static int minX;
    private static int maxX;
    private static int minY;
    private static int maxY;
    //Want to do a list of the imageView already present on the board, so that if a card wants to be placed on one of them but it's not there it's rip.
    public static Map<String, Point2D> availableCorners = new HashMap<>();
    static boolean startingCard = true;

    public static void initializeBoard(CardJSON startingCard) throws IOException {
        ObjectMapper boardMapper = new ObjectMapper();
        boardMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CardJSON Card;

        //Initialize the board: put everything inside of it, the availableCorners function will make me know if i can place on it.
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
            Board.put(null, new Point(x, y));
            //System.out.println("Just putted in the board the following: " +Board.get((new Point(x,y))));
        }
        Point target = new Point(0,0);
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

            Point2D topRightCoordinates = new Point2D(2044,1977);
            availableCorners.put(id +" topRight", topRightCoordinates);
            //System.out.println("hello1");
        }

        if(bottomRight != null){
            Point2D bottomRightCoordinates = new Point2D(2044,2023);
            availableCorners.put(id +" bottomRight", bottomRightCoordinates);
            //System.out.println("hello2");
        }

        if(topLeft != null){
            Point2D topLeftCoordinates = new Point2D(1912,1977);
            availableCorners.put(id +" topLeft", topLeftCoordinates);
            //System.out.println("hello3");
        }

        if(bottomLeft != null){
            Point2D bottomLeftCoordinates = new Point2D(1912,2023);
            availableCorners.put(id +" bottomLeft", bottomLeftCoordinates);
            //System.out.println("hello4");
        }
        minX = 0;
        minY = 0;
        maxX = 0;
        maxY = 0;
    }

    public static boolean Place(CardJSON destination, CardJSON wantToBePlaced, String corner) {

        /*if(!ResourcesCounter.canPlaceCard(wantToBePlaced)){
            return false; //cannot place card so i have to return because i cannot place it.
            //TODO connect the movement of the card with the correct execution of the functions
        }*/
        //do not find the card they want to place on
        Point coordinates;
        if(startingCard){
            coordinates = new Point (0,0);
            startingCard = false;
        }else{
            coordinates = getCardPosition(destination);
        }
        //System.out.println(Board.containsKey(destination));
        if (corner == null) {
            System.out.println("This corner is not available to be placed a card on");
            //to teleport the card directly to the hand
            return false;
        }

        if (!Objects.equals(corner, "")) {
                //keep track of the loss of resource
            System.out.println("I'm the guy: " +corner);
            //Switch to see where to put the new card
            switch (corner){
                case "topLeft":
                    coordinates.y++;
                    System.out.println("Why topLeft?");
                    break;
                case "bottomLeft":
                    coordinates.x--;
                    System.out.println("Why bottomLeft?");
                    break;
                case "topRight":
                    coordinates.x++;
                    System.out.println("Correct");
                    break;
                case "bottomRight":
                    coordinates.y--;
                    System.out.println("Why bottomRight?");
                    break;
            }
            // Update the placement status
            Board.put(wantToBePlaced, coordinates);
            System.out.println("I've secured the card here in those coordinates: " +Board.get(wantToBePlaced));
            updateBoundaries(coordinates.x, coordinates.y);
        }else{
            //Switch to see where to put the new card
            switch (corner){
                case "topLeft":
                    coordinates.y++;
                    break;
                case "bottomLeft":
                    coordinates.x--;
                    break;
                case "topRight":
                    coordinates.x++;
                    break;
                case "bottomRight":
                    coordinates.y--;
                    break;
            }
            // Update the placement status
            Board.put(wantToBePlaced, coordinates);
            updateBoundaries(coordinates.x,coordinates.y);
        }

        //System.out.println("Card placed at " + corner + " of " + destination );
        return true;
    }

    private static Point getCardPosition(CardJSON destination) {
        return Board.get(destination);
    }

    private static void updateBoundaries(int x, int y) {
        if (x < minX) minX = x;
        if (x > maxX) maxX = x;
        if (y < minY) minY = y;
        if (y > maxY) maxY = y;
    }

}
