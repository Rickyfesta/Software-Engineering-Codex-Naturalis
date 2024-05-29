package Model.Board.PersonalBoard;

import java.awt.Point;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class PersonalBoard {
    private HashMap<Point, String> board;
    private int minX, maxX, minY, maxY;
    /**
     * Initializes the personal board with the starting card at the origin.
     * @ensures board != null;
     * @ensures board.containsKey(new Point(0, 0));
     */

    public PersonalBoard() {
        this.board = new HashMap<>();
        this.board.put(new Point(0, 0), "Starting Card"); // Initialize the origin
        minX = maxX = minY = maxY = 0; // Initialize the boundaries around the origin
    }
 //TODO connect this method with the class card.
    /**
     * Places a card at the specified coordinates if the spot is not already taken.
     * @param x The x-coordinate where the card should be placed.
     * @param y The y-coordinate where the card should be placed.
     * @param card The card to be placed at the specified coordinates.
     * @requires card != null;
     * @ensures board.containsKey(new Point(x, y)) == \result;
     * @return true if the card is successfully placed, false if the spot is already taken.
     */
    public boolean placeCard(int x, int y, String card) {
        Point p = new Point(x, y);
        if (!board.containsKey(p)) { // Check if the spot is already taken
            board.put(p, card);
            updateBoundaries(x, y);
            return true;
        }
        return false;
    }
    /**
     * Updates the boundaries of the board.
     * @param x The x-coordinate of the placed card.
     * @param y The y-coordinate of the placed card.
     * @ensures minX <= x <= maxX;
     * @ensures minY <= y <= maxY;
     */
    private void updateBoundaries(int x, int y) {
        if (x < minX) minX = x;
        if (x > maxX) maxX = x;
        if (y < minY) minY = y;
        if (y > maxY) maxY = y;
    }
    /**
     * Checks if a spot on the board is occupied.
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @ensures \result == board.containsKey(new Point(x, y));
     * @return true if the spot is occupied, false otherwise.
     */

    public boolean isOccupied(int x, int y) {
        return board.containsKey(new Point(x, y));
    }
    /**
     * Gets the list of adjacent points that are not occupied.
     * @param x The x-coordinate of the reference point.
     * @param y The y-coordinate of the reference point.
     * @ensures \result != null;
     * @return A list of adjacent points that are not occupied.
     */

    public List<Point> getAdjacent(int x, int y) {
        List<Point> adjacent = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            Point p = new Point(x + dx[i], y + dy[i]);
            if (!board.containsKey(p)) { // Only add if not already occupied
                adjacent.add(p);
            }
        }
        return adjacent;
    }
    /**
     * Provides a string representation of the board.
     * @ensures \result != null;
     * @return A string representation of the board.
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                Point p = new Point(x, y);
                sb.append(board.containsKey(p) ? board.get(p).substring(0, 1) : ".");
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

