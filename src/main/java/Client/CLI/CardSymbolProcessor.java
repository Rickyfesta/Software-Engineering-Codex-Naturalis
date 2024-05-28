package Client.CLI;

import Model.Cards.CardJSON;

public class CardSymbolProcessor {
    private static CLIMapper mapper = new CLIMapper();
    public static void processCardSymbols(String cardFilePath) {
        CardJSON card = mapper.getCard(cardFilePath);
        if (card != null) {
            String topSymbolResult = card.getTOPSYMBOL() != null ? "_" : "/";
            String bottomSymbolResult = card.getBOTTOMSYMBOL() != null ? "_" : "/";
            String leftSymbolResult = card.getLEFTSYMBOL() != null ? "_" : "/";
            String rightSymbolResult = card.getRIGHTSYMBOL() != null ? "_" : "/";

            System.out.println(leftSymbolResult + topSymbolResult);
            System.out.println(bottomSymbolResult + rightSymbolResult);
        } else {
            System.out.println("Card not found or could not be read.");
            }

    }

    public static void main(String[] args) {
        // Example usage
        String cardFilePath = "/json/01front.json";
        processCardSymbols(cardFilePath);
    }
}