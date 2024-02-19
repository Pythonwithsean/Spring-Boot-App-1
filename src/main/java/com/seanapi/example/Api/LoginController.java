package com.seanapi.example.Api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoginController {
    


    @GetMapping("/auth/login")
    public String getMethodName(@RequestParam String param) {
        System.out.println(param);
        return new String();
    }
    
}
