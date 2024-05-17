package Client.GUI;

import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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

    private Map<ImageView, Boolean> flippedState = new HashMap<>();

    public void flipCard(ImageView cardImageView, String cardColor, String type, String url) {
        flippedState.putIfAbsent(cardImageView, false); // Initialize the flipped state if not already done

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), cardImageView);
        scaleTransition.setFromX(1.0);
        scaleTransition.setToX(0.0);
        scaleTransition.setOnFinished(event -> {
            // Update the card's image after the first half of the flip
            if(type.equalsIgnoreCase("Gold")){
                cardImageView.setImage(getGImageForColor(cardImageView, cardColor, url));
            }
            else{
                cardImageView.setImage(getImageForColor(cardImageView, cardColor, url));
            }
            // Reverse the ScaleTransition to complete the flip
            ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(300), cardImageView);
            reverseTransition.setFromX(0.0);
            reverseTransition.setToX(1.0);
            reverseTransition.play();
        });
        scaleTransition.play();

    }

    private Image getGImageForColor(ImageView cardImageView,String color, String url) {
        boolean isFlipped = flippedState.get(cardImageView);
        flippedState.put(cardImageView, !isFlipped);
        switch (color.toLowerCase()) {
            case "red":
                return new Image(isFlipped ? "/" + url : GRED_IMAGE);
            case "blue":
                return new Image(isFlipped ? "/" + url : GBLUE_IMAGE);
            case "green":
                return new Image(isFlipped ? "/" + url : GGREEN_IMAGE);
            case "purple":
                return new Image(isFlipped ? "/" + url : GPURPLE_IMAGE);
            default:
                throw new IllegalArgumentException("Invalid card color: " + color);
        }
    }

    private Image getImageForColor(ImageView cardImageView,String color, String url) {
        boolean isFlipped = flippedState.get(cardImageView);
        flippedState.put(cardImageView, !isFlipped);

        switch (color.toLowerCase()) {
            case "red":
                return new Image(isFlipped ? "/" + url : RED_IMAGE);
            case "blue":
                return new Image(isFlipped ? "/" + url : BLUE_IMAGE);
            case "green":
                return new Image(isFlipped ? "/" + url : GREEN_IMAGE);
            case "purple":
                return new Image(isFlipped ? "/" + url : PURPLE_IMAGE);
            default:
                throw new IllegalArgumentException("Invalid card color: " + color);
        }
    }

}
