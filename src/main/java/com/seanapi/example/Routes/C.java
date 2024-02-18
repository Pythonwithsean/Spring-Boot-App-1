package com.seanapi.example.Routes;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class C {

    @GetMapping("/home")
    public String Home(){
        return "Home";
    }

  

    
}
