import java.util.*;

public class User {
    //variable
    List<Card> myCards;
    int count, block;
    int[][] cardCounting = new int[3][10];
    //TODO Don't use hardcoding!
    boolean[] blocks = new boolean[14];

    //Constructor
    User(List<Card> list){
        this.myCards =list;
        this.count=8;
        this.block=0;
        for(int i=0;i<3;i++){
            Arrays.fill(cardCounting[i],4);
        }
        Arrays.fill(blocks,false);
        sortCards();
    }

    //Essential Function
    public void addCard(Card...cards){
       for(Card nowcard : cards){
           myCards.add(nowcard);
           updateCardCounting(nowcard);
       }
        sortCards();
    }
    public void abandonCard(int index){
        myCards.remove(index);
        sortCards();
    }
    public void printUserHand(){

    }
    public void updateCardCounting(Card card){
        int idCode = card.idCode;
        cardCounting[idCode/10][idCode%10] --;
    }
    public void sortCards(){
        Collections.sort(myCards);
    }
    public void calculateShentan(){

    }
    public void checkCompleteBody(){

    }
    public void checkPair(){

    }
    public void checkIncompleteBody(){

    }

}
