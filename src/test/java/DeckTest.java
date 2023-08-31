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
        if(card.number==-1){
            assertThat(card.type).containsAnyOf("EAST","SOUTH","NORTH","WEST","GREEN","RED","WHITE");
        }else{
            assertThat(card.type).containsAnyOf("MAN","Sak","Tong");
            assertThat(card.number).isGreaterThan(0)
                    .isLessThan(10);
        }
    }

}