package Controller;

import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.ScaleTransition;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Controller.BoardManager.Place;
import static Controller.BoardManager.availableCorners;

public class DraggableMaker {
    private final GameBoard gameBoard;
    private double mouseAnchorX;
    private double mouseAnchorY;
    private Pane originalParent;
    private double originalWidth;
    private double originalHeight;
    private final Map<Node, Double> initialXMap = new HashMap<>();
    private final Map<Node, Double> initialYMap = new HashMap<>();

    // map to store the positions of other cards
    //TODO correct the distance thing and make card appear over the corner chosen
    private final Map<Node, Point2D> cardPositions = new HashMap<>();
    private final Map<Point2D, Point2D[][]> cornerPositions = new HashMap<>(); //in the first line of the array i have the left coordinates while on the second line the right coordinates of the two corners
    private final Map<String, ImageView> destinationsMap = new HashMap<>();
    static double localX;
    static double localY;
    int numberLeft = 1;
    int numberDown = 1;
    int numberUp = 1;
    int numberRight = 1;

    static boolean trustCorner = false;
    public DraggableMaker(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setInitialCardPosition(Node InitialCard, Point2D cardCoordinates) {
        cardPositions.put(InitialCard, cardCoordinates);
        destinationsMap.put("Starting Card", (ImageView) InitialCard);
    }
//Need to pass the coordinates of the corners. If a card has just one corner the other ones will be null
    public void setStartingCorners(Point2D cardCoordinates, Point2D corner_topLeft, Point2D corner_topRight, Point2D corner_bottomLeft, Point2D corner_bottomRight) {
        cornerPositions.put(cardCoordinates, new Point2D[][]{new Point2D[]{corner_topLeft, corner_bottomLeft}, new Point2D[]{corner_topRight, corner_bottomRight}});
    }

    public void makeDraggable(Node HandCard, ScrollPane scrollPane, double initialX, double initialY, CardJSON cardToPlaceJSON, ImageView copy, AnchorPane personalBoardContainer, String startURL, List<ImageView> imageViewList) throws IOException {
        initialXMap.put(HandCard, initialX);
        initialYMap.put(HandCard, initialY);
        HandCard.setLayoutX(initialX);
        HandCard.setLayoutY(initialY);

        //initialize the rectangles for the starting card
        Rectangle topLeftCornerStartingCard = createBoundsRectangleForStartingCard(2000, 2000, "topLeft");
        Rectangle topRightCornerStartingCard = createBoundsRectangleForStartingCard(2120, 2000, "topRight");
        Rectangle bottomLeftCornerStartingCard = createBoundsRectangleForStartingCard(2000, 2080, "bottomLeft");
        Rectangle bottomRightCornerStartingCard = createBoundsRectangleForStartingCard(2120, 2080, "bottomRight");

        //initialize the object mapper and the startingCardJSON for the rectangles
        ObjectMapper boardMapper = new ObjectMapper();
        boardMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CardJSON startingCardJSON;
        startingCardJSON = boardMapper.readValue(new File("src/main/resources/json/" + startURL.replace("jpg", "json")), CardJSON.class);


        HandCard.setOnMousePressed(mouseEvent -> {

            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
            HandCard.toFront();
            originalParent = (Pane) HandCard.getParent(); // Save original parent
            originalWidth = HandCard.getBoundsInLocal().getWidth();
            originalHeight = HandCard.getBoundsInLocal().getHeight();

            //NEED TO SHOW THE RECTANGLES
            if(startingCardJSON.getLEFTSYMBOL() != null){
                personalBoardContainer.getChildren().addAll(bottomLeftCornerStartingCard);
            }
            if(startingCardJSON.getBOTTOMSYMBOL() != null){
                personalBoardContainer.getChildren().addAll(bottomRightCornerStartingCard);
            }
            if(startingCardJSON.getRIGHTSYMBOL() != null){
                personalBoardContainer.getChildren().addAll(topRightCornerStartingCard);
            }
            if(startingCardJSON.getTOPSYMBOL() != null){
                personalBoardContainer.getChildren().addAll(topLeftCornerStartingCard);
            }

        });

        HandCard.setOnMouseDragged(mouseEvent -> {
            //Pane content = (Pane) scrollPane.getContent(); TO DELETE
            HandCard.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            HandCard.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
            if (isOverScrollPane(HandCard, scrollPane)) {
                resizeNode(HandCard, 0.69767, 0.66667); // Resize the node
                Pane content = (Pane) scrollPane.getContent();
                localX = content.sceneToLocal(mouseEvent.getSceneX(), mouseEvent.getSceneY()).getX();
                localY = content.sceneToLocal(mouseEvent.getSceneX(), mouseEvent.getSceneY()).getY();
            } else {
                resetNodeSize(HandCard); // Reset to original size if not over scrollPane
            }
        });

        HandCard.setOnMouseReleased(event -> {
            // Check if the HandCard is over the scrollPane

            //NEED TO HIDE THE RECTANGLES
            personalBoardContainer.getChildren().removeAll(topLeftCornerStartingCard, topRightCornerStartingCard, bottomLeftCornerStartingCard, bottomRightCornerStartingCard);

            if (isOverScrollPane(HandCard, scrollPane)) {
                HandCard.prefWidth(150);
                HandCard.prefHeight(80);
                try { //check if a destination exists
                    ImageView destination = identifyDestinationImageView(HandCard, GameBoard.imageViewList, gameBoard.getAnchorPane());
                    if(destination != null){
                        if(Objects.equals(destination.getId(), "StartingCard")){
                            trustCorner = true;
                        }
                        String intersectedCorner = calculateIntersectedCorner((ImageView) HandCard, destination, copy, personalBoardContainer);
                        System.out.println(intersectedCorner);
                        if (intersectedCorner != null) { //check if it intersects a corner

                            /*
                            switch (intersectedCorner){
                                case "topLeft":
                                    //have to point to the imageView in the top left of the destination MMAYBE COULD USE AN HASHMAP WITH EVERYTHING INSIDE AND INCREMENT OR DECREASE THE COORDINATES
                                    destinationsMap.put("Left" +numberLeft, (ImageView) HandCard);
                                    numberLeft++;
                                    break;
                                case "bottomLeft":
                                    destinationsMap.put("Down" +numberDown, (ImageView) HandCard);
                                    numberDown++;
                                    break;
                                case "topRight":
                                    destinationsMap.put("Up" +numberUp, (ImageView) HandCard);
                                    numberUp++;
                                    System.out.println(destinationsMap.get("Up1"));
                                    break;
                                case "bottomRight":
                                    destinationsMap.put("Right" +numberRight, (ImageView) HandCard);
                                    numberRight++;
                                    break;
                            }*/

                            if(TryToPlace(HandCard, destination, intersectedCorner) && trustCorner){ //If i get as a destination card the Starting Card then i do this things
                                CardJSON destinationJson;
                                String imageViewIdWrongURLDESTINATION = destination.getImage().getUrl();
                                String imageViewIdDESTINATION = imageViewIdWrongURLDESTINATION.substring(imageViewIdWrongURLDESTINATION.lastIndexOf('/') +1).replace(".jpg", ".json");
                                destinationJson = boardMapper.readValue(new File("src/main/resources/json/" + imageViewIdDESTINATION.replace("jpg", "json")), CardJSON.class);
                                CardJSON HandCardJson;
                                String imageViewIdWrongURLHandCard = destination.getImage().getUrl();
                                String imageViewIHandCard = imageViewIdWrongURLHandCard.substring(imageViewIdWrongURLHandCard.lastIndexOf('/') +1).replace(".jpg", ".json");
                                HandCardJson = boardMapper.readValue(new File("src/main/resources/json/" + imageViewIHandCard.replace("jpg", "json")), CardJSON.class);
                                if(!Place(destinationJson, HandCardJson, intersectedCorner)){
                                    returnToOriginalPosition(HandCard);
                                }else{
                                    //System.out.println("Trying to set image to null");
                                    //System.out.println(imageViewIHandCard);
                                    ((ImageView) HandCard).setImage(null);
                                    destination.setImage(new Image("/"+imageViewIHandCard.replace("json","jpg")));
                                    System.out.println("Remember now need to pick another card");
                                    returnToOriginalPosition(HandCard);
                                }
                            }else{
                                if(TryToPlace(HandCard, destination, intersectedCorner)){
                                    for (ImageView imageView : imageViewList) {
                                        if(imageView == destination){
                                            String imageViewIdWrongURLHandCard = ((ImageView) HandCard).getImage().getUrl();
                                            String imageViewIHandCard = imageViewIdWrongURLHandCard.substring(imageViewIdWrongURLHandCard.lastIndexOf('/') +1).replace(".jpg", ".json");
                                            System.out.println(imageViewIHandCard);
                                            imageView.setImage(new Image("/" + imageViewIHandCard.replace("json", "jpg")));
                                        }
                                    }

                                }
                                returnToOriginalPosition(HandCard);
                            }
                        } else {
                            returnToOriginalPosition(HandCard);
                            //have to return card to hand
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Return to original parent and initial position if not dropped in scrollPane
                returnToOriginalPosition(HandCard);
            }
            resetNodeSize(HandCard); // Reset the size after releasing the HandCard
        });
    }

    private boolean TryToPlace(Node CardToPlace, ImageView destination, String corner) throws IOException {
        if(destination == null){
            System.out.println("wrong coordinates for destination");
        }
        if(trustCorner){
            ObjectMapper boardMapper = new ObjectMapper();
            boardMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CardJSON destinationJson;
            String imageViewIdWrongURL = destination.getImage().getUrl(); //if it's empty this gives out null
            String imageViewId = imageViewIdWrongURL.substring(imageViewIdWrongURL.lastIndexOf('/') +1).replace(".jpg", ".json");
            destinationJson = boardMapper.readValue(new File("src/main/resources/json/" + imageViewId.replace("jpg", "json")), CardJSON.class);
            //Now I have the JSON of the destination to check if the corners are available , cover a resource ecc.
            String prefix = imageViewId.substring(0, 3); //to get which card i'm referring to using only imageviews
            for (Map.Entry<String, Point2D> entry : availableCorners.entrySet()) {
                //If it has any corners free then it places it in one of those corners
                if (entry.getKey().startsWith(prefix)) {
                    if (entry.getKey().endsWith(corner)) {
                        System.out.println("hey the corner is actually good ");
                        return true;
                    }
                }
            }
        }else{
            //HAVE TO ADD CHECKS FOR RESOURCES and if it's already occupied
            return true;
        }

        System.out.println("No, the corner is not good.");
        return false;
    }

    //Resize imageView entering the scrollPane
    private void resizeNode(Node handCard, double newX, double newY) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2), handCard);
        scaleTransition.setToX(newX);
        scaleTransition.setToY(newY);
        scaleTransition.play();


    }

    private ImageView identifyDestinationImageView(Node handCard, List<ImageView> imageViewList, AnchorPane anchorPane) throws IOException {


        // Ensure bounds are up-to-date
        handCard.applyCss();
        handCard.autosize();

        // Convert handCard bounds to scene coordinates
        Bounds handCardBoundsInScene = handCard.localToScene(handCard.getBoundsInLocal());
        //System.out.println("Hand card bounds in scene: " + handCardBoundsInScene);

        Bounds handCardBoundsInAnchorPane = anchorPane.sceneToLocal(handCardBoundsInScene);
        //System.out.println(handCardBoundsInAnchorPane);

        for (ImageView imageView : imageViewList) {
            imageView.applyCss();
            imageView.autosize();

            // Convert imageView bounds to scene coordinates
            Bounds imageViewBoundsInScene = imageView.localToScene(imageView.getBoundsInLocal());
            //System.out.println(imageViewBoundsInScene);
            // Convert imageView bounds to AnchorPane coordinates
            Bounds imageViewBoundsInAnchorPane = anchorPane.sceneToLocal(imageViewBoundsInScene);
            // Check for intersection in the scene coordinate space
            if (handCardBoundsInAnchorPane.intersects(imageViewBoundsInAnchorPane)) {
                System.out.println("Intersection found " +imageView.getId());
                return imageView;
                //DONE: JUST NEED TO SEE IF INTERACTS WITH AN IMAGE VIEW.
            }
        }
        //System.out.println("No intersection found");
        return null;
    }


    private static String calculateIntersectedCorner(ImageView CardtoPlace, ImageView Destination, ImageView copy, AnchorPane allthings) {
        copy.setLayoutX(localX);
        copy.setLayoutY(localY);
        Bounds bounds1 = copy.getBoundsInParent();
        Bounds bounds2 = Destination.getBoundsInParent();
        // Calculate the corners of Destination
        double topLeftX = bounds2.getMinX();
        double topLeftY = bounds2.getMinY();
        double topRightX = bounds2.getMaxX();
        double topRightY = bounds2.getMinY();
        double bottomLeftX = bounds2.getMinX();
        double bottomLeftY = bounds2.getMaxY();
        double bottomRightX = bounds2.getMaxX();
        double bottomRightY = bounds2.getMaxY();

        // Create small bounds representing the corners
        Bounds topLeftCorner = new javafx.geometry.BoundingBox(topLeftX, topLeftY, 150, 80);
        Bounds topRightCorner = new javafx.geometry.BoundingBox(topRightX, topRightY, 150, 80);
        Bounds bottomLeftCorner = new javafx.geometry.BoundingBox(bottomLeftX, bottomLeftY, 150, 80);
        Bounds bottomRightCorner = new javafx.geometry.BoundingBox(bottomRightX, bottomRightY, 150, 80);

        Rectangle topLeftCornerR = createBoundsRectangle(topLeftX, topLeftY, "topLeft");
        Rectangle topRightCornerR = createBoundsRectangle(topRightX, topRightY, "topRight");
        Rectangle bottomLeftCornerR = createBoundsRectangle(bottomLeftX, bottomLeftY, "bottomLeft");
        Rectangle bottomRightCornerR = createBoundsRectangle(bottomRightX, bottomRightY, "bottomRight");
        //System.out.println(allthings.getChildren());
        allthings.getChildren().addAll(topLeftCornerR, topRightCornerR, bottomLeftCornerR, bottomRightCornerR);

        // Check which corner, if any, intersects with CardtoPlace
        if (bounds1.intersects(topLeftCorner)) {
            return "topLeft";
        } else if (bounds1.intersects(topRightCorner)) {
            return "topRight";
        } else if (bounds1.intersects(bottomLeftCorner)) {
            return "bottomLeft";
        } else if (bounds1.intersects(bottomRightCorner)) {
            return "bottomRight";
        }
        return null; // No intersection with any corner
    }
    private boolean isOverScrollPane(Node HandCard, ScrollPane scrollPane) {
        return scrollPane.getBoundsInParent().intersects(HandCard.getBoundsInParent());
    }

    private void returnToOriginalPosition(Node node) {
        if (!originalParent.equals(node.getParent())) {
            ((Pane) node.getParent()).getChildren().remove(node);
            originalParent.getChildren().add(node);
        }
        node.setLayoutX(initialXMap.get(node)); // Return to initial X position
        node.setLayoutY(initialYMap.get(node)); // Return to initial Y position
    }

    private void resetNodeSize(Node node) {
        node.setScaleX(1.0);
        node.setScaleY(1.0);
    }

    private static Rectangle createBoundsRectangle(double x, double y, String corner) {
        Rectangle rect;
        switch (corner){
            case "topLeft":
                rect = new Rectangle(x - 88, y -46, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
            case "topRight":
                rect = new Rectangle(x - 30, y -46, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
            case "bottomLeft":
                rect = new Rectangle(x -88, y -33, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
            case "bottomRight":
                rect = new Rectangle(x -30, y -33, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
        }
        return null;
    }

    private static Rectangle createBoundsRectangleForStartingCard(double x, double y, String corner) {
        Rectangle rect;
        switch (corner){
            case "topLeft":
                rect = new Rectangle(x - 88, y -46, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
            case "topRight":
                rect = new Rectangle(x - 30, y -46, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
            case "bottomLeft":
                rect = new Rectangle(x -88, y -33, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
            case "bottomRight":
                rect = new Rectangle(x -30, y -33, 120, 80);
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.GREEN);
                rect.setOpacity(50);
                rect.setStrokeWidth(2);
                return rect;
        }
        return null;
    }

}

