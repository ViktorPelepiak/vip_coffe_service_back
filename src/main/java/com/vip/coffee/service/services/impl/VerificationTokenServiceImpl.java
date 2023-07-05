package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.exceptions.TokenExpirationException;
import com.vip.coffee.service.model.User;
import com.vip.coffee.service.model.VerificationToken;
import com.vip.coffee.service.repository.VerificationTokenRepository;
import com.vip.coffee.service.services.UserService;
import com.vip.coffee.service.services.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;
    private final UserService userService;

    @Autowired
    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository, UserService userService) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.userService = userService;
    }

    @Override
    public VerificationToken generate(User user) {
        return verificationTokenRepository.save(
                new VerificationToken()
                        .setUser(user)
                        .setToken(UUID.randomUUID().toString())
                        .setExpirationDate(VerificationToken.calculateExpiryDate())
        );
    }

    @Override
    public boolean verify(String token) throws TokenExpirationException, ElementNotFoundException {
        VerificationToken verificationToken = verificationTokenRepository.getFirstByToken(token);
        if (verificationToken == null) {
            throw new ElementNotFoundException(String.format("Token \"%s\" not found", token));
        }
        if (verificationToken.getExpirationDate().after(new Date())) {
            userService.activateUserById(verificationToken.getUser().getId());
            verificationTokenRepository.delete(verificationToken);
            return true;
        }
        throw new TokenExpirationException();
    }

    @Override
    public VerificationToken getByToken(String token) {
        return verificationTokenRepository.getFirstByToken(token);
    }

    @Override
    public boolean remove(VerificationToken token) {
        verificationTokenRepository.delete(token);

        return true;
    }
}
