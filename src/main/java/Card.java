public class Card implements Comparable<Card> {
    String type;
    int number;
    int idCode;
    Card(String type, int number){
        this.type = type;
        this.number = number;
        calculateIdCode();
    }
    Card(String type){
        this.type = type;
        this.number =0;
        calculateIdCode();
        }
    public String toString(){
        if(number==0)
            return type+" ";
        return String.valueOf(number)+type+" ";
    }
    private void calculateIdCode(){
        if(type.equals("MAN")){
            idCode = number;
            return;
        }
        if(type.equals("Sak")){
            idCode = number+20;
            return;
        }
        if(type.equals("Tong")){
            idCode = number+10;
            return;
        }
        if(number==0){
            if(type.equals("EAST")){
                idCode=31;
            }
            if (type.equals("SOUTH")){
                idCode=32;
            }
            if(type.equals("WEST")){
                idCode=33;
            }
            if(type.equals("NORTH")){
                idCode=34;
            }
            if(type.equals("WHITE")){
                idCode=35;
            }
            if(type.equals("GREEN")){
                idCode=36;
            }
            if(type.equals("RED")){
                idCode=37;
            }
        }
    }
    @Override
    public int compareTo(Card oj) {
        return this.idCode-oj.idCode;
    }
}