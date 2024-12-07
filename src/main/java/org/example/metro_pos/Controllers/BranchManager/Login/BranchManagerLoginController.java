package org.example.metro_pos.Controllers.BranchManager.Login;


import org.example.metro_pos.Database.BranchManager.BranchManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/branchManager")
public class BranchManagerLoginController {

    @Autowired
    BranchManagerUserService userService;

    @RequestMapping("/login")
    public BranchManagerLoginResponse login(@RequestBody BranchManagerLoginRequest request) {
        System.out.println("Received login request: " + request);
        boolean isValid = userService.validateUser(request.getUsername(), request.getPassword());
        System.out.println("Sending login response: " + isValid);
        return new BranchManagerLoginResponse(isValid);
    }
}
