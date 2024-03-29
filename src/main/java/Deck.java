import java.util.*;

public class Deck {
    List<Card> cards;
    int[][] cardInformation = new int[4][10];
    public Deck(){
        cards = new ArrayList<>();
        for(int i=0;i<4;i++){
            addManCards();
            addSakCards();
            addTongCards();
            addDragon();
            addWind();
            Arrays.fill(cardInformation[i],4);
        }
        Collections.shuffle(cards);
    }
    //make cards
    private  void addManCards(){
        for(int i=1;i<10;i++){
            cards.add(new Card("MAN",i));
        }
    }
    private  void addTongCards(){
        for(int i=1;i<10;i++){
            cards.add(new Card("TONG",i));
        }
    }
    private  void addSakCards(){
        for(int i=1;i<10;i++){
            cards.add(new Card("SAK",i));
        }
    }
    private  void addWind(){
        cards.add(new Card("EAST"));
        cards.add(new Card("SOUTH"));
        cards.add(new Card("WEST"));
        cards.add(new Card("NORTH"));
    }
    private  void addDragon(){
        cards.add(new Card("WHITE"));
        cards.add(new Card("GREEN"));
        cards.add(new Card("RED"));
    }
    //essential function
    public Card draw(){
        Card nowCard = cards.get(0); // if cards structure type is que it is better easy?
        cards.remove(0);
        updateCardInformation(nowCard);
        return nowCard;
    }
    //TODO should check remain cards in deck
    private void updateCardInformation(Card card){
        int idCode = card.getIdCode();
        int type = idCode/10;
        int number = idCode-(type*10);
        cardInformation[type][number]--;
    }

    //additional function
    public int printSize(){
        return cards.size();
    }
}
