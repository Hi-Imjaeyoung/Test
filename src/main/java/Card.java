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
    public String toString(){
        if(number==-1)
            return type+" ";
        return String.valueOf(number)+type+" ";
    }
}