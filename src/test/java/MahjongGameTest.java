import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MahjongGameTest {
    @Test
    void check_My_Hand(){
        MahjongGame game = new MahjongGame();
        System.out.println(game.showMyHands());
    }
    @Test
    void check_Draw(){
        MahjongGame game = new MahjongGame();
        System.out.println(game.showMyHands()+game.drawCard());
    }
    @Test
    void Abandon_Card(){
        MahjongGame game = new MahjongGame();
        Card card = game.east_hand.get(12);
        System.out.println(game.showMyHands()+game.drawCard());
        game.abandonCard(card);
        System.out.println(game.showMyHands());
        assertThat(game.east_hand.contains(card)).isEqualTo(false);
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
        MahjongGame game = new MahjongGame(cards);
        game.m2();
        assertThat(game.block).isEqualTo(3);
        assertThat(game.count).isEqualTo(2);
        assertThat(game.isBlock[0]).isEqualTo(true);
        assertThat(game.isBlock[7]).isEqualTo(false);
    }
}