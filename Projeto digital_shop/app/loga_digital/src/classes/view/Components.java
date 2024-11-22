package view;

public enum Components {
    BTNH(20),
    BTNW(60);    

    final int num;

    Components(int num){
        this.num = num;
    }
    
    public int getNum() {
        return num;
    }
}
