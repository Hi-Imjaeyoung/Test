import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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
        MahjongGame game = new MahjongGame(cards);
        assertThat(game.m3()).isEqualTo(true);
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
        MahjongGame game = new MahjongGame(cards);
        game.m2();
        assertThat(game.m3()).isEqualTo(false);
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
        MahjongGame game = new MahjongGame(cards);
        game.m2();
        assertThat(game.count).isEqualTo(6);
        game.m4(5);
        assertThat(game.count).isEqualTo(2);
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
        MahjongGame game = new MahjongGame(cards);
        game.m2();
        assertThat(game.count).isEqualTo(6);
        game.m4(4);
        assertThat(game.count).isEqualTo(3);
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
        MahjongGame game = new MahjongGame(cards);
        assertThat(game.m1()).isEqualTo(3);
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
        MahjongGame game2 = new MahjongGame(cards);
        game2.m2();
        assertThat(game2.count).isEqualTo(8);
        assertThat(game2.m1()).isEqualTo(4);
    }
}