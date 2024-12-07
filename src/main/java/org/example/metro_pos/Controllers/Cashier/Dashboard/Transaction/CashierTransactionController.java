package org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction;

import org.example.metro_pos.Database.Cashier.CashierTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cashier")
public class CashierTransactionController {

    @Autowired
    private CashierTransactionService transactionService;

    @PostMapping("/transaction")
    public CashierTransactionResponse recordTransaction(@RequestBody CashierTransactionRequest request) {
        transactionService.recordTransaction(request);
        return new CashierTransactionResponse("Transaction Complete");
    }
}