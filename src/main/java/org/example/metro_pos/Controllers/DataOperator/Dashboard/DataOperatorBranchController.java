package org.example.metro_pos.Controllers.DataOperator.Dashboard;

import org.example.metro_pos.Controllers.DataOperator.Dashboard.DataOperatorBranchResponse;
import org.example.metro_pos.Database.DataOperator.DataOperatorBranchService;
import org.example.metro_pos.Session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/dataOperator")
public class DataOperatorBranchController {

    @Autowired
    private DataOperatorBranchService branchService;

    @GetMapping("/branchDetails")
    public ResponseEntity<DataOperatorBranchResponse> getBranchDetails(HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            DataOperatorBranchResponse branchDetails = branchService.getBranchDetails(userSession.getBranchID());
            return ResponseEntity.ok(branchDetails);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}