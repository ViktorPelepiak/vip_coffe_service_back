package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.User;
import com.vip.coffee.service.repository.UserRepository;
import com.vip.coffee.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void activateUserById(Long userId) {
        userRepository.save(
                userRepository.getReferenceById(userId)
                .setEnabled(true)
        );
    }

    @Override
    public List<User> findAllMasters() {
        return userRepository.findAllMasters();
    }

    @Override
    public User findByUsername(String username) throws ElementNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new ElementNotFoundException(
                String.format("Can't find user with name \"%s\"", username)
        ));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username).orElse(null);
    }


}
