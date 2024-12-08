package org.example.metro_pos.Controllers.SuperAdmin.Login;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Database.SuperAdmin.SuperAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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

    @PostMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/LoginTypeScreen.html");
    }
}
