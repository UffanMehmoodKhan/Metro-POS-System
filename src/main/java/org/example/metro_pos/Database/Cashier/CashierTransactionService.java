package org.example.metro_pos.Database.Cashier;

import org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction.CashierTransactionRequest;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class CashierTransactionService {

    METRO_DB cashier_DB;

    public void recordTransaction(CashierTransactionRequest request) {
        cashier_DB = METRO_DB.getInstance();
        cashier_DB.updateProducts(request);
    }
}