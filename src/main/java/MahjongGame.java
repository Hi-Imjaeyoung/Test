import java.util.*;
public class MahjongGame {
    Deck deck;
    List<Card> east_hand = new ArrayList<>();
    MahjongGame (){
        //Start Game
        deck = new Deck();
        settingHand(east_hand);
        //going Game
        //while(game is end){
        //    drawCard();
        //    abandonCard();
        // }

        //end Game
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
    public String drawCard(){
        Card draw_card = deck.draw();
        east_hand.add(draw_card);
        return "쯔모 "+draw_card.toString();
    }
    public void abandonCard(Card card){
        east_hand.remove(card);
        Collections.sort(east_hand);
    }
}
