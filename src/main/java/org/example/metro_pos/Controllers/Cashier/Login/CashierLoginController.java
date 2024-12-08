package org.example.metro_pos.Controllers.Cashier.Login;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Database.Cashier.CashierUserService;
import org.example.metro_pos.Session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/cashier")
public class CashierLoginController {

    @Autowired
    private CashierUserService userService;

    @PostMapping("/login")
    public CashierLoginResponse login(@RequestBody CashierLoginRequest request, HttpSession session) {
        System.out.println("Received login request: " + request);
        boolean isValid = userService.validateUser(request.getUsername(), request.getPassword(), request.getBranchID());
        System.out.println("Sending login response: " + isValid);
        if(isValid){
            // Store User Session
            Session userSession = new Session(request.getUsername(), request.getPassword(), request.getBranchID(), "Cashier");
            session.setAttribute("userSession", userSession);
        }
        return new CashierLoginResponse(isValid);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/LoginTypeScreen.html");
    }
}
