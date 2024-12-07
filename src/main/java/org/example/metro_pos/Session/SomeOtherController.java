package org.example.metro_pos.Session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class SomeOtherController {

    @GetMapping("/someEndpoint")
    public String someEndpoint(HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            // Use the session information
            return "User: " + userSession.getUsername() + ", Role: " + userSession.getRole();
        } else {
            return "No user session found";
        }
    }
}