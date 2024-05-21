package Client.CLI;

import java.util.ArrayList;
import java.util.List;

    public class CLIPlayableCard {
        private List<CLICard> cardList;

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
            if (position >= 4 && position <= 8) {
                cardList.set(position, clicard); // Set the drawable card at the given position (4-8)
            } else {
                System.out.println("Invalid drawable card position. Must be between 4 and 8.");
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
                System.out.println("Position " + i + ": " + clicard);
            }
        }

        public static void main(String[] args) {
            CLIPlayableCard manager = new CLIPlayableCard();
            manager.setStarterCard(new CLICard(RandomCLICardPicker.getRandomCLISXXFileName(), "Starter Card", CLICard.getASCII()));
            manager.setHandCard(1, new CLICard(RandomCLICardPicker.getRandomCLIGXXFileName(), "Gold Card", CLICard.getASCII()));
            manager.setHandCard(2, new CLICard(RandomCLICardPicker.getRandomCLIXXFileName(), "Resource Card", CLICard.getASCII()));
            manager.setHandCard(3, new CLICard(RandomCLICardPicker.getRandomCLIXXFileName(), "Resource Card", CLICard.getASCII()));
            manager.setDrawableCard(4, new CLICard(RandomCLICardPicker.getRandomCLIXXFileName(), "Resource Card", CLICard.getASCII()));
            manager.setDrawableCard(5, new CLICard(RandomCLICardPicker.getRandomCLIGXXFileName(), "Drawable Gold Card", CLICard.getASCII()));
            manager.setDrawableCard(6, new CLICard(RandomCLICardPicker.getRandomCLIGXXFileName(), "Drawable Gold Card", CLICard.getASCII()));
            manager.setDrawableCard(7, new CLICard(RandomCLICardPicker.getRandomCLIXXFileName(), "Drawable Resource Card", CLICard.getASCII()));
            manager.setDrawableCard(8, new CLICard(RandomCLICardPicker.getRandomCLIXXFileName(), "Drawable Resource Card", CLICard.getASCII()));
            System.out.println("Initial card list:");
            manager.showCards();

            System.out.println("Using card at position 2:");
            manager.useCLICard(2);
            manager.showCards();
        }
    }

