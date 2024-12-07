package org.example.metro_pos.Controllers.Cashier.Login;

public class CashierLoginRequest {

    private String username;
    private String password;
    private String branchID;

    public CashierLoginRequest() {
    }

    public CashierLoginRequest(String username, String password, String branchID) {
        this.username = username;
        this.password = password;
        this.branchID = branchID;
    }

    // Setters
    public void setUsername(String username){
        this.username = username;
        setPassword(username);
    }

    public void setPassword(String password){
        this.password = password;

    }

    public void setBranchID(String branchID){
        this.branchID = branchID;
    }

    // Getters
    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getBranchID(){
        return this.branchID;
    }

    @Override
    public String toString() {
        return "CashierLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", branchID='" + branchID + '\'' +
                '}';
    }
}