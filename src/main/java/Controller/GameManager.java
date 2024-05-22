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
        //BoardManager.initializeBoard(startingCard);
    }
}

