package Model.Cards;


public class Card {
    private boolean top, left, right, bottom;  //4 boolean for the corners

    protected String type; // "Risorsa" o "Oro"
    protected String mainResource; // "Plants", "Animal", "Mushroom", "Insect"

    protected int points;

    public Card(String mainResource, boolean top, boolean left, boolean right, boolean bottom, String type, int points) {
        this.mainResource = mainResource;
        this.type = type;
        this.points = points;

        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;

    }
    //If corner playable then allows to be covered by other cards
    public boolean isTopPlayable() { return top;}
    public boolean isLeftPlayable() { return left; }
    public boolean isRightPlayable() { return right; }
    public boolean isBottomPlayable() { return bottom; }

    public int getPoints (){
        return this.points;
    }

    public String getMainResource (){
        return this.mainResource;
    }


}