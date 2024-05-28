package Client.CLI;

import Model.Cards.CardJSON;
import Model.Cards.RandomCardFile;

import java.util.ArrayList;
import java.util.List;

    public class  CLIPlayableCard {
        private List<CardJSON> cardList;
        private static CLIMapper mapper = new CLIMapper();
        public static List<String> cardFileNames;

         /*@ ensures cardList != null;
      @ ensures cardFileNames != null;
      @*/
        public CLIPlayableCard() {
            cardList = new ArrayList<>(8); // Initialize with a size of 4
            for (int i = 0; i < 8; i++) {
                cardList.add(null); // Pre-fill with null values
            }
            cardFileNames = new ArrayList<>();
        }
        /*@ requires clicard != null;
      @ requires cardFileName != null;
      @ ensures cardList.get(0) == clicard;
      @ ensures cardFileNames.contains(cardFileName);
      @*/
        public void setStarterCard(CardJSON clicard, String cardFileName) {
            cardList.set(0, clicard); // Set the starter card at position 0
            cardFileNames.add(cardFileName); // Track the card file name
            //cardFileNames.set(0, cardFileName); // Track the card file name (overwrite the previous value at index 0
        }
        /*@ requires clicard != null;
      @ requires cardFileName != null;
      @ requires position >= 1 && position <= 3;
      @ ensures cardList.get(position) == clicard;
      @ ensures cardFileNames.get(position).equals(cardFileName);
      @*/
        public void setHandCard(int position, CardJSON clicard, String cardFileName) {
            if (position >= 1 && position <= 3) {
                cardList.set(position, clicard); // Set the hand card at the given position (1-3)
                cardFileNames.add(cardFileName);
                cardFileNames.set(position, cardFileName);
            } else {
                System.out.println("Invalid hand card position. Must be between 1 and 3.");
            }
        }
        /*@ requires clicard != null;
      @ requires cardFileName != null;
      @ requires position >= 4 && position <= 7;
      @ ensures cardList.get(position) == clicard;
      @ ensures cardFileNames.get(position).equals(cardFileName);
      @*/
        public void setDrawableCard(int position, CardJSON clicard, String cardFileName) {
            if (position >= 4 && position <= 7) {
                cardList.set(position, clicard);// Set the drawable card at the given position (4-7)
                cardFileNames.add(cardFileName);
                cardFileNames.set(position, cardFileName);
            } else {
                System.out.println("Invalid drawable card position. Must be between 4 and 7.");
            }

        }
        /*@ requires position >= 0 && position < cardList.size();
     @ ensures cardList.get(position) == null;
     @ ensures cardFileNames.get(position) == null;
     @*/
        public void useCLICard(int position) {
            if (position >= 0 && position < cardList.size() && cardList.get(position) != null) {
               // cardList.remove(position); // Remove the card from the specified position
                cardList.set(position, null); // Set the card at the specified position to null
                //cardList.add(null); // Maintain the size of the list by adding a null value
                cardFileNames.set(position, null); // Remove the card file name from the list
            } else {
                System.out.println("Invalid card position or card already used.");
            }
        }
        /*@ ensures \result != null;
      @*/
        public List<CardJSON> getCardList() {
            return cardList;
        }
         /*@ ensures \result != null;
      @*/
        public static List<String> getCardFileNames() {
            return cardFileNames;
        }
        /*@ ensures \result != null;
      @*/
        public List<String> showCards() {
            for (int i = 0; i < cardList.size(); i++) {
                CardJSON clicard = cardList.get(i);
                if (clicard != null) {
                    if (i == 0) System.out.println("Starter card:");
                    else if (i >= 1 && i <= 3) System.out.println("Hand card " + i + ":");
                    else System.out.println("Drawable card " + i + ":");

                    clicard.getASCII().forEach(System.out::println);
                }
            }
            return cardFileNames;
        }

        public static void setUpHand() {
            CLIPlayableCard manager = new CLIPlayableCard();
            String card1 = RandomCardFile.getRandomSXXFileName().replace("jpg", "json");
            String card2 = RandomCardFile.getRandomXXFileName().replace("jpg", "json");
            String card3 = RandomCardFile.getRandomXXFileName().replace("jpg", "json");
            String card4 = RandomCardFile.getRandomGXXFileName().replace("jpg", "json");
            String card5 = RandomCardFile.getRandomXXFileName().replace("jpg", "json");
            String card6 = RandomCardFile.getRandomXXFileName().replace("jpg", "json");
            String card7 = RandomCardFile.getRandomGXXFileName().replace("jpg", "json");
            String card8 = RandomCardFile.getRandomGXXFileName().replace("jpg", "json");
            CardJSON starterCard = mapper.getCard("/json/" + card1);
            CardJSON handCard1 = mapper.getCard("/json/" + card2);
            CardJSON handCard2 = mapper.getCard("/json/" + card3);
            CardJSON handCard3 = mapper.getCard("/json/" + card4);
            CardJSON drawableCard1 = mapper.getCard("/json/" + card5);
            CardJSON drawableCard2 = mapper.getCard("/json/" + card6);
            CardJSON drawableCard3 = mapper.getCard("/json/" + card7);
            CardJSON drawableCard4 = mapper.getCard("/json/" + card8);
            manager.setStarterCard(starterCard, card1);
            manager.setHandCard(1, handCard1, card2);
            manager.setHandCard(2, handCard2, card3);
            manager.setHandCard(3, handCard3, card4);
            manager.setDrawableCard(4, drawableCard1, card5);
            manager.setDrawableCard(5, drawableCard2, card6);
            manager.setDrawableCard(6, drawableCard3, card6);
            manager.setDrawableCard(7, drawableCard4, card7);
            System.out.println("Initial card list:");
            manager.showCards();
        }
    }

