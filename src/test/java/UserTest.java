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
    @Test
    void DrawCard_Test(){

    }
    @Test
    void AbandonCard_Test(){

    }
    @Test
    void CompleteBody_Function(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",4));
        cards.add(new Card("MAN",5));
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",9));
        cards.add(new Card("EAST"));
        cards.add(new Card("EAST"));
        cards.add(new Card("EAST"));
        cards.add(new Card("SOUTH"));
        cards.add(new Card("EAST"));
        User user = new User(cards);
        user.checkCompleteBody();
        assertThat(user.block).isEqualTo(3);
        assertThat(user.count).isEqualTo(2);
        assertThat(user.isBlock[0]).isEqualTo(true);
        assertThat(user.isBlock[7]).isEqualTo(false);
    }
    @Test
    void Check_Pair_Case1_Include(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",4));
        cards.add(new Card("MAN",5));
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",9));
        cards.add(new Card("EAST"));
        cards.add(new Card("EAST"));
        cards.add(new Card("EAST"));
        cards.add(new Card("SOUTH"));
        cards.add(new Card("EAST"));
        User user = new User(cards);
        assertThat(user.checkPair()).isEqualTo(true);
    }
    @Test
    void Check_Pair_Case2_Exclude(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",2));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",5));
        cards.add(new Card("MAN",6));
        cards.add(new Card("MAN",7));
        cards.add(new Card("MAN",8));
        cards.add(new Card("EAST"));
        cards.add(new Card("NORTH"));
        cards.add(new Card("WEST"));
        cards.add(new Card("SOUTH"));
        cards.add(new Card("RED"));
        User user = new User(cards);
        user.checkCompleteBody();
        assertThat(user.checkPair()).isEqualTo(false);
    }
    @Test
    void Check_IncompleteBody_Case1_MaxBlocks_Is_5(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",2));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",5));
        cards.add(new Card("MAN",7));
        cards.add(new Card("MAN",8));
        cards.add(new Card("SAK",6));
        cards.add(new Card("SAK",6));
        cards.add(new Card("EAST"));
        cards.add(new Card("EAST"));
        cards.add(new Card("NORTH"));
        cards.add(new Card("WEST"));
        cards.add(new Card("SOUTH"));
        User user = new User(cards);
        user.checkCompleteBody();
        assertThat(user.count).isEqualTo(6);
        user.checkIncompleteBody(5);
        assertThat(user.count).isEqualTo(2);
    }
    @Test
    void Check_IncompleteBody_Case2_MaxBlocks_Is_4(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",2));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",5));
        cards.add(new Card("MAN",7));
        cards.add(new Card("MAN",8));
        cards.add(new Card("SAK",6));
        cards.add(new Card("SAK",7));
        cards.add(new Card("SAK",1));
        cards.add(new Card("SAK",2));
        cards.add(new Card("TONG",1));
        cards.add(new Card("TONG",2));
        User user = new User(cards);
        user.checkCompleteBody();
        assertThat(user.count).isEqualTo(6);
        user.checkIncompleteBody(4);
        assertThat(user.count).isEqualTo(3);
    }
    @Test
    void Check_Calculate_Shanten(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",2));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",5));
        cards.add(new Card("MAN",7));
        cards.add(new Card("MAN",8));
        cards.add(new Card("SAK",6));
        cards.add(new Card("SAK",7));
        cards.add(new Card("SAK",1));
        cards.add(new Card("SAK",2));
        cards.add(new Card("TONG",1));
        cards.add(new Card("TONG",2));
        User user = new User(cards);
        user.calculateShentan();
        assertThat(user.count).isEqualTo(3);
        cards = new ArrayList<>();
        cards.add(new Card("MAN",1));
        cards.add(new Card("MAN",3));
        cards.add(new Card("MAN",4));
        cards.add(new Card("TONG",1));
        cards.add(new Card("TONG",6));
        cards.add(new Card("TONG",7));
        cards.add(new Card("TONG",7));
        cards.add(new Card("TONG",9));
        cards.add(new Card("SAK",9));
        cards.add(new Card("EAST"));
        cards.add(new Card("SOUTH"));
        cards.add(new Card("WEST"));
        cards.add(new Card("WEST"));
        cards.add(new Card("GREEN"));
        user = new User(cards);
        user.checkCompleteBody();
        assertThat(user.count).isEqualTo(8);
        user.calculateShentan();
        assertThat(user.count).isEqualTo(4);
    }
}