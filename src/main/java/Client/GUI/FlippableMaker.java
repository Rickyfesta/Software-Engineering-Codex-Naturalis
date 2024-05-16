package Client.GUI;

import Controller.GameBoard;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FlippableMaker {

    private static final String RED_IMAGE = "/MushroomBack.jpg";
    private static final String BLUE_IMAGE = "/AnimalBack.jpg";
    private static final String GREEN_IMAGE = "/PlantBack.jpg";
    private static final String PURPLE_IMAGE = "/InsectBack.jpg";
    private static final String GRED_IMAGE = "/GMushroomBack.jpg";
    private static final String GBLUE_IMAGE = "/GAnimalBack.jpg";
    private static final String GGREEN_IMAGE = "/GPlantBack.jpg";
    private static final String GPURPLE_IMAGE = "/GInsectBack.jpg";

    public void flipCard(ImageView cardImageView, String cardColor, String type, String url) {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), cardImageView);
        scaleTransition.setFromX(1.0);
        scaleTransition.setToX(0.0);
        scaleTransition.setOnFinished(event -> {
            // Update the card's image after the first half of the flip
            if(type.equalsIgnoreCase("Gold")){
                cardImageView.setImage(getGImageForColor(cardColor, url));
            }
            else{
                cardImageView.setImage(getImageForColor(cardColor, url));
            }
            // Reverse the ScaleTransition to complete the flip
            ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(300), cardImageView);
            reverseTransition.setFromX(0.0);
            reverseTransition.setToX(1.0);
            reverseTransition.play();
        });
        scaleTransition.play();

    }

    private Image getGImageForColor(String color, String url) {
        switch (color.toLowerCase()) {
            case "red":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(GRED_IMAGE);
                }
            case "blue":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(GBLUE_IMAGE);
                }
            case "green":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(GGREEN_IMAGE);
                }
            case "purple":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(GPURPLE_IMAGE);
                }
            default:
                throw new IllegalArgumentException("Invalid card color: " + color);
        }
    }

    private Image getImageForColor(String color, String url) {
        switch (color.toLowerCase()) {
            case "red":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(RED_IMAGE);
                }
            case "blue":
                if(GameBoard.isFlipped){
                GameBoard.isFlipped = false;
                return new Image("/"+url);
            }else{
                GameBoard.isFlipped = true;
                return new Image(BLUE_IMAGE);
            }
            case "green":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(GREEN_IMAGE);
                }
            case "purple":
                if(GameBoard.isFlipped){
                    GameBoard.isFlipped = false;
                    return new Image("/"+url);
                }else{
                    GameBoard.isFlipped = true;
                    return new Image(PURPLE_IMAGE);
                }
            default:
                throw new IllegalArgumentException("Invalid card color: " + color);
        }
    }

}
