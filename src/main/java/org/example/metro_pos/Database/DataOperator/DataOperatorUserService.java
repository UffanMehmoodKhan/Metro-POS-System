package org.example.metro_pos.Database.DataOperator;

import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

@Service
public class DataOperatorUserService {

    METRO_DB dataOp_DB;

    public boolean validateUser(String username, String password, String branch_code) {
        dataOp_DB = METRO_DB.getInstance();
        System.out.println("Validating user with username: " + username + ", password: " + password + ", branch_code: " + branch_code);
        boolean isValid = dataOp_DB.validateDataOperator(username, password, branch_code);
        System.out.println("Validation result: " + isValid);
        return isValid;
    }
}
