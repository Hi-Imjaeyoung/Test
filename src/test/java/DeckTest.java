import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {
    @Test
    void Deck_Initialize_Test(){
        Deck deck = new Deck();
        assertEquals(true,deck.printSize()==136);
    }
    @Test
    void Draw_Test(){
        //given
        Deck deck = new Deck();
        //when
        Card card = deck.draw();
        //then
        if(card.number==0){
            assertThat(card.type).containsAnyOf("EAST","SOUTH","NORTH","WEST","GREEN","RED","WHITE");
        }else{
            assertThat(card.type).containsAnyOf("MAN","SAK","TONG");
            assertThat(card.number).isGreaterThan(0)
                    .isLessThan(10);
        }
    }
    @Test
    void Update_Card_Information(){
        Deck deck = new Deck();
        Card card = deck.draw();
        int type = card.idCode/10;
        int number = card.idCode - (10*type);
        assertThat(deck.cardInformation[type][number]).isEqualTo(3);
    }

}