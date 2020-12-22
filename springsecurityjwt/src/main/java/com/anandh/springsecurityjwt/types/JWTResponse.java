package com.anandh.springsecurityjwt.types;

import java.io.Serializable;

public class JWTResponse implements Serializable {

    private String jwtToken;

    public JWTResponse() {
    }

    public JWTResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }


}
