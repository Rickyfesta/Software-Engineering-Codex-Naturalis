package Model.Cards;

import java.util.Random;


//Issue
public class RandomCardFile {
    public static void main(String[] args) {
        // Get a random card front and its corresponding back
        String randomFront = getRandomXXFileName();
        String randomGFront = getRandomGXXFileName();
        String randomOFront = getRandomOXXFileName();
        String randomSFront = getRandomSXXFileName();
        String associatedBack = getAssociatedBackFileName(randomFront);
        String associatedOBack = getAssociatedOBackFileName(randomOFront);
        String associatedGBack = getAssociatedGBackFileName(randomGFront);
        String associatedSBack = getAssociatedOBackFileName(randomSFront);
        System.out.println("Random front file: " + randomFront);
        System.out.println("Associated back file: " + associatedBack);
        System.out.println("Random Gold front file: " + randomGFront);
        System.out.println("Associated Gold back file: " + associatedGBack);
        System.out.println("Random Objective front file: " + randomOFront);
        System.out.println("Associated Objective back file: " + associatedOBack);
        System.out.println("Random Starter front file: " + randomSFront);
        System.out.println("Associated Objective back file: " + associatedSBack);
    }

    // Method to generate a random "XXfront.json" file name
    public static String getRandomXXFileName() {
        String number = generateRandomNumber();
        //System.out.println(number + "front.json");
        return number + "front.json";
    }

    // Method to generate a random "GXXfront.json" file name
    public static String getRandomGXXFileName() {
        String number = generateRandomNumber();
        return "G" + number + "front.json";
    }

    // Method to generate a random "OXXfront.json" file name
    public static String getRandomOXXFileName() {
        String number = generateRandomNumberO();
        return "O" + number + "front.json";
    }
    // Method to generate a random "SXXfront.json" file name
    public static String getRandomSXXFileName() {
        String number = generateRandomNumber1();
        return "S" + number + "front.json";
    }
    // Helper method to generate a random two-digit number
    private static String generateRandomNumber() {
        Random random = new Random();
        int cardNumber = 1 + random.nextInt(40);  // Generates a number from 1 to 20
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }

    // Helper method to generate a random two-digit number
    private static String generateRandomNumberO() {
        Random random = new Random();
        int cardNumber = 1 + random.nextInt(16);  // Generates a number from 1 to 20
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }
    private static String generateRandomNumber1() {
        Random random = new Random();
        int cardNumber = 1 + random.nextInt(6);  // Generates a number from 1 to 20
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }
    // Determines the associated back file based on the card number from the front file
    public static String getAssociatedBackFileName(String frontFileName) {
        // Extract the number from the filename
        int cardNumber = Integer.parseInt(frontFileName.substring(0, 2));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "MushroomBack.json";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "PlantBack.json";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "AnimalBack.json";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "InsectBack.json";
        } else {
            return null;  // Invalid card number

        }
    }

    // Determines the associated back file based on the card number from the front file
    public static String getAssociatedGBackFileName(String frontFileName) {
        // Extract the number from the filename
        //System.out.println(Integer.parseInt(frontFileName.substring(1, 3)));
        int cardNumber = Integer.parseInt(frontFileName.substring(1, 3));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "GMushroomBack.json";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "GPlantBack.json";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "GAnimalBack.json";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "GInsectBack.json";
        } else {
            return null;  // Invalid card number

        }
    }

    // Determines the associated back file based on the card number from the front file
    public static String getAssociatedOBackFileName(String frontFileName) {
        // Extract the number from the filename
        //System.out.println(Integer.parseInt(frontFileName.substring(1, 3)));
        int cardNumber = Integer.parseInt(frontFileName.substring(1, 3));

        // Return the corresponding back file
        return "OBack.json";
    }
    // Determines the associated back file based on the card number from the front file
    /*public static String getAssociatedGBackFileName(String frontFileName) {
        // Extract the number from the filename
        //System.out.println(Integer.parseInt(frontFileName.substring(1, 3)));
        int cardNumber = Integer.parseInt(frontFileName.substring(1, 3));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "GMushroomBack.json";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "GPlantBack.json";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "GAnimalBack.json";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "GInsectBack.json";
        } else {
            return null;  // Invalid card number

      }*/
    }
}

