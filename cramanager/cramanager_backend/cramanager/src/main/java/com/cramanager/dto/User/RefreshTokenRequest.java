package com.cramanager.dto.User;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
