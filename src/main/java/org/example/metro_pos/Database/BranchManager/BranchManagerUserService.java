package org.example.metro_pos.Database.BranchManager;

import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

@Service
public class BranchManagerUserService {

    METRO_DB branchManager_DB;

    public boolean validateUser(String username, String password) {
        branchManager_DB = METRO_DB.getInstance();
        System.out.println("Validating user with username: " + username + ", password: " + password);
        boolean isValid = branchManager_DB.validateBranchManager(username, password);
        System.out.println("Validation result: " + isValid);
        return isValid;
    }
}
