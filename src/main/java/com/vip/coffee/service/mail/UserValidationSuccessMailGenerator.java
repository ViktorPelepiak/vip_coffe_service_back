package com.vip.coffee.service.mail;

import com.vip.coffee.service.enums.EmailType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("USER_VERIFICATION_SUCCESS")
public class UserValidationSuccessMailGenerator implements MailGenerator {
    @Override
    public EmailType getEmailType() {
        return EmailType.USER_VERIFICATION_SUCCESS;
    }

    @Override
    public EmailInstance generate(Map<String, Object> parameters) {
        return null;
    }
}
