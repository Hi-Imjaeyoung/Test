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
    //User can select cards
    MahjongGame(List<Card> cardlist){
        deck = new Deck();
        east_hand = cardlist;
        Collections.sort(east_hand);
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
    public int m1(){
        int count = 8;
        int block = 0;
        boolean[] isBlock = new boolean[14];
        Arrays.fill(isBlock,false);
        m2(count,block,isBlock);
        //if(m3){
            //while (block<=5)
            //count-m4();
        //}else{
            //while (block<5)
           // count-m4();
        //}
        return count;
    }
    public void m2(int count ,int block,boolean[] isBlock){
        int sizeOfHand = east_hand.size();
        for(int i=0; i<sizeOfHand-2; i++){
            if(isBlock[i]){
                continue;
            }
            if(east_hand.get(i).idCode==east_hand.get(i+1).idCode){
                if(east_hand.get(i+1).idCode== east_hand.get(i+2).idCode){
                    block++;
                    count -=2;
                    isBlock[i] = isBlock[i+1] = isBlock[i+2] = true;
                    continue;
                }
            }
            if(east_hand.get(i).idCode+1 ==east_hand.get(i+1).idCode){
                if(east_hand.get(i+1).idCode+1 == east_hand.get(i+2).idCode){
                    block++;
                    count-=2;
                    isBlock[i] = isBlock[i+1] = isBlock[i+2] = true;
                }
            }
        }
    }
}
