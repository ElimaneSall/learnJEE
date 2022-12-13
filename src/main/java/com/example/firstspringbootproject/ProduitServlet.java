package com.example.firstspringbootproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitServlet {
   // @GetMapping("/")
    public String HomePage(){
        return "Hello Sall";
    }
}
