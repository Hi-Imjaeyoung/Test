import java.util.*;

public class Deck {
    class Card{
        String type;
        int number;
        Card(String type, int number){
            this.type = type;
            this.number = number;
        }
        Card(String type){
            this.type = type;
            this.number =-1;
        }
    }
    static List<Card> cards = new ArrayList<>();
    public Deck(){
        for(int i=0;i<4;i++){
            addManCards();
            addSakCards();
            addTongCards();
            addDragon();
            addWind();
        }
        Collections.shuffle(cards);

    }
    private  void addManCards(){
        for(int i=1;i<10;i++){
            cards.add(new Card("MAN",i));
        }
    }
    private  void addTongCards(){
        for(int i=1;i<10;i++){
            cards.add(new Card("Tong",i));
        }
    }
    private  void addSakCards(){
        for(int i=1;i<10;i++){
            cards.add(new Card("Sak",i));
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
    public int printSize(){
        return cards.size();
    }
}
