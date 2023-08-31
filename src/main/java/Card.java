public class Card {
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