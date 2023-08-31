import java.util.*;
public class MahjongGame {
    Deck deck;
    List<Card> east_hand,west_hand,north_hand,south_hand;
    MahjongGame (){
        deck = new Deck();
        settingHand(east_hand);
    }
    public void settingHand(List<Card> hand){
        while (hand.size()!=13){
            hand.add(deck.draw());
        }
    }
    public String showMyHands(){

    }
}
