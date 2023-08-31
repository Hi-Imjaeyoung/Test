import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    void Deck_Initialize_Test(){
        Deck deck = new Deck();
        assertEquals(true,deck.printSize()==136);
    }

}