package Model.Cards;

//TODO: in json manage the flipping card and renew the corner metodology (null or empty corners)
public class Card {
    private String top, left, right, bottom, symbol; //If corner not playable String == null ; else empty else if resource on the corner = Resource
    protected String type; // "Risorsa" o "Oro"
    protected String color = null; // "Plants", "Animal", "Mushroom", "Insect"
    protected int points;
    boolean isFlipped; //Mapper will adjust to "mainResource"Back.jpg



    public Card(String color, String top, String left, String right, String bottom, String type, String symbol, int points) {
        this.color = color; //for object cards
        this.type = type;
        this.points = points;
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.symbol = null;

    }
    //If corner playable then allows to be covered by other cards
    //TODO: Needs to be called when card is picked up
    public boolean getCorner (String corner){
        return corner != null;
    }
    public String getMainResource (){ //This will serve the mapper
        return this.color;
    }
    public void FlipCard (boolean isFlipped){
        isFlipped = !isFlipped;
        if(isFlipped){ //if it's flipped it's always like this
            this.top = "";
            this.left = "";
            this.right = "";
            this.bottom = "";
            this.symbol = color; //resource , not placeable on
        }
    }

}