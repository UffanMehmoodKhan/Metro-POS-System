package org.example.metro_pos.Controllers.BranchManager.Login;

public class BranchManagerLoginRequest {

    private String username;
    private String password;

    public BranchManagerLoginRequest(){
    }

    public BranchManagerLoginRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Setters
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    // Getters

    public String getUsername() {
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}
