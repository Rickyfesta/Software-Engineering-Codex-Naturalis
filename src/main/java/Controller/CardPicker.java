package Controller;

import Client.GUI.SceneControllers.GameBoard;
import Model.Cards.RandomCardFile;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.List;

public class CardPicker {

    static List<ImageView> StartDecksList;
    /**@ requires gameBoard != null;
      @ ensures StartDecksList == null;
      */
    public CardPicker(GameBoard gameBoard) {
    }
     /**@ requires handCard != null;
      @ ensures (\forall ImageView imageView; StartDecksList.contains(imageView); imageView.getOnMouseClicked() != null);
      */

    public static void PickNewCard(ImageView handCard) {
        //Here i make pickable the cards of the decks.
        for (ImageView imageView : StartDecksList) {
            imageView.setOnMouseClicked(event -> {
                // Handle the mouse click event here
                String fileName = extractFileName(imageView.getImage().getUrl());
                //System.out.println(fileName);
                handCard.setImage(new Image("/" + fileName));
                if(fileName.startsWith("G")){
                    imageView.setScaleX(0.1);
                    imageView.setScaleY(0.1);
                    ScaleTransition initialTransition = new ScaleTransition(Duration.millis(100), imageView);
                    initialTransition.setToX(1.0);
                    initialTransition.setToY(1.0);
                    initialTransition.play();
                    imageView.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
                }else{
                    imageView.setScaleX(0.1);
                    imageView.setScaleY(0.1);
                    ScaleTransition initialTransition = new ScaleTransition(Duration.millis(100), imageView);
                    initialTransition.setToX(1.0);
                    initialTransition.setToY(1.0);
                    initialTransition.play();
                    imageView.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
                }
            });
            }
        }
        /**@ requires CardToPick != null;
      @ requires decksList != null;
      @ ensures StartDecksList == decksList;
      @ ensures CardToPick.getOnMouseEntered() != null;
      @ ensures CardToPick.getOnMouseExited() != null;
      */

    public void makePickable(ImageView CardToPick, List<ImageView> decksList) {
        StartDecksList = decksList;
        // Create scale transition for mouse hover
        ScaleTransition hoverTransition = new ScaleTransition(Duration.millis(50), CardToPick);
        hoverTransition.setToX(1.1);
        hoverTransition.setToY(1.1);
        // Create scale transition for mouse exit
        ScaleTransition exitTransition = new ScaleTransition(Duration.millis(50), CardToPick);
        exitTransition.setToX(1.0);
        exitTransition.setToY(1.0);
        CardToPick.setOnMouseEntered(event -> hoverTransition.playFromStart());
        CardToPick.setOnMouseExited(event -> exitTransition.playFromStart());
    }
    /**@ requires filePath != null;
      @ ensures \result != null;
      */

    private static String extractFileName(String filePath) {
        if (filePath != null && !filePath.isEmpty()) {
            int lastSlashIndex = filePath.lastIndexOf('/');
            if (lastSlashIndex != -1 && lastSlashIndex < filePath.length() - 1) {
                return filePath.substring(lastSlashIndex + 1);
            }
        }
        return "";
    }
}
