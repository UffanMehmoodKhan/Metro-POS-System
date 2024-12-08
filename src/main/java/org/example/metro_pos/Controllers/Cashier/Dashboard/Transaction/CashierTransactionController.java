package org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction;

import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Database.Cashier.CashierTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cashier")
public class CashierTransactionController {

    @Autowired
    private CashierTransactionService transactionService;

    @PostMapping("/transaction")
    public CashierTransactionResponse recordTransaction(@RequestBody CashierTransactionRequest request, HttpSession session) {
        transactionService.recordTransaction(request, session);
        return new CashierTransactionResponse("Transaction Complete");
    }
}