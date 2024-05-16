package Client.GUI;

import Controller.GameBoard;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;
    private Pane originalParent;
    private double originalWidth;
    private double originalHeight;
    private final Map<Node, Double> initialXMap = new HashMap<>();
    private final Map<Node, Double> initialYMap = new HashMap<>();
    private final double initialCardX = 2000;
    private final double initialCardY = 2000;
    private final double initialCardWidth = 150;
    private final double initialCardHeight = 80;
    private final double snapDistance = 2; // Distance within which snapping occurs

    public void makeDraggable(Node node, ScrollPane scrollPane, double initialX, double initialY, Node left1) {
        initialXMap.put(node, initialX);
        initialYMap.put(node, initialY);

        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
            node.toFront();
            originalParent = (Pane) node.getParent(); // Save original parent
            originalWidth = node.getBoundsInLocal().getWidth();
            originalHeight = node.getBoundsInLocal().getHeight();
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);

            // Check if the node is over the scrollPane
            if (isOverScrollPane(node, scrollPane)) {
                resizeNode(node, 0.5, 0.5); // Resize the node
                snapToClosestCorner(node, scrollPane, (ImageView) left1); // Snap to the closest corner of the initial card
            } else {
                resetNodeSize(node); // Reset to original size if not over scrollPane
            }
        });

        node.setOnMouseReleased(event -> {
            // Check if the node is over the scrollPane
            if (isOverScrollPane(node, scrollPane)) {
                Pane content = (Pane) scrollPane.getContent();
                if (!content.equals(node.getParent())) {
                    originalParent.getChildren().remove(node);
                    content.getChildren().add(node);
                    // Adjust the node's position relative to the ScrollPane's content
                    double newX = node.getLayoutX() - scrollPane.getHvalue() * (content.getBoundsInLocal().getWidth() - scrollPane.getViewportBounds().getWidth());
                    double newY = node.getLayoutY() - scrollPane.getVvalue() * (content.getBoundsInLocal().getHeight() - scrollPane.getViewportBounds().getHeight());
                    node.setLayoutX(newX);
                    node.setLayoutY(newY);
                }
                snapToClosestCorner(node, scrollPane, (ImageView) left1); // Snap to the closest corner upon release if still over scrollPane
            } else {
                // Return to original parent and initial position if not dropped in scrollPane
                if (!originalParent.equals(node.getParent())) {
                    ((Pane) node.getParent()).getChildren().remove(node);
                    originalParent.getChildren().add(node);
                }
                node.setLayoutX(initialXMap.get(node)); // Return to initial X position
                node.setLayoutY(initialYMap.get(node)); // Return to initial Y position
            }
            resetNodeSize(node); // Reset the size after releasing the node
        });
    }

    private boolean isOverScrollPane(Node node, ScrollPane scrollPane) {
        return scrollPane.getBoundsInParent().intersects(node.getBoundsInParent());
    }

    private void resizeNode(Node node, double scaleX, double scaleY) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), node);
        scaleTransition.setToX(scaleX);
        scaleTransition.setToY(scaleY);
        scaleTransition.play();
    }

    private void resetNodeSize(Node node) {
        node.setScaleX(1.0);
        node.setScaleY(1.0);
    }

    private void snapToClosestCorner(Node node, ScrollPane scrollPane, ImageView left1) {
        double nodeWidth = node.getBoundsInLocal().getWidth();
        double nodeHeight = node.getBoundsInLocal().getHeight();

        Pane content = (Pane) scrollPane.getContent();

        // Calculate the relative positions within the ScrollPane content
        double relX = node.getLayoutX() + scrollPane.getHvalue() * (content.getBoundsInLocal().getWidth() - scrollPane.getViewportBounds().getWidth());
        double relY = node.getLayoutY() + scrollPane.getVvalue() * (content.getBoundsInLocal().getHeight() - scrollPane.getViewportBounds().getHeight());

        double snapX = relX;
        double snapY = relY;

        // Snap to the closest corner of the initial card
        double closestDistance = Double.MAX_VALUE;

        // Top-left corner of the initial card
        double distance = Math.hypot(relX - initialCardX, relY - initialCardY);
        if (distance < closestDistance) {
            //System.out.println(node);
            left1.setImage(new Image("/" + GameBoard.url1));
        }

        // Top-right corner of the initial card
        distance = Math.hypot(relX - (initialCardX + initialCardWidth), relY - initialCardY);
        if (distance < closestDistance) {
            closestDistance = distance;
            snapX = initialCardX + initialCardWidth;
            snapY = initialCardY;
        }

        // Bottom-left corner of the initial card
        distance = Math.hypot(relX - initialCardX, relY - (initialCardY + initialCardHeight));
        if (distance < closestDistance) {
            closestDistance = distance;
            snapX = initialCardX;
            snapY = initialCardY + initialCardHeight;
        }

        // Bottom-right corner of the initial card
        distance = Math.hypot(relX - (initialCardX + initialCardWidth), relY - (initialCardY + initialCardHeight));
        if (distance < closestDistance) {
            closestDistance = distance;
            snapX = initialCardX + initialCardWidth;
            snapY = initialCardY + initialCardHeight;
        }

        // Only snap if within snapDistance
        if (closestDistance <= snapDistance) {
            // Convert back to the ScrollPane content coordinates
            double newX = snapX - scrollPane.getHvalue() * (content.getBoundsInLocal().getWidth() - scrollPane.getViewportBounds().getWidth());
            double newY = snapY - scrollPane.getVvalue() * (content.getBoundsInLocal().getHeight() - scrollPane.getViewportBounds().getHeight());

            node.setLayoutX(newX);
            node.setLayoutY(newY);
        }
    }
}
