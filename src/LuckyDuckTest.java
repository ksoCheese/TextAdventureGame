import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LuckyDuckTest {

    @Test
    public void testUseItem( ) {
        var duck = new LuckyDuck();
        assertFalse(duck.isUsed());
        duck.useItem(null);
        assertTrue(duck.isUsed());
        duck.useItem(null);
        assertTrue(duck.isUsed());
    }
}
