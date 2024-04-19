package Cards;


public class Card {
    private boolean top, left, right, bottom;  //4 boolean for the corners
    protected String type; // "Risorsa" o "Oro"
    protected int points;

    public Card(boolean top, boolean left, boolean right, boolean bottom, String type, int points) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.type = type;
        this.points = points;
    }
    //If corner playable then allows to be covered by other cards
    public boolean isTopPlayable() { return top; }
    public boolean isLeftPlayable() { return left; }
    public boolean isRightPlayable() { return right; }
    public boolean isBottomPlayable() { return bottom; }
}