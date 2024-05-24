package Client.CLI;

import junit.framework.TestCase;

import java.util.ArrayList;

public class CLIMapperTest extends TestCase {

    public void testGetCard() {
        CLIMapper mapper = new CLIMapper();
        ArrayList<CLICard> cardList = new ArrayList<>(3);

        ArrayList<CLICard> cardid = new ArrayList<>(3);

        cardid.add(mapper.getCard("/CLI/CLI01front"));
        cardid.add(mapper.getCard("/CLI/CLI02front"));
        cardid.add(mapper.getCard("/CLI/CLI03front"));

        for (int i = 0; i < 3; i++) {
            cardList.add(mapper.getCard("/CLI/" + cardid.get(i)));
        }

        for(CLICard id: cardid) {
            assertEquals(id, mapper.getCard("/CLI/" + id));
        }

    }
}