package Controller;
//This class reads if a position of a image view is actually usable for a card to be placed.

import Client.GUI.ResourcesCounter;
import Model.Cards.CardJSON;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BoardManager {
    private static final Map<CardJSON, Point> Board = new HashMap<>(); // Map to track board
    private static int minX;
    private static int maxX;
    private static int minY;
    private static int maxY;

    public static void initializeBoard(CardJSON startingCard){
        //put the starting card to the starting point
        Board.put(startingCard, new Point(0,0));
        ResourcesCounter.updateResources(startingCard);
        minX = 0;
        minY = 0;
        maxX = 0;
        maxY = 0;
    }

    public void Place(CardJSON destination, CardJSON wantToBePlaced, String corner) {
        if(!ResourcesCounter.canPlaceCard(wantToBePlaced)){
            return; //cannot place card so i have to return because i cannot place it.
            //TODO connect the movement of the card with the correct execution of the functions
        }
        //do not find the card they want to place on
        Point coordinates = getCardPosition(destination);
        if (destination == null) {
            System.out.println("Destination card not found on board");
            //to teleport the card directly to the hand
            return;
        }

        if (corner == null) {
            System.out.println("This corner is not available to be placed a card on");
            //to teleport the card directly to the hand
            return;
        }

        if (!Objects.equals(corner, "")) {
                //keep track of the loss of resource

            //Switch to see where to put the new card
            switch (corner){
                case "Top":
                    coordinates.y++;
                case "Left":
                    coordinates.x--;
                case "Right":
                    coordinates.x++;
                case "Bottom":
                    coordinates.y--;
            }
            // Update the placement status
            Board.put(wantToBePlaced, coordinates);
            updateBoundaries(coordinates.x, coordinates.y);
        }else{
            //Switch to see where to put the new card
            switch (corner){
                case "Top":
                    coordinates.y++;
                case "Left":
                    coordinates.x--;
                case "Right":
                    coordinates.x++;
                case "Bottom":
                    coordinates.y--;
            }
            // Update the placement status
            Board.put(wantToBePlaced, coordinates);
            updateBoundaries(coordinates.x,coordinates.y);
        }

        //System.out.println("Card placed at " + corner + " of " + destination );
    }

    private Point getCardPosition(CardJSON destination) {
        return Board.get(destination);
    }

    private void updateBoundaries(int x, int y) {
        if (x < minX) minX = x;
        if (x > maxX) maxX = x;
        if (y < minY) minY = y;
        if (y > maxY) maxY = y;
    }
    public static void notPlayable(CardJSON todoo, String xxx) {
    }
}
