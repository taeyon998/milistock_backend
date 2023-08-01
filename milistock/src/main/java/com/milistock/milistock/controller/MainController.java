package com.milistock.milistock.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "https://3000-taeyon998-milistockfron-cnpzg1ltsid.ws-us102.gitpod.io/")
@RestController
@RequestMapping("/")
public class MainController {
    
    @GetMapping("")
    public String hello(){
        return "Connection Successful";
    }
}
