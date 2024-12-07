package org.example.metro_pos.Controllers.Cashier.Login;

public class CashierLoginResponse {

    private final boolean loginSuccess;

    public CashierLoginResponse(boolean success){
        this.loginSuccess = success;
    }

    // Getter
    public boolean getLoginSuccess(){
        return this.loginSuccess;
    }

    @Override
    public String toString() {
        return "CashierLoginResponse{" +
                "loginSuccess=" + loginSuccess +
                '}';
    }
}