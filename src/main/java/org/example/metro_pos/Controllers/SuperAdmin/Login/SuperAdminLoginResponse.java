package org.example.metro_pos.Controllers.SuperAdmin.Login;

public class SuperAdminLoginResponse {

    private final boolean loginSuccess;

    public SuperAdminLoginResponse(boolean success){
        this.loginSuccess = success;
    }

    // Getter
    public boolean getLoginSuccess(){
        return this.loginSuccess;
    }

    @Override
    public String toString() {
        return "SuperAdminLoginResponse{" +
                "loginSuccess=" + loginSuccess +
                '}';
    }
}
