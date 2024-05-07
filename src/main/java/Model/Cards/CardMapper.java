package Model.Cards;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CardMapper {
    public static void main(String[] args) {
        String directoryPath = "path/to/json/files";
        List<Card> cards = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Files.walk(Paths.get(directoryPath))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(path -> {
                        try {
                            CardJSON cardJson = mapper.readValue(new File(path.toString()), CardJSON.class);
                            Card card = mapCardJSONToCard(cardJson);
                            cards.add(card);
                        } catch (IOException e) {
                            System.err.println("Failed to read or parse file: " + path);
                            e.printStackTrace();
                        }
                    });

            // Output the loaded cards or perform further processing
            cards.forEach(card -> System.out.println(CardJSON.getCARDTYPE() + " - " + CardJSON.getPOINTS()));
        } catch (IOException e) {
            System.err.println("Failed to walk through directory: " + directoryPath);
            e.printStackTrace();
        }
    }

    private static Card mapCardJSONToCard(CardJSON cardJson) {
        String top = cardJson.getTOPSYMBOL().equals("null") ? null : cardJson.getTOPSYMBOL();
        String left = cardJson.getLEFTSYMBOL().equals("null") ? null : cardJson.getLEFTSYMBOL();
        String right = cardJson.getRIGHTSYMBOL().equals("null") ? null : cardJson.getRIGHTSYMBOL();
        String bottom = cardJson.getBOTTOMSYMBOL().equals("null") ? null : cardJson.getBOTTOMSYMBOL();
        String type = CardJSON.getCARDTYPE();
        String mainResource = cardJson.getRESOURCE().equals("Back") ? null : cardJson.getRESOURCE();
        int points = Integer.parseInt(CardJSON.getPOINTS());
        boolean isFlipped = cardJson.getRESOURCE().contains("Back");
        String symbol = CardJSON.getSYMBOL();
        return new Card(mainResource, top, left, right, bottom, type, symbol, points);
    }
}

