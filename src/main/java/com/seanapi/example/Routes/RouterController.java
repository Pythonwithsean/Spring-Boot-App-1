package com.seanapi.example.Routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

}
