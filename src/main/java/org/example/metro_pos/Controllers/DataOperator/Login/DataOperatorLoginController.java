package org.example.metro_pos.Controllers.DataOperator.Login;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Database.DataOperator.DataOperatorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/dataOperator")
public class DataOperatorLoginController {

    @Autowired
    DataOperatorUserService userService;

    @RequestMapping("/login")
    public DataOperatorLoginResponse login(@RequestBody DataOperatorLoginRequest request) {
        System.out.println("Received login request: " + request);
        boolean isValid = userService.validateUser(request.getUsername(), request.getPassword(), request.getBranch_code());
        System.out.println("Sending login response: " + isValid);
        return new DataOperatorLoginResponse(isValid);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/LoginTypeScreen.html");
    }
}