package org.example.metro_pos.Database.Cashier;

import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

@Service
public class CashierUserService {

    METRO_DB cashier_DB;

    public boolean validateUser(String username, String password, String branchId) {
        cashier_DB = METRO_DB.getInstance();
        System.out.println("Validating user with username: " + username + ", password: " + password + ", branchId: " + branchId);
        boolean isValid = cashier_DB.validateCashier(username, password, branchId);
        System.out.println("Validation result: " + isValid);
        return isValid;
    }
}