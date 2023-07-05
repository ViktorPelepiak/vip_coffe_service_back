package com.vip.coffee.service.controller;

import com.vip.coffee.service.enums.EmailType;
import com.vip.coffee.service.enums.UserRole;
import com.vip.coffee.service.model.User;
import com.vip.coffee.service.repository.UserRepository;
import com.vip.coffee.service.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class PingController {

    private final EmailService emailService;
    private final UserRepository userRepository;

    @Autowired
    public PingController(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("mail")
    public String mail() {
        emailService.sendEmail(
                EmailType.USER_VERIFICATION,
                "viktorpelepiak@gmail.com",
                new HashMap<>()
        );

        return "Email";
    }

    @GetMapping("admin")
    public String admin(){
        User user = userRepository.findByLogin("viktorpelepiak@gmail.com").get();
        user.getRoles().add(UserRole.ADMIN);
        user = userRepository.save(user);
        return user.getRoles().toString();
    }
}
