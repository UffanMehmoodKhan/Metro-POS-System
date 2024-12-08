package org.example.metro_pos.Controllers.BranchManager;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class BranchManagerController {

    @RequestMapping("/BranchManagerLogin.html")
    public ResponseEntity<String> BranchManagerLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/BranchManagerLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @RequestMapping("/BranchManagerDashboard.html")
    public ResponseEntity<String> BranchManagerDashboard() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/BranchManagerDashboard.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @RequestMapping("/CashierDetails.html")
    public ResponseEntity<String> BranchManagerCashierView() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/CashierDetails.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @RequestMapping("/DataEntryOperatorDetails.html")
    public ResponseEntity<String> BranchManagerDataOperatorView() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/DataEntryOperatorDetails.html.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }
}
