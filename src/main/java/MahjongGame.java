import java.util.*;
public class MahjongGame {
    Deck deck;
    User user;
    MahjongGame (){
        deck = new Deck();
        user = setStartGame();
    }
    //User can select cards
    MahjongGame(List<Card> cardlist){
        deck = new Deck();
        user = new User(cardlist);
    }
    public User setStartGame(){
        List<Card> startCards = new ArrayList<>();
        for(int i=0;i<14;i++){
            startCards.add(deck.draw());
        }
        User user = new User(startCards);
        return user;
    }
    public String showMyHands(){
        StringBuilder sb = new StringBuilder();
        for(Card now_card:user.myCards){
            sb.append(now_card.toString());
        }
        return sb.toString();
    }
    public void drawCard(User user){
        Card draw_card = deck.draw();
        user.addCard(draw_card);
    }
}
