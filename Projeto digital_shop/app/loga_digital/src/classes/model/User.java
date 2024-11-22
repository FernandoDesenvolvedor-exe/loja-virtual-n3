package model;

public class User {    
    int userType;
    String userName;

    public boolean login(){
        return false;
    }

    public boolean logout(){
        return false;
    }
    
    public int getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
