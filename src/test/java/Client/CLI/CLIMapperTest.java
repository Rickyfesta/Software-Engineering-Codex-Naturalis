package Client.CLI;

import Model.Cards.CardJSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CLIMapperTest {

    @Test
    public void testGetCard() {
        CLIMapper mapper = new CLIMapper();
        ArrayList<CardJSON> cardList = new ArrayList<>(3);
        ArrayList<String> cardIds = new ArrayList<>(3);

        cardIds.add("01front.json");
        cardIds.add("02front.json");
        cardIds.add("03front.json");

        for (String cardId : cardIds) {
            cardList.add(mapper.getCard(cardId));
        }

        for (int i = 0; i < cardIds.size(); i++) {
            assertEquals(cardList.get(i), mapper.getCard(cardIds.get(i)));
        }
    }
}
