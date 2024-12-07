package org.example.metro_pos.Controllers.DataOperator.Login;

import org.example.metro_pos.Database.DataOperator.DataOperatorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
