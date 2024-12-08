package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.BranchManager.SuperAdminBranchManagerRequest;
import org.example.metro_pos.Database.SuperAdmin.SuperAdminBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class SuperAdminBranchController {

    @Autowired
    private SuperAdminBranchService allBranchService;

    @PostMapping("/getAllBranches")
    public List<SuperAdminBranchResponse> loadAllBranches(@RequestBody SuperAdminBranchRequest request) {
        return allBranchService.loadAllBranches();
    }

    @PostMapping("/createBranch")
    public ResponseEntity<String> createBranch(@RequestBody SuperAdminBranchRequest request) {
        boolean isCreated = allBranchService.createBranch(request);
        System.out.println("Branch created: " + request.toString());
        if (isCreated) {
            return ResponseEntity.ok("Branch created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create branch");
        }
    }

}