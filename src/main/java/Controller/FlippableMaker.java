package Controller;

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

public class FlippableMaker {

    private static final String RED_IMAGE = "/MushroomBack.jpg";
    private static final String BLUE_IMAGE = "/AnimalBack.jpg";
    private static final String GREEN_IMAGE = "/PlantBack.jpg";
    private static final String PURPLE_IMAGE = "/InsectBack.jpg";
    private static final String GRED_IMAGE = "/GMushroomBack.jpg";
    private static final String GBLUE_IMAGE = "/GAnimalBack.jpg";
    private static final String GGREEN_IMAGE = "/GPlantBack.jpg";
    private static final String GPURPLE_IMAGE = "/GInsectBack.jpg";


    private final Map<ImageView, Boolean> flippedState = new HashMap<>();
    private final Map<ImageView, String> ids = new HashMap<>();
    /**
     * Flips the card image view.
     *
     * @param cardImageView The image view of the card to flip.
     * @param cardColor The color of the card.
     * @param type The type of the card (e.g., "Gold").
     * @param url The URL of the card image.
     * @requires cardImageView != null
     * @requires cardColor != null
     * @requires type != null
     * @requires url != null
     * @ensures flippedState.containsKey(cardImageView)
     */


    public void flipCard(ImageView cardImageView, String cardColor, String type, String url) {
        flippedState.putIfAbsent(cardImageView, false); // Initialize the flipped state if not already done
        //System.out.println(url); URL IS ID

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), cardImageView);
        scaleTransition.setFromX(1.0);
        scaleTransition.setToX(0.0);
        scaleTransition.setOnFinished(event -> {
            // Update the card's image after the first half of the flip
            if(type.equalsIgnoreCase("Gold")){
                ids.putIfAbsent(cardImageView, url);
                System.out.println("Hey this is the url: " + ids.get(cardImageView));
                cardImageView.setImage(getGImageForColor(cardImageView, cardColor, ids.get(cardImageView)));
            }
            else{
                ids.putIfAbsent(cardImageView, url.replaceFirst("0", ""));
                System.out.println("Hey this is the url: " + ids.get(cardImageView));
                cardImageView.setImage(getImageForColor(cardImageView, cardColor, ids.get(cardImageView)));
            }
            // Reverse the ScaleTransition to complete the flip
            ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(300), cardImageView);
            reverseTransition.setFromX(0.0);
            reverseTransition.setToX(1.0);
            reverseTransition.play();
        });
        scaleTransition.play();

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

    private Image getGImageForColor(ImageView cardImageView, String color, String url) {
        System.out.println("this url : " +url);
        boolean isFlipped = flippedState.get(cardImageView);
        flippedState.put(cardImageView, !isFlipped);
        System.out.println(isFlipped);
        if (isFlipped) {
            System.out.println("this url : " +url);
            System.out.println(fetchImageUrlFromJson(url, cardImageView));
            return new Image("/" +fetchImageUrlFromJson(url, cardImageView) + "front.jpg");
        } else {
            switch (color.toLowerCase()) {
                case "red":
                    return new Image(GRED_IMAGE);
                case "blue":
                    return new Image(GBLUE_IMAGE);
                case "green":
                    return new Image(GGREEN_IMAGE);
                case "purple":
                    return new Image(GPURPLE_IMAGE);
                default:
                    throw new IllegalArgumentException("Invalid card color: " + color);
            }
        }
    }
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



    private Image getImageForColor(ImageView cardImageView, String color, String url) {
        boolean isFlipped = flippedState.get(cardImageView);
        flippedState.put(cardImageView, !isFlipped);
        if (isFlipped) {
            System.out.println(fetchImageUrlFromJson(url, cardImageView));
            return new Image("/" +fetchImageUrlFromJson(url, cardImageView).replaceFirst("0", "") + "front.jpg");
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
     * @param imgView The image view of the card.
     * @requires url != null
     * @requires imgView != null
     * @ensures \result != null
     * @return The image URL from the JSON file.
     */

    private String fetchImageUrlFromJson(String url, ImageView imgView) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //url = url +"front.jpg";
            //System.out.println("src/main/resources/json/" + url);
            CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url + "front.json"), CardJSON.class);
            if(card.getID() == null){
                card.setID(ids.get(imgView));
            }
            return card.getID();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
