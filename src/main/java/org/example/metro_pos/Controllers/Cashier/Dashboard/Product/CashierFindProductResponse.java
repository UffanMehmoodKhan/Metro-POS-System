package org.example.metro_pos.Controllers.Cashier.Dashboard.Product;

public class CashierFindProductResponse {

    private final boolean productFound;

    public CashierFindProductResponse(boolean success){
        this.productFound = success;
    }

    // Getter
    public boolean getLoginSuccess(){
        return this.productFound;
    }

    @Override
    public String toString() {
        return "CashierLoginResponse{" +
                "loginSuccess=" + productFound +
                '}';
    }
}