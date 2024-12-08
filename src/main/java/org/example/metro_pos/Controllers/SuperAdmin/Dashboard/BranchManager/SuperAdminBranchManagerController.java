package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.BranchManager.SuperAdminBranchManagerRequest;
import org.example.metro_pos.Database.SuperAdmin.SuperAdminBranchManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
public class SuperAdminBranchManagerController {

    @Autowired
    private SuperAdminBranchManagerService allBranchService;

    @PostMapping("/createBranchManager")
    public ResponseEntity<String> createBranchManager(@RequestBody SuperAdminBranchManagerRequest request) {
        boolean isCreated = allBranchService.createBranchManager(request);
        if (isCreated) {
            return ResponseEntity.ok("Branch manager created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create branch manager");
        }
    }

    @DeleteMapping("/deleteBranch/{branchCode}")
    public ResponseEntity<String> deleteBranch(@PathVariable String branchCode) {
        boolean isDeleted = allBranchService.deleteBranch(branchCode);
        if (isDeleted) {
            return ResponseEntity.ok("Branch and branch manager deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete branch and branch manager");
        }
    }

    @DeleteMapping("/deleteBranchManager/{branchCode}")
    public ResponseEntity<String> deleteBranchManager(@PathVariable String branchCode) {
        boolean isDeleted = allBranchService.deleteBranchManager(branchCode);
        if (isDeleted) {
            return ResponseEntity.ok("Branch manager deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete branch manager");
        }
    }


}