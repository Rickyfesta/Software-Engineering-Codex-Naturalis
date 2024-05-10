package Client.CLI;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CLIMapper {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CLICard cardArt = mapper.readValue(CLIMapper.class.getResourceAsStream("/CLI/CLI20front.json"), CLICard.class);
            System.out.println("Art ID: " + cardArt.getID());
            System.out.println("Description: " + cardArt.getDESCRIPTION());
            System.out.println("ASCII Art:");
            cardArt.getASCII().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            /*CLICard cardArt= mapper.readValue(new File("/CLI"), CLICard.class);
            System.out.println("Art ID: " + cardArt.getID());
            System.out.println("Description: " + cardArt.getDESCRIPTION());
            System.out.println("ASCII Art:");
            cardArt.getASCII().forEach(System.out::println);*/
        }
    }
}