package org.example.metro_pos.Controllers.BranchManager.Login;

public class BranchManagerLoginResponse {

    private final boolean loginSuccess;

    public BranchManagerLoginResponse(boolean success){
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
