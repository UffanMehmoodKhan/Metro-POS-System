package org.example.metro_pos.Controllers.DataOperator.Login;

public class DataOperatorLoginRequest {

    private String username;
    private String password;
    private String securityCode;

    public DataOperatorLoginRequest() {
    }

    public DataOperatorLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "DataOperatorLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getBranch_code() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
