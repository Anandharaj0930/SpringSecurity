package com.springsecurity.jpringsecurityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentService {
    @GetMapping("/depart")
    public String getDept() {
        return "<h2>Ramki dept</h2>";
    }

    @GetMapping("/store")
    public String getStore() {
        return "<h2>Mounish Store</h2>";
    }
}
