package Controller;

import Model.Cards.CardJSON;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Controller.GameBoard.MyPoints;
import static Controller.ResourcesCounter.*;

public class PointCounter {
    //Have to move pedine and count point. The point make only move the pedine. Fix pedine starting position, bring back all the pedine tony placed.
    static int PointCounter = 0;
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
}
