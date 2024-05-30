/*package Client.CLI;

import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CLIFlippableMaker {

    private static final String RED_IMAGE = "/json/MushroomBack.json";
    private static final String BLUE_IMAGE = "/json/AnimalBack.json";
    private static final String GREEN_IMAGE = "/json/PlantBack.json";
    private static final String PURPLE_IMAGE = "/json/InsectBack.json";


    private final  Boolean> flippedState = new HashMap<>();
    private final String> ids = new HashMap<>();
    /**
     * Flips the card.
     *
     * @param cardColor The color of the card.
     * @param type The type of the card (e.g., "Gold").
     * @param url The URL of the card image.
     * @requires cardImageView != null
     * @requires cardColor != null
     * @requires type != null
     * @requires url != null
     * @ensures flippedState.containsKey(cardImageView)
     */

/*
    public void flipCard( String cardColor, String type, String url) {
        Scanner scanner = new Scanner(System.in);
        String cardFlip = scanner.nextLine();
        if (cardFlip.equalsIgnoreCase("flip")|| cardFlip.equalsIgnoreCase("flip card"){
            System.out.println(getImageForColor(cardColor, url));
        }
        else{
            System.out.println("Invalid input. Please type 'flip' to flip the card.");
        }
    }
    /**
     * Gets the image for a gold card based on its color.
     *
     * @param cardImageView The image view of the card.
     * @param color The color of the card.
     * @param url The URL of the card image.
     * @requires cardImageView != null
     * @requires color != null
     * @requires url != null
     * @ensures \result != null
     * @return The image of the card.
     */



    /**
     * Gets the image for a card based on its color.
     *
     * @param cardImageView The image view of the card.
     * @param color The color of the card.
     * @param url The URL of the card image.
     * @requires cardImageView != null
     * @requires color != null
     * @requires url != null
     * @ensures \result != null
     * @return The image of the card.
     */


/*
    private Image getImageForColor(String color, String url) {
        boolean isFlipped = flippedState.get(CardJSON.getASCII());
        flippedState.put(!isFlipped);
        if (isFlipped) {
            //System.out.println(fetchImageUrlFromJson(url, cardImageView));
            return new Image("/" +fetchImageUrlFromJson(url).replaceFirst("0", "") + "front.json");
        } else {
            switch (color.toLowerCase()) {
                case "red":
                    return new Image(RED_IMAGE);
                case "blue":
                    return new Image(BLUE_IMAGE);
                case "green":
                    return new Image(GREEN_IMAGE);
                case "purple":
                    return new Image(PURPLE_IMAGE);
                default:
                    throw new IllegalArgumentException("Invalid card color: " + color);
            }
        }
    }
    /**
     * Fetches the image URL from a JSON file.
     *
     * @param url The URL of the card image.
     * @requires url != null
     * @requires imgView != null
     * @ensures \result != null
     * @return The image URL from the JSON file.
     */
/*
    private String fetchImageUrlFromJson(String url) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //url = url +"front.jpg";
            //System.out.println("src/main/resources/json/" + url);
            CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url + "front.json"), CardJSON.class);
            if(card.getID() == null){
                //card.setID(ids.get(CardJSON.getASCII());
            }
            return card.getID();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
*/
