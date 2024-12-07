package org.example.metro_pos.Controllers.DataOperator;

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
public class DataOperatorController {

    @RequestMapping("/DataEntryOperatorLogin.html")
    public ResponseEntity<String> DataOperatorLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/DataEntryOperatorLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @RequestMapping("/DataEntryOperatorDashboard.html")
    public ResponseEntity<String> DataOperatorDashboard() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/DataEntryOperatorDashboard.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }
}
