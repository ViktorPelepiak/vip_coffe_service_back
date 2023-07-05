package com.vip.coffee.service.services;

import com.vip.coffee.service.enums.EmailType;

import java.util.Map;

public interface EmailService {
    void sendEmail(EmailType type, String emailTo, Map<String, Object> parameters);
}
