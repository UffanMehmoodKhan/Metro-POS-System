package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

import org.example.metro_pos.Database.Cashier.CashierUserService;
import org.example.metro_pos.Database.SuperAdmin.SuperAdminBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/")
public class SuperAdminBranchController {

    @Autowired
    private SuperAdminBranchService branchService;


//    @PostMapping("/branch")
//    public SuperAdminBranchResponse createBranch(@RequestBody SuperAdminBranchRequest request) {
//        System.out.println("Received branch request: " + request);
//        boolean isValid = branchService.addBranch();
//        System.out.println("Sending branch response: " + isValid);
//        return new SuperAdminBranchResponse(isValid);
//    }
}
