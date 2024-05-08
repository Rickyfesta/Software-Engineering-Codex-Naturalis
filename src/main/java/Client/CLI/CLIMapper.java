package Client.CLI;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CLIMapper {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CLICard cardArt= mapper.readValue(new File("src/main/resources/CLI"), CLICard.class);
            System.out.println("Art ID: " + cardArt.getID());
            System.out.println("Description: " + cardArt.getDESCRIPTION());
            System.out.println("ASCII Art:");
            cardArt.getASCII().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}