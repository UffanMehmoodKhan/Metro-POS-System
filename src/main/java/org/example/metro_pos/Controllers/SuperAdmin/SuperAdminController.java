package org.example.metro_pos.Controllers.SuperAdmin;

import jakarta.servlet.http.HttpServletResponse;
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
public class SuperAdminController {

    @RequestMapping("/SuperAdminLogin.html")
    public ResponseEntity<String> SuperAdminLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/SuperAdminLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

}
