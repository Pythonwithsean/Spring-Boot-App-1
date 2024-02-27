package com.seanapi.example.Api;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LoginController {

    @PostMapping("/auth")
    public ResponseEntity<String> LoginAuth(@RequestBody String user) {

        return ResponseEntity.ok("Details Recieved");
    }

    @GetMapping("/greetings")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("Hello From Server");
    }

}