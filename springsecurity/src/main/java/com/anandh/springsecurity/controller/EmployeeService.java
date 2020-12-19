package com.anandh.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeService {

    @GetMapping(path = "/address")
    public String getAddress() {
        return "employee address";
    }

    @GetMapping(path = "/user")
    public String getUser() {
        return "employee name is Ramki";
    }

    @GetMapping(path = "/admin")
    public String getAdmin() {
        return "employee Vijay";
    }
}
