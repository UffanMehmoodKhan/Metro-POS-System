package org.example.metro_pos.Controllers.SuperAdmin.Login;

public class SuperAdminLoginRequest {

    private String username;
    private String password;
    private String securityCode;

    public SuperAdminLoginRequest(){
    }

    public SuperAdminLoginRequest(String username, String password, String securityCode){
        this.username = username;
        this.password = password;
        this.securityCode = securityCode;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setSecurityCode(String securityCode){
        this.securityCode = securityCode;
    }

    // Getters
    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getSecurityCode(){
        return this.securityCode;
    }
}
