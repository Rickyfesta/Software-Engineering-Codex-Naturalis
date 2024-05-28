package Client.CLI;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CLIPlayableCardTest extends TestCase {
        private CLIPlayableCard cliPlayableCard;
        private CLICard card;

        @BeforeEach
        public void setUp() {
            cliPlayableCard = new CLIPlayableCard();
            card= new CLICard();
        }

        @Test
        public void testSetStarterCard() {
            cliPlayableCard.setStarterCard(card);
            assertEquals(card, cliPlayableCard.showCards().get(0));
        }

        @Test
        public void testSetHandCard() {
            cliPlayableCard.setHandCard(1, card);
            assertEquals(card, cliPlayableCard.showCards().get(1));
        }

        @Test
        public void testSetDrawableCard() {
            cliPlayableCard.setDrawableCard(4, card);
            assertEquals(card, cliPlayableCard.showCards().get(4));
        }

        @Test
        public void testUseCLICard() {
            cliPlayableCard.setStarterCard(card);
            cliPlayableCard.useCLICard(0);
            assertNull(cliPlayableCard.showCards().get(0));
        }
         @Test
         public void settingHandCardAtInvalidPositionDoesNotChangeCards() {
            cliPlayableCard.setHandCard(0, card);
            assertNull(cliPlayableCard.showCards().get(0));
        }
         @Test
         public void settingDrawableCardAtInvalidPositionDoesNotChangeCards() {
            cliPlayableCard.setDrawableCard(3, card);
            assertNull(cliPlayableCard.showCards().get(3));
         }
         @Test
         public void usingCardAtInvalidPositionDoesNotChangeCards() {
            cliPlayableCard.useCLICard(8);
            assertNull(cliPlayableCard.showCards().get(8));
         }
    }

