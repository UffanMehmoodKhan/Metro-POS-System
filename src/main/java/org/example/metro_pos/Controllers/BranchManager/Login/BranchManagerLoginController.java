package org.example.metro_pos.Controllers.BranchManager.Login;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Database.BranchManager.BranchManagerUserService;
import org.example.metro_pos.Session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/branchManager")
public class BranchManagerLoginController {

    @Autowired
    BranchManagerUserService userService;

    @RequestMapping("/login")
    public BranchManagerLoginResponse login(@RequestBody BranchManagerLoginRequest request, HttpSession session) {
        System.out.println("Received login request: " + request);
        boolean isValid = userService.validateUser(request.getUsername(), request.getPassword(), request.getBranchID());
        if(isValid){
            // Store User Session
            Session userSession = new Session(request.getUsername(), request.getPassword(), request.getBranchID(), "Branch Manager");
            session.setAttribute("userSession", userSession);
        }
        System.out.println("Sending login response: " + isValid);
        return new BranchManagerLoginResponse(isValid);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/LoginTypeScreen.html");
    }
}
