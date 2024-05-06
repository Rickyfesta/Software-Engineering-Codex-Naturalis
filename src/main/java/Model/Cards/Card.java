package Model.Cards;


public class Card {
    private String top, left, right, bottom;  //4 boolean for the corners

    protected String type; // "Risorsa" o "Oro"
    protected String mainResource; // "Plants", "Animal", "Mushroom", "Insect"

    protected int points;

    public Card(String mainResource, boolean top, boolean left, boolean right, boolean bottom, String type, int points) {
        this.mainResource = mainResource;
        this.type = type;
        this.points = points;

        this.top = String.valueOf(top);
        this.left = String.valueOf(left);
        this.right = String.valueOf(right);
        this.bottom = String.valueOf(bottom);

    }
    //If corner playable then allows to be covered by other cards


    public int getPoints (){
        return this.points;
    }

    public String getMainResource (){
        return this.mainResource;
    }


}