package org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction;

public class CashierTransactionResponse {
    private String message;

    public CashierTransactionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}