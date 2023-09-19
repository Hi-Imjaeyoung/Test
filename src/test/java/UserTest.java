import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void addCard_Test() {
        Deck deck = new Deck();
        List<Card> cards = new ArrayList<>();
        User user = new User(cards);
        user.addCard(new Card("EAST"));
        assertThat(user.myCards.size()).isEqualTo(1);
        Card[] arry = new Card[4];
        for(int i=0;i<4;i++){
            arry[i] = deck.draw();
        }
        user.addCard(arry);
        assertThat(Arrays.toString(user.myCards.toArray())).contains("EAST");
        assertThat(user.myCards.size()).isEqualTo(5);
    }
}