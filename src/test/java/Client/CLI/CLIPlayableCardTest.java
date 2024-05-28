package Client.CLI;

import Model.Cards.CardJSON;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CLIPlayableCardTest extends TestCase {
        private CLIPlayableCard cliPlayableCard;
        private CardJSON card;

        @BeforeEach
        public void setUp() {
            cliPlayableCard = new CLIPlayableCard();
            card= new CardJSON();
            card.setID("001");
            card.setASCII(Arrays.asList("Line1", "Line2"));

        }
         @Test
         public void testSetStarterCard() {
            cliPlayableCard.setStarterCard(card, "S01front.json");
            assertEquals(card, cliPlayableCard.getCardList().get(0));
            assertEquals("S01front.json", cliPlayableCard.getCardFileNames().get(0));
        }

        @Test
        public void testSetHandCard() {
            cliPlayableCard.setHandCard(1, card, "07front.json");
            assertEquals(card, cliPlayableCard.getCardList().get(1));
            assertEquals("07front.json", cliPlayableCard.getCardFileNames().get(1));
        }

        @Test
        public void testSetDrawableCard() {
            cliPlayableCard.setDrawableCard(4, card, "03front.json");
            assertEquals(card, cliPlayableCard.getCardList().get(4));
            assertEquals("03front.json", cliPlayableCard.getCardFileNames().get(4));
        }
        @Test
        public void testUseCLICard() {
            cliPlayableCard.setStarterCard(card, "S01front.json");
            cliPlayableCard.useCLICard(0);
            assertNull(cliPlayableCard.getCardList().get(0));
            assertNull(cliPlayableCard.getCardFileNames().get(0));
        }

        @Test
        public void settingHandCardAtInvalidPositionDoesNotChangeCards() {
            cliPlayableCard.setHandCard(0, card, "41front.json");
            assertNull(cliPlayableCard.getCardList().get(0));
        }
        @Test
        public void settingDrawableCardAtInvalidPositionDoesNotChangeCards() {
           cliPlayableCard.setDrawableCard(3, card, "G45front.json");
           assertNull(cliPlayableCard.getCardList().get(3));
        }

       @Test
       public void usingCardAtInvalidPositionDoesNotChangeCards() {
          cliPlayableCard.useCLICard(8);
          //since usìng card at invalid position should not affect any card
          for(int i=0; i< cliPlayableCard.getCardList().size(); i++){
           assertNull(cliPlayableCard.getCardList().get(i));
       }
          }
    }

