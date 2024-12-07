package org.example.metro_pos.Database.Cashier;

import org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction.CashierTransactionRequest;

import org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction.ExcelService;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CashierTransactionService {

    @Autowired
    private ExcelService excelService;

    METRO_DB cashier_DB;

    public void recordTransaction(CashierTransactionRequest request) {
        cashier_DB = METRO_DB.getInstance();
        cashier_DB.updateProducts(request);

        // Write transactions to Excel
        try {
            excelService.writeTransactionsToExcel(request.getTransactionDetails());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}