package Client.CLI;

import java.util.Random;

public class RandomCLICardPicker {
    public static void main(String[] args) {
        // Get a random card front and its corresponding back
        String randomCLIFront = getRandomCLIXXFileName(); //Resource
        String randomCLIGFront = getRandomCLIGXXFileName(); //Gold
        String randomCLIOFront = getRandomCLIOXXFileName(); //Objective
        String randomCLISFront = getRandomCLISXXFileName(); //Starter
        String associatedCLIBack = getAssociatedCLIBackFileName(randomCLIFront);
        String associatedCLIGBack = getAssociatedCLIGBackFileName(randomCLIGFront);
        String associatedCLISBack = getRandomCLISXXFileNameBack(randomCLISFront);
        System.out.println("Random front file: " + randomCLIFront);
        System.out.println("Associated back file: " + associatedCLIBack);
        System.out.println("Random Gold front file: " + randomCLIGFront);
        System.out.println("Associated Gold back file: " + associatedCLIGBack);
        System.out.println("Random Objective front file: " + randomCLIOFront);
        System.out.println("Random Starter front file: " + randomCLISFront);
        System.out.println("Associated Starter back file: " + associatedCLISBack);
    }

    // Method to generate a random "XXfront.json" file name
    public static String getRandomCLIXXFileName() {
        String number = generateRandomNumber();
        //System.out.println(number + "front.json");
        return "CLI" + number + "front.json";
    }

    // Method to generate a random "GXXfront.json" file name
    public static String getRandomCLIGXXFileName() {
        String number = generateRandomNumber();
        return "CLIG" + number + "front.json";
    }

    // Method to generate a random "OXXfront.json" file name
    public static String getRandomCLIOXXFileName() {
        String number = generateRandomNumberO();
        return "CLIO" + number + "front.json";
    }
    // Method to generate a random "SXXfront.json" file name
    public static String getRandomCLISXXFileName() {
        String number = generateRandomNumber1();
        return "CLIS" + number + "front.json";
    }
    //file takes the random number and return back
    public static String getRandomCLISXXFileNameBack(String back) {
        return back.replace("front", "back");
    }


    // Helper method to generate a random two-digit number
    private static String generateRandomNumber() {
        Random random = new Random();
        int cardNumber;  // Generates a number from 1 to 20
        cardNumber = 1 + random.nextInt(40);  // Generates a number from 1 to 40
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }

    // Helper method to generate a random two-digit number
    private static String generateRandomNumberO() {
        Random random = new Random();
        int cardNumber;  // Generates a number from 1 to 20
        cardNumber = 1 + random.nextInt(16);  // Generates a number from 1 to 40
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }
    private static String generateRandomNumber1() {
        Random random = new Random();
        int cardNumber;// Generates a number from 1 to 20
        cardNumber = 1 + random.nextInt(6);  // Generates a number from 1 to 40
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }
    // Determines the associated back file based on the card number from the front file
    public static String getAssociatedCLIBackFileName(String frontFileName) {
        // Extract the number from the filename
        int cardNumber = Integer.parseInt(frontFileName.substring(3, 5));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "CLIMushroomBack.json";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "CLIPlantBack.json";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "CLIAnimalBack.json";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "CLIInsectBack.json";
        } else {
            return null;  // Invalid card number

        }
    }

    // Determines the associated back file based on the card number from the front file
    public static String getAssociatedCLIGBackFileName(String frontFileName) {
        // Extract the number from the filename
        //System.out.println(Integer.parseInt(frontFileName.substring(1, 3)));
        int cardNumber = Integer.parseInt(frontFileName.substring(4, 6));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "CLIMushroomBack.json";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "CLIPlantBack.json";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "CLIAnimalBack.json";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "CLIInsectBack.json";
        } else {
            return null;  // Invalid card number

        }
    }

}
