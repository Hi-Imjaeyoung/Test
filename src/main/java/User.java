import java.util.*;

public class User {
    //variable
    List<Card> myCards;
    int count, block;
    int[][] cardCounting = new int[3][10];
    //TODO Don't use hardcoding!
    boolean[] isBlock = new boolean[14];

    //Constructor
    User(List<Card> list){
        this.myCards =list;
        this.count=8;
        this.block=0;
        for(int i=0;i<3;i++){
            Arrays.fill(cardCounting[i],4);
        }
        Arrays.fill(isBlock,false);
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
       checkCompleteBody();
        if(checkPair()){
            checkIncompleteBody(5);
        }else {
            checkIncompleteBody(4);
        }
    }
    public void checkCompleteBody(){
        int sizeOfHand = myCards.size();
        for(int i=0; i<sizeOfHand-2; i++){
            if(isBlock[i]){
                continue;
            }
            if(myCards.get(i).idCode==myCards.get(i+1).idCode){
                if(myCards.get(i+1).idCode== myCards.get(i+2).idCode){
                    block++;
                    count -=2;
                    isBlock[i] = isBlock[i+1] = isBlock[i+2] = true;
                    continue;
                }
            }
            if(myCards.get(i).idCode>30){
                continue;
            }
            if(myCards.get(i).idCode+1 ==myCards.get(i+1).idCode){
                if(myCards.get(i+1).idCode+1 == myCards.get(i+2).idCode){
                    block++;
                    count-=2;
                    isBlock[i] = isBlock[i+1] = isBlock[i+2] = true;
                }
            }
        }
    }
    public boolean checkPair(){
        for(int i=0;i<myCards.size()-1;i++){
            if(isBlock[i]||isBlock[i+1]){
                continue;
            }
            if(myCards.get(i).idCode == myCards.get(i+1).idCode){
                return true;
            }
        }
        return false;
    }
    public void checkIncompleteBody(int maximumBlock){
        for(int i=0;i<myCards.size()-1;i++){
            if(block>=maximumBlock){
                break;
            }
            if(isBlock[i] || isBlock[i+1]){
                continue;
            }
            if(myCards.get(i).idCode==myCards.get(i+1).idCode){
                block++;
                count--;
                isBlock[i]=isBlock[i+1]=true;
            }
            if(myCards.get(i).idCode>30){
                break;
            }
            if(myCards.get(i).idCode+1==myCards.get(i+1).idCode||
                    myCards.get(i).idCode+2==myCards.get(i+1).idCode
            ){
                block++;
                count--;
                isBlock[i]=isBlock[i+1]=true;
            }
        }
    }
}
