package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.UserLoginDto;
import com.vip.coffee.service.dto.UserRegistrationDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.exceptions.TokenExpirationException;
import com.vip.coffee.service.model.User;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    User login(UserLoginDto userLoginDto);

    User registration(UserRegistrationDto userRegistrationDto);

    boolean verifyToken(String token) throws TokenExpirationException, ElementNotFoundException;

    boolean updateToken(String token);
}
