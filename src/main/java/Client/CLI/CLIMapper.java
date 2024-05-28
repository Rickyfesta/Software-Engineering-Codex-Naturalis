package Client.CLI;

import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CLIMapper {
    /*@ requires args != null;
      @ ensures \result != null || \result == null;
      @*/
    public CardJSON getCard(String args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            /*@ nullable @*/
            CardJSON cardArt = mapper.readValue(CLIMapper.class.getResourceAsStream(args), CardJSON.class);
            //cardArt.getASCII().forEach(System.out::println);
            return cardArt;
        } catch (Exception e) {
            e.printStackTrace();
            /*CLICard cardArt= mapper.readValue(new File("/CLI"), CLICard.class);
            System.out.println("Art ID: " + cardArt.getID());
            System.out.println("Description: " + cardArt.getDESCRIPTION());
            System.out.println("ASCII Art:");
            cardArt.getASCII().forEach(System.out::println);*/
        }
        return null;
    }
}