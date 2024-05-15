package Client.GUI;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;
    private ScaleTransition scaleTransition;
    private Pane originalParent;

    public void makeDraggable(Node node, ScrollPane scrollPane) {
        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
            node.toFront();
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
        });


        node.setOnMouseReleased(event -> {
            Pane content = (Pane) scrollPane.getContent();
            if (isInsideScrollPane(node, scrollPane)) {
                if (!content.equals(node.getParent())) {
                    originalParent.getChildren().remove(node);
                    content.getChildren().add(node);
                    node.setLayoutX(event.getSceneX() - scrollPane.localToScene(scrollPane.getBoundsInLocal()).getMinX() - mouseAnchorX);
                    node.setLayoutY(event.getSceneY() - scrollPane.localToScene(scrollPane.getBoundsInLocal()).getMinY() - mouseAnchorY);
                }
            } else {
                // Optional: return to original parent if not dropped in scrollPane
                if (!originalParent.equals(node.getParent())) {
                    content.getChildren().remove(node);
                    originalParent.getChildren().add(node);
                    node.setLayoutX(event.getSceneX() - originalParent.localToScene(originalParent.getBoundsInLocal()).getMinX() - mouseAnchorX);
                    node.setLayoutY(event.getSceneY() - originalParent.localToScene(originalParent.getBoundsInLocal()).getMinY() - mouseAnchorY);
                }
            }
        });
    }

    private boolean isInsideScrollPane(Node node, ScrollPane scrollPane) {
        double x = node.getLayoutX() + node.getTranslateX();
        double y = node.getLayoutY() + node.getTranslateY();
        return x >= 0 && y >= 0 && x + node.getBoundsInLocal().getWidth() <= scrollPane.getContent().getBoundsInLocal().getWidth() &&
                y + node.getBoundsInLocal().getHeight() <= scrollPane.getContent().getBoundsInLocal().getHeight();
    }

    }
