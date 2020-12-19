package com.anandh.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserService {

    @GetMapping(path = "/address")
    public String getAddress() {
        return "<h3>User Address Chennai 28</h3>";
    }

    @GetMapping(path = "/name")
    public String getUser() {
        return "<h3>Im User Mounish</h3>";
    }

    @GetMapping(path = "/admin")
    public String getAdmin() {
        return "<h3>Im Admin Arun<h3>";
    }
}
