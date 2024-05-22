package Client.CLI;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CLIMapper {
    public CLICard getCard(String args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CLICard cardArt = mapper.readValue(CLIMapper.class.getResourceAsStream(args), CLICard.class);
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