package org.example.metro_pos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetroPosController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Uffan! I love you.";
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye, Uffan! I love you.";
    }
}
