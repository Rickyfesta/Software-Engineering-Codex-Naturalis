package Model.Cards;

//TODO: in json manage the flipping card and renew the corner metodology (null or empty corners)
public class Card {
    private String top, left, right, bottom, center; //If corner not playable String == null ; else empty else if resource on the corner = Resource
    protected String type; // "Risorsa" o "Oro"
    protected String mainResource; // "Plants", "Animal", "Mushroom", "Insect"
    protected int points;
    boolean isFlipped; //Mapper will adjust to "mainResource"Back.jpg



    public Card(String mainResource, String top, String left, String right, String bottom, String type, String center, int points) {
        this.mainResource = mainResource; //for object cards
        this.type = type;
        this.points = points;
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.center = null;

    }
    //If corner playable then allows to be covered by other cards
    //TODO: Needs to be called when card is picked up
    public boolean getCorner (String corner){
        return corner != null;
    }
    public int getPoints (){
        return this.points;
    }
    public String getMainResource (){ //This will serve the mapper
        return this.mainResource;
    }
    public void FlipCard (boolean isFlipped){
        isFlipped = !isFlipped;
        if(isFlipped){ //if it's flipped it's always like this
            this.top = "";
            this.left = "";
            this.right = "";
            this.bottom = "";
            this.center = mainResource; //resource , not placiable on
        }
    }

}