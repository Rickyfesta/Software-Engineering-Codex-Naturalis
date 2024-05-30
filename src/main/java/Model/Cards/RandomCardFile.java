package Model.Cards;

import java.util.Random;


//Issue
public class RandomCardFile {
    public static void main(String[] args) {
        // Get a random card front and its corresponding back
        String randomFront = getRandomXXFileName(); //Resource
        String randomGFront = getRandomGXXFileName(); //Gold
        String randomOFront = getRandomOXXFileName(); //Objective
        String randomSFront = getRandomSXXFileName(); //Starter
        System.out.println(randomSFront);
        String associatedBack = getAssociatedBackFileName(randomFront);
        String associatedOBack = getAssociatedOBackFileName(randomOFront);
        String associatedGBack = getAssociatedGBackFileName(randomGFront);
        String associatedSBack = getRandomSXXFileNameBack(randomSFront);
        /*System.out.println("Random front file: " + randomFront);
        System.out.println("Associated back file: " + associatedBack);
        System.out.println("Random Gold front file: " + randomGFront);
        System.out.println("Associated Gold back file: " + associatedGBack);
        System.out.println("Random Objective front file: " + randomOFront);
        System.out.println("Associated Objective back file: " + associatedOBack);
        System.out.println("Random Starter front file: " + randomSFront);
        System.out.println("Associated Starter back file: " + associatedSBack)*/;
    }

    // Method to generate a random "XXfront.json" file name
    /**@ ensures \result != null && \result.length() == 11; */
    public static String getRandomXXFileName() {
        String number = generateRandomNumber();
        //System.out.println(number + "front.json");
        return number + "front.jpg";
    }

    // Method to generate a random "GXXfront.json" file name
    /**@ ensures \result != null && \result.length() == 12; */
    public static String getRandomGXXFileName() {
        String number = generateRandomNumber();
        return "G" + number + "front.jpg";
    }

    // Method to generate a random "OXXfront.json" file name
    /**@ ensures \result != null && \result.length() == 12; */
    public static String getRandomOXXFileName() {
        String number = generateRandomNumberO();
        return "O" + number + "front.jpg";
    }
    // Method to generate a random "SXXfront.json" file name
    /**@ ensures \result != null && \result.length() == 12; */
    public static String getRandomSXXFileName() {
        String number = generateRandomNumber1();
        String back = "S" + number + "back.jpg";
        return "S" + number + "front.jpg";
    }
    //file takes the random number and return back
    /**@ requires back != null;
      @ ensures \result != null && \result.equals(back.replace("front", "back"));
      */
    public static String getRandomSXXFileNameBack(String back) {
        return back.replace("front", "back");
    }


    // Helper method to generate a random two-digit number
    /**@ ensures \result != null && \result.length() == 2; */
    private static String generateRandomNumber() {
        Random random = new Random();
        int cardNumber;  // Generates a number from 1 to 20
            cardNumber = 1 + random.nextInt(40);  // Generates a number from 1 to 40
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }

    // Helper method to generate a random two-digit number
    /**@ ensures \result != null && \result.length() == 2; */
    private static String generateRandomNumberO() {
        Random random = new Random();
        int cardNumber;  // Generates a number from 1 to 20
            cardNumber = 1 + random.nextInt(16);  // Generates a number from 1 to 40
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }
    /**@ ensures \result != null && \result.length() == 2; */
    private static String generateRandomNumber1() {
        Random random = new Random();
        int cardNumber;// Generates a number from 1 to 20
            cardNumber = 1 + random.nextInt(6);  // Generates a number from 1 to 40
        return String.format("%02d", cardNumber);  // Formats the number as two digits
    }
    // Determines the associated back file based on the card number from the front file
    /**@ requires frontFileName != null;
      @ ensures \result != null && (\result.equals("MushroomBack.jpg") || \result.equals("PlantBack.jpg") || \result.equals("AnimalBack.jpg") || \result.equals("InsectBack.jpg"));
      */
    public static String getAssociatedBackFileName(String frontFileName) {
        // Extract the number from the filename
        int cardNumber = Integer.parseInt(frontFileName.substring(0, 2));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "Images/MushroomBack.jpg";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "Images/PlantBack.jpg";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "Images/AnimalBack.jpg";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "Images/InsectBack.jpg";
        } else {
            return null;  // Invalid card number

        }
    }

    // Determines the associated back file based on the card number from the front file
     /**@ requires frontFileName != null;
      @ ensures \result != null && (\result.equals("GMushroomBack.jpg") || \result.equals("GPlantBack.jpg") || \result.equals("GAnimalBack.jpg") || \result.equals("GInsectBack.jpg"));
      */
    public static String getAssociatedGBackFileName(String frontFileName) {
        // Extract the number from the filename
        //System.out.println(Integer.parseInt(frontFileName.substring(1, 3)));
        int cardNumber = Integer.parseInt(frontFileName.substring(1, 3));

        // Return the corresponding back file
        if (cardNumber >= 1 && cardNumber <= 10) {
            return "Images/GMushroomBack.jpg";
        } else if (cardNumber >= 11 && cardNumber <= 20) {
            return "Images/GPlantBack.jpg";
        } else if (cardNumber >= 21 && cardNumber <= 30) {
            // Handle unexpected card number, if necessary
            return "Images/GAnimalBack.jpg";
        } else if (cardNumber >= 31 && cardNumber <= 40) {
            return "Images/GInsectBack.jpg";
        } else {
            return null;  // Invalid card number

        }
    }

    // Determines the associated back file based on the card number from the front file
     /**@ requires frontFileName != null;
      @ ensures \result != null && \result.equals("OBack.jpg");
      */
    public static String getAssociatedOBackFileName(String frontFileName) {
        // Extract the number from the filename
        //System.out.println(Integer.parseInt(frontFileName.substring(1, 3)));
        int cardNumber = Integer.parseInt(frontFileName.substring(1, 3));

        // Return the corresponding back file
        return "Images/OBack.jpg";
    }

}

