package org.example.metro_pos.Session;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class SomeOtherController {

    @GetMapping("/checkSession")
    public ResponseEntity<Session> checkSession(HttpSession session) {
        if (session != null && session.getAttribute("userSession") != null) {
            Session userSession = (Session) session.getAttribute("userSession");
            return ResponseEntity.ok(userSession);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @RequestMapping("/viewSession")
    public String viewSession(HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            return "User: " + userSession.getUsername() + " Password: " + userSession.getPassword() +
                    " BranchID: " + userSession.getBranchID() + " Role: " + userSession.getRole();
        } else {
            return "No user session found";
        }
    }
}