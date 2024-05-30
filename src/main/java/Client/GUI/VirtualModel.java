package Client.GUI;

import Model.Cards.CardJSON;
import Model.Cards.PlayerHand;

import java.util.ArrayList;

public class VirtualModel {
    private PlayerHand hand;
    private CardJSON cg1;
    private CardJSON cg2;
    private ArrayList<CardJSON> resourceDeck;
    private CardJSON starterFront;
    private CardJSON starterBack;
    private CardJSON chosenStarter;

    public CardJSON getChosenStarter() {
        return chosenStarter;
    }

    public void setChosenStarter(CardJSON chosenStarter) {
        this.chosenStarter = chosenStarter;
    }

    public CardJSON getPg1() {
        return pg1;
    }

    public void setPg1(CardJSON pg1) {
        this.pg1 = pg1;
    }

    public CardJSON getPg2() {
        return pg2;
    }

    public void setPg2(CardJSON pg2) {
        this.pg2 = pg2;
    }

    private CardJSON pg1;
    private CardJSON pg2;

    public CardJSON getStarterFront() {
        return starterFront;
    }

    public void setStarterFront(CardJSON starterFront) {
        this.starterFront = starterFront;
    }

    public CardJSON getStarterBack() {
        return starterBack;
    }

    public void setStarterBack(CardJSON starterBack) {
        this.starterBack = starterBack;
    }

    public PlayerHand getHand() {
        return hand;
    }

    public void setHand(PlayerHand hand) {
        this.hand = hand;
    }

    public CardJSON getCg1() {
        return cg1;
    }

    public void setCg1(CardJSON cg1) {
        this.cg1 = cg1;
    }

    public CardJSON getCg2() {
        return cg2;
    }

    public void setCg2(CardJSON cg2) {
        this.cg2 = cg2;
    }

    public ArrayList<CardJSON> getResourceDeck() {
        return resourceDeck;
    }

    public void setResourceDeck(ArrayList<CardJSON> resourceDeck) {
        this.resourceDeck = resourceDeck;
    }

    public ArrayList<CardJSON> getGoldDeck() {
        return goldDeck;
    }

    public void setGoldDeck(ArrayList<CardJSON> goldDeck) {
        this.goldDeck = goldDeck;
    }

    public CardJSON getPersonalGoal() {
        return personalGoal;
    }

    public void setPersonalGoal(CardJSON personalGoal) {
        this.personalGoal = personalGoal;
    }

    private ArrayList<CardJSON> goldDeck;
    private CardJSON personalGoal;
}
