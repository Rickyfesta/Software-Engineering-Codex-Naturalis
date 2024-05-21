package Client.CLI;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HandHandler {

    private static final int HAND_SIZE = 3;
    private List<CLICard> hand;
    private ObjectMapper objectMapper;

    public HandHandler() {
        this.hand = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
    }

    public List<CLICard> readCardsFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, CLICard.class));
    }

    public void drawCard(List<CLICard> deck) {
        if (hand.size() < HAND_SIZE && !deck.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(deck.size());
            hand.add(deck.remove(index));
        }
    }

    public void drawInitialHand(List<CLICard> deck1, List<CLICard> deck2, List<CLICard> deck3) {
        drawCard(deck1);
        drawCard(deck2);
        drawCard(deck3);
    }

    public void printHand() {
        System.out.println("Current Hand:");
        for (CLICard card : hand) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        HandHandler handHandler = new HandHandler();
        try {
            List<CLICard> deck1 = handHandler.readCardsFromFile("src/main/resources/CLI/CLI01front.json");
            List<CLICard> deck2 = handHandler.readCardsFromFile("src/main/resources/CLI/CLI02front.json");
            List<CLICard> deck3 = handHandler.readCardsFromFile("src/main/resources/CLI/CLIG03front.json");

            handHandler.drawInitialHand(deck1, deck2, deck3);
            handHandler.printHand();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

