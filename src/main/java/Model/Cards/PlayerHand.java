package Model.Cards;

public class PlayerHand {
    private CardJSON cardOne;
    private CardJSON cardTwo;
    private CardJSON cardThree;

    public CardJSON getCardOne() {
        return cardOne;
    }

    public CardJSON getCardTwo() {
        return cardTwo;
    }

    public CardJSON getCardThree() {
        return cardThree;
    }

    public void setCardOne(CardJSON cardOne) {
        this.cardOne = cardOne;
    }

    public void setCardTwo(CardJSON cardTwo) {
        this.cardTwo = cardTwo;
    }

    public void setCardThree(CardJSON cardThree) {
        this.cardThree = cardThree;
    }
}
