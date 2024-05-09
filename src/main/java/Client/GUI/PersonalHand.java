package Client.GUI;

import static Model.Cards.RandomCardFile.getRandomGXXFileName;
import static Model.Cards.RandomCardFile.getRandomXXFileName;

public class PersonalHand {

    public static String[] myHand = new String[3];
    public static void start(){ //Method to create the hand of the client
        myHand[1] = getRandomGXXFileName();
        myHand[2] = getRandomXXFileName();
        myHand[3] = getRandomXXFileName();
        //System.out.println(myHand[1]);
    }

    public static String getCard1(){
        return (myHand[1]);
    }
    public String getCard2(){
        return myHand[2];
    }
    public String getCard3(){
        return myHand[3];
    }
}
