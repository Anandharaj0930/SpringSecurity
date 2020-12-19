package com.anandh.springsecurity.controller;

import com.anandh.springsecurity.repository.User;
import com.anandh.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeService {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public String getHome()
    {
       /* User user  = new User();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setPassword("bro");
        user.setRoles("ROLE_ADMIN,ROLE_USER");
        user.setUserName("mohan");
      user =  userRepository.save(user);
        System.out.println("user = " + user);*/
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
