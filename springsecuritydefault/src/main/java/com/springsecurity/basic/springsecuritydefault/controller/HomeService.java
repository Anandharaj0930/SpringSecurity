package com.springsecurity.basic.springsecuritydefault.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeService {


    @GetMapping
    public String getHome() {
        return "<h2>Muhtu Home Page</h2>";
    }

}
