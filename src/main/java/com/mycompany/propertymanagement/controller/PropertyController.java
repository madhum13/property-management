package com.mycompany.propertymanagement.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    //RESTFull API is just mapping of a url to a java class function
    //http://localhost:8080/api/v1/properties/hello

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}
