package com.anandh.springsecurityjwt.controller;

import com.anandh.springsecurityjwt.config.CustomUserDetailService;
import com.anandh.springsecurityjwt.types.JWTRequest;
import com.anandh.springsecurityjwt.types.JWTResponse;
import com.anandh.springsecurityjwt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String getHome() {
        return "<h3>I'm in Home</h3>";
    }

    @PostMapping(path = "/authenticate", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public JWTResponse authenticate(@RequestBody JWTRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        UserDetails userDetails = customUserDetailService.loadUserByUsername(request.getUserName());
        String token = jwtUtil.generateToken(userDetails);
        return new JWTResponse(token);
    }

    @GetMapping(path = "/bro")
    public String getBroHome() {
        return "Bro Home";
    }
}
