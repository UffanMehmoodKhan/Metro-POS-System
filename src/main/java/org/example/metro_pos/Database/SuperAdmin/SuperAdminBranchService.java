package org.example.metro_pos.Database.SuperAdmin;

import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch.SuperAdminBranchRequest;
import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch.SuperAdminBranchResponse;
import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.BranchManager.SuperAdminBranchManagerRequest;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminBranchService {

    METRO_DB admin_DB;

    public List<SuperAdminBranchResponse> loadAllBranches() {
        admin_DB = METRO_DB.getInstance();
        return admin_DB.findBranches();
    }

    public boolean createBranch(SuperAdminBranchRequest request) {
        admin_DB = METRO_DB.getInstance();
        return admin_DB.insertBranch(request);
    }

}