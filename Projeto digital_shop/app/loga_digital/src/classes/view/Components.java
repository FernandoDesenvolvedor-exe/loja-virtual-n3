package view;

public enum Components {
    BTNH(30),
    BTNW(180);    

    final int num;

    Components(int num){
        this.num = num;
    }
    
    public int getNum() {
        return num;
    }
}
