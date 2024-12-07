package org.example.metro_pos.Database.SuperAdmin;

import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminUserService {

    METRO_DB admin_DB;

    public boolean validateUser(String username, String password, String securityCode) {
        admin_DB = METRO_DB.getInstance();
        System.out.println("Validating user with username: " + username + ", password: " + password + ", securityCode: " + securityCode);
        boolean isValid = admin_DB.validateAdmin(username, password, securityCode);
        System.out.println("Validation result: " + isValid);
        return isValid;

    }



}
