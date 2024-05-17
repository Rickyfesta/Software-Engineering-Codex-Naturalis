package Controller;

import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static Controller.GameBoard.StartUrl;

public class GameManager {

    //See the starting card and see where i can place other card
    public void startGame() throws IOException {

        //get the starting card for the player
        ObjectMapper boardMapper = new ObjectMapper();
        boardMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CardJSON startingCard = boardMapper.readValue(new File("src/main/resources/json/" + StartUrl.replace("jpg", "json")), CardJSON.class);


        //initialize the personal board
        BoardManager.initializeBoard(startingCard);

        //see where the startingCard has free corners
        String isTopLeft_playable = "top";
        String isTopRight_playable = "right";
        String isBottomLeft_playable = "left";
        String isBottomRight_playable = "bottom";
        //Check if bottom left is playable
        if(startingCard.getLEFTSYMBOL() == null){
            //Have to drop left1 in gameBoard
            BoardManager.notPlayable(startingCard, startingCard.getLEFTSYMBOL());
        }
        //Check if top right is playable
        if(startingCard.getRIGHTSYMBOL() == null){
            //Have to drop right1 in gameBoard
            BoardManager.notPlayable(startingCard, startingCard.getRIGHTSYMBOL());
        }
        //Check if bottom right is playable
        if(startingCard.getBOTTOMSYMBOL() == null){
            //Have to drop bottom1 in gameBoard
            BoardManager.notPlayable(startingCard, startingCard.getBOTTOMSYMBOL());
        }
        //Check if top left is playable
        if(startingCard.getTOPSYMBOL() == null){
            //Have to drop top1 in gameBoard
            BoardManager.notPlayable(startingCard, startingCard.getTOPSYMBOL());
        }
    }
}

