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
        }

        @Test
        public void testSetStarterCard() {
            cliPlayableCard.setStarterCard(card);
            assertNotNull(cliPlayableCard.showCards().get(0));
        }

        @Test
        public void testSetHandCard() {
            cliPlayableCard.setHandCard(1, card);
            assertNotNull(cliPlayableCard.showCards().get(1));
        }

        @Test
        public void testSetDrawableCard() {
            cliPlayableCard.setDrawableCard(4, card);
            assertNotNull(cliPlayableCard.showCards().get(4));
        }

        @Test
        public void testUseCLICard() {
            cliPlayableCard.setStarterCard(card);
            cliPlayableCard.useCLICard(0);
            assertNull(cliPlayableCard.showCards().get(0));
        }
    }

