package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.UserLoginDto;
import com.vip.coffee.service.dto.UserRegistrationDto;
import com.vip.coffee.service.dto.UserResponseDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.exceptions.TokenExpirationException;
import com.vip.coffee.service.model.User;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@RestController
@RequestMapping("security")
@CrossOrigin
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/login")
    GenericResponse<UserResponseDto> login(@RequestBody UserLoginDto userLoginDto){
        User user = securityService.login(userLoginDto);

        if (user != null) {
            return GenericResponse.of(UserResponseDto.fromUser(user));
        }
        return GenericResponse.error("Вказано некоректні дані для входу");

    }

    @PostMapping("/logout")
    public GenericResponse logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return new GenericResponse().setSuccess(true);
    }

    @PostMapping("/registration")
    GenericResponse<User> registration (@RequestBody UserRegistrationDto userRegistrationDto){
        return GenericResponse.of(securityService.registration(userRegistrationDto));
    }

    @GetMapping("/token/verification")
    GenericResponse<Boolean> tokenVerification(@RequestParam String token) {
        try {
            return GenericResponse.of(securityService.verifyToken(token));
        } catch (TokenExpirationException tee) {
            return GenericResponse.of(false).
                    setAdditionalInformation(Map.of("REASON", "TOKEN_EXPIRED"));
        } catch (ElementNotFoundException enfe) {
            return GenericResponse.of(false).
                    setAdditionalInformation(Map.of("REASON", "TOKEN_NOT_FOUND"));
        }
    }

    @GetMapping("/token/update")
    GenericResponse<Boolean> updateToken(@RequestParam String token) {
        return GenericResponse.of(securityService.updateToken(token));
    }

}
