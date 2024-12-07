package org.example.metro_pos.Controllers.DataOperator.Login;

public class DataOperatorLoginResponse {

    private final boolean loginSuccess;

    public DataOperatorLoginResponse(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean getLoginSuccess() {
        return loginSuccess;
    }

    @Override
    public String toString() {
        return "DataOperatorLoginResponse{" +
                "loginSuccess=" + loginSuccess +
                '}';
    }
}
