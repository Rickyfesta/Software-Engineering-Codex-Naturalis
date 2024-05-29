package Model.Cards;

//TODO: in json manage the flipping card and renew the corner metodology (null or empty corners)
public class Card {
    private String top, left, right, bottom, symbol; //If corner not playable String == null ; else empty else if resource on the corner = Resource
    protected String type; // "Risorsa" o "Oro"
    protected String color = null; // "Plants", "Animal", "Mushroom", "Insect"
    protected int points;
    boolean isFlipped; //Mapper will adjust to "mainResource"Back.jpg
 /**@ requires color != null;
      @ requires top != null;
      @ requires left != null;
      @ requires right != null;
      @ requires bottom != null;
      @ requires type != null;
      @ requires symbol != null;
      @ requires points >= 0;
      @ ensures this.color == color;
      @ ensures this.type == type;
      @ ensures this.points == points;
      @ ensures this.top == top;
      @ ensures this.left == left;
      @ ensures this.right == right;
      @ ensures this.bottom == bottom;
      @ ensures this.symbol == null;
      */


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
    // Getters
    public String getColor() {
        return color;
    }

    public String getTop() {
        return top;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getBottom() {
        return bottom;
    }

    public String getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public String getSymbol() {
        return symbol;
    }
    //If corner playable then allows to be covered by other cards
    //TODO: Needs to be called when card is picked up
    /**@ ensures \result == (corner != null);
      */
    public boolean getCorner (String corner){
        return corner != null;
    }
    /**@ ensures \result == this.color;
      */
    public String getMainResource (){ //This will serve the mapper
        return this.color;
    }
    /**@ ensures this.isFlipped == !isFlipped;
     @ ensures this.top == "" <==> this.isFlipped;
     @ ensures this.left == "" <==> this.isFlipped;
     @ ensures this.right == "" <==> this.isFlipped;
     @ ensures this.bottom == "" <==> this.isFlipped;
     @ ensures this.symbol == color <==> this.isFlipped;
     */
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