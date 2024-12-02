package org.example.metro_pos;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class MetroPosController {

    @RequestMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/splash.html");
    }

    @RequestMapping("/splash.html")
    public ResponseEntity<String> splash() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/splash.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }


    @RequestMapping("/LoginTypeScreen.html")
    public ResponseEntity<String> Login() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/LoginTypeScreen.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @RequestMapping("/CashierLogin.html")
    public ResponseEntity<String> cashierLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/CashierLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @RequestMapping("/SuperAdminLogin.html")
    public ResponseEntity<String> SuperAdminLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/SuperAdminLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }
    @RequestMapping("/BranchManagerLogin.html")
    public ResponseEntity<String> BranchManagerLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/BranchManagerLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }
    @RequestMapping("/DataEntryOperatorLogin.html")
    public ResponseEntity<String> DataOperatorLogin() throws IOException {
        ClassPathResource loginHTML = new ClassPathResource("static/src/pages/DataEntryOperatorLogin.html");
        String htmlContent = new String(Files.readAllBytes(loginHTML.getFile().toPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }


//    @RequestMapping("/goodbye")
//    public ResponseEntity<String> goodbye() throws IOException{
//        ClassPathResource goodbyeHTML = new ClassPathResource("static/src/pages/LoginTypeScreen.html");
//        String htmlContent = new String(Files.readAllBytes(goodbyeHTML.getFile().toPath()));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.TEXT_HTML);
//
//        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
//    }
}
