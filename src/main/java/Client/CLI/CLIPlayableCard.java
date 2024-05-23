package Client.CLI;

import java.util.ArrayList;
import java.util.List;

    public class CLIPlayableCard {
        private List<CLICard> cardList;
        private static CLIMapper mapper = new CLIMapper();

        public CLIPlayableCard() {
            cardList = new ArrayList<>(8); // Initialize with a size of 4
            for (int i = 0; i < 8; i++) {
                cardList.add(null); // Pre-fill with null values
            }
        }

        public void setStarterCard(CLICard clicard) {
            cardList.set(0, clicard); // Set the starter card at position 0
        }

        public void setHandCard(int position, CLICard clicard) {
            if (position >= 1 && position <= 3) {
                cardList.set(position, clicard); // Set the hand card at the given position (1-3)
            } else {
                System.out.println("Invalid hand card position. Must be between 1 and 3.");
            }
        }
        public void setDrawableCard(int position, CLICard clicard) {
            if (position >= 4 && position <= 7) {
                cardList.set(position, clicard); // Set the drawable card at the given position (4-7)
            } else {
                System.out.println("Invalid drawable card position. Must be between 4 and 7.");
            }

        }
        public void useCLICard(int position) {
            if (position >= 0 && position < cardList.size() && cardList.get(position) != null) {
                cardList.remove(position); // Remove the card from the specified position
                cardList.add(null); // Maintain the size of the list by adding a null value
            } else {
                System.out.println("Invalid card position or card already used.");
            }
        }
        public void showCards() {
            for (int i = 0; i < cardList.size(); i++) {
                CLICard clicard = cardList.get(i);
                if (i==0) System.out.println("Starter card:");
                else if (i >= 1 && i <= 3) System.out.println("Hand card " + i + ":");
                else System.out.println("Drawable card " + i + ":");

                clicard.getASCII().forEach(System.out::println);
            }
        }

        public static void main(String[] args) {
            CLIPlayableCard manager = new CLIPlayableCard();
            manager.setStarterCard(mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLISXXFileName()));
            manager.setHandCard(1, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIXXFileName()));
            manager.setHandCard(2, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIXXFileName()));
            manager.setHandCard(3, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIGXXFileName()));
            manager.setDrawableCard(4, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIXXFileName()));
            manager.setDrawableCard(5, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIXXFileName()));
            manager.setDrawableCard(6, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIGXXFileName()));
            manager.setDrawableCard(7, mapper.getCard("/CLI/"+RandomCLICardPicker.getRandomCLIGXXFileName()));
            System.out.println("Initial card list:");
            manager.showCards();

        }
    }

