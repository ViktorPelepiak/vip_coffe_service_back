package com.vip.coffee.service.services;

import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.exceptions.TokenExpirationException;
import com.vip.coffee.service.model.User;
import com.vip.coffee.service.model.VerificationToken;
import org.springframework.stereotype.Service;

@Service
public interface VerificationTokenService {

    VerificationToken generate(User user);

    boolean verify(String token) throws TokenExpirationException, ElementNotFoundException;

    VerificationToken getByToken(String token);

    boolean remove(VerificationToken token);
}
