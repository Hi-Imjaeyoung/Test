import java.util.*;
public class MahjongGame {
    Deck deck;
    List<Card> east_hand = new ArrayList<>();
    MahjongGame (){
        deck = new Deck();
        settingHand(east_hand);
    }
    private void settingHand(List<Card> hand){
        while (hand.size()!=13){
            hand.add(deck.draw());
        }
        Collections.sort(east_hand);
    }
    public String showMyHands(){
        StringBuilder sb = new StringBuilder();
        for(Card now_card:east_hand){
            sb.append(now_card.toString());
        }
        return sb.toString();
    }
}
