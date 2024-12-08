package org.example.metro_pos.Database.SuperAdmin;

import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.BranchManager.SuperAdminBranchManagerRequest;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

@Service
public class SuperAdminBranchManagerService {

    METRO_DB admin_DB;

    public boolean createBranchManager(SuperAdminBranchManagerRequest request) {
        admin_DB = METRO_DB.getInstance();
        return admin_DB.insertBranchManager(request);
    }

    public boolean deleteBranch(String branchCode) {
        admin_DB = METRO_DB.getInstance();
        return admin_DB.deleteBranch(branchCode);
    }


    public boolean deleteBranchManager(String branchCode) {
        admin_DB = METRO_DB.getInstance();
        return admin_DB.deleteBranchManager(branchCode);
    }
}
