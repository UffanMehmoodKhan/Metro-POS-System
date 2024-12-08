package org.example.metro_pos.Controllers.BranchManager.Login;

public class BranchManagerLoginRequest {

    private String username;
    private String password;
    private String branchID;

    public BranchManagerLoginRequest(){
    }
    public BranchManagerLoginRequest(String username, String password, String branchID){
        this.username = username;
        this.password = password;
        this.branchID = branchID;
    }

    // Setters
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setBranchID(String branchID) { this.branchID = branchID; }

    // Getters

    public String getUsername() {
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getBranchID() { return branchID; }

}
