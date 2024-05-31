package Controller;

import Client.Client;
import Client.GUI.SceneControllers.GameBoard;
import Model.Cards.CardJSON;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

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
        AtomicReference<String> cardID = new AtomicReference<>("");
        for (ImageView imageView : StartDecksList) {
            imageView.setOnMouseClicked(event -> {
                // Handle the mouse click event here
                String fileName = extractFileName(imageView.getImage().getUrl());
                System.out.println();
                System.out.println("FILE " + fileName);
                URL file = CardPicker.class.getResource("/Images/" + fileName);
                handCard.setImage(new Image(file.toString()));
                if(fileName.startsWith("G")){
                    System.out.println("MY G");
                    imageView.setScaleX(0.1);
                    imageView.setScaleY(0.1);
                    ScaleTransition initialTransition = new ScaleTransition(Duration.millis(100), imageView);
                    initialTransition.setToX(1.0);
                    initialTransition.setToY(1.0);
                    initialTransition.play();
                    Random rand = new Random();
                    CardJSON card = Client.getVirtualModel().getGoldDeck().get(rand.nextInt(Client.getVirtualModel().getGoldDeck().size()));
                    cardID.set(card.getID());
                    URL cardIDU = CardPicker.class.getResource("/Images/" + cardID + "front.jpg");
                    imageView.setImage(new Image(cardIDU.toString()));
                    Client.getVirtualModel().getGoldDeck().remove(card);
                }else{
                    System.out.println("MY R");
                    imageView.setScaleX(0.1);
                    imageView.setScaleY(0.1);
                    ScaleTransition initialTransition = new ScaleTransition(Duration.millis(100), imageView);
                    initialTransition.setToX(1.0);
                    initialTransition.setToY(1.0);
                    initialTransition.play();
                    Random randR = new Random();
                    CardJSON card = Client.getVirtualModel().getResourceDeck().get(randR.nextInt(Client.getVirtualModel().getResourceDeck().size()));
                    cardID.set(card.getID().replaceFirst("0", ""));
                    System.out.println(cardID.get());
                    URL cardIDZ = CardPicker.class.getResource("/Images/" + cardID + "front.jpg");
                    imageView.setImage(new Image(cardIDZ.toString()));
                    Client.getVirtualModel().getResourceDeck().remove(card);
                }
                System.out.println("Send to server: " + cardID);
                Client.sendMessage(cardID.toString());
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
