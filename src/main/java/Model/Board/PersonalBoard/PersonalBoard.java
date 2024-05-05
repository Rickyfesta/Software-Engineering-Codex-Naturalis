package Model.Board.PersonalBoard;

import Model.Cards.Card;

import java.util.HashMap;
import java.util.Map;

public class PersonalBoard {
    private Map<Integer, Map<Integer, Card>> boardMap;

    public PersonalBoard() {
        boardMap = new HashMap<>();
        int id = 0;
    }

    public void placeCard(int x, int y, Card card) {
        boardMap.computeIfAbsent(x, k -> new HashMap<>()).put(y, card);
    }

    public Card getCard(int x, int y) {
        return boardMap.getOrDefault(x, new HashMap<>()).get(y);
    }
}
