package org.example.metro_pos.Controllers.SuperAdmin.Login;

import org.example.metro_pos.Database.SuperAdmin.SuperAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class SuperAdminLoginController {

    @Autowired
    private SuperAdminUserService userService;

    @PostMapping("/login")
    public SuperAdminLoginResponse login(@RequestBody SuperAdminLoginRequest request) {
        System.out.println("Received login request: " + request);
        boolean isValid = userService.validateUser(request.getUsername(), request.getPassword(), request.getSecurityCode());
        System.out.println("Sending login response: " + isValid);
        return new SuperAdminLoginResponse(isValid);
    }
}
