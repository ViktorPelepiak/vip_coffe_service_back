package com.vip.coffee.service.services;

import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void activateUserById(Long id);

    List<User> findAllMasters();

    User findByUsername(String username) throws ElementNotFoundException;
}
