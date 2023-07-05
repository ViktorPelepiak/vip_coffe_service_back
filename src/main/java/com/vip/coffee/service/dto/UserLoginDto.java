package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.User;

public class UserLoginDto {
    private String login;
    private String password;

    public UserLoginDto() {}

    public UserLoginDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public UserLoginDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
