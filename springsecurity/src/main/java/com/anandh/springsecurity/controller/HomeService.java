package com.anandh.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeService {


    @GetMapping
    public String getHome() {
        return "<h2>Muhtu Home Page</h2>";
    }

    @GetMapping("/bro")
    public String getBroHome() {
        return "<h2>Bro Home Page</h2>";
    }

    @GetMapping("/nanban")
    public String getNanabaHome() {
        return "<h2>Nanaban Home Page</h2>";
    }

    @GetMapping("natpu")
    public String getNatpuHome() {
        return "<h2>Natpu Home Page</h2>";
    }
}
