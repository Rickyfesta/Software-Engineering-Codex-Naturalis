package Model.Board.PersonalBoard;

import java.awt.Point;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class PersonalBoard {
    private HashMap<Point, String> board;
    private int minX, maxX, minY, maxY;

    public PersonalBoard() {
        this.board = new HashMap<>();
        this.board.put(new Point(0, 0), "Starting Card"); // Initialize the origin
        minX = maxX = minY = maxY = 0; // Initialize the boundaries around the origin
    }

    public boolean placeCard(int x, int y, String card) {
        Point p = new Point(x, y);
        if (!board.containsKey(p)) { // Check if the spot is already taken
            board.put(p, card);
            updateBoundaries(x, y);
            return true;
        }
        return false;
    }

    private void updateBoundaries(int x, int y) {
        if (x < minX) minX = x;
        if (x > maxX) maxX = x;
        if (y < minY) minY = y;
        if (y > maxY) maxY = y;
    }

    public boolean isOccupied(int x, int y) {
        return board.containsKey(new Point(x, y));
    }

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

