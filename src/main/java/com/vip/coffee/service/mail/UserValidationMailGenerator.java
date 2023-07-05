package com.vip.coffee.service.mail;

import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.vip.coffee.service.enums.EmailType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("USER_VERIFICATION")
public class UserValidationMailGenerator implements MailGenerator {
    private static final String FROM_EMAIL = "viktorpelepiak@gmail.com";

    @Override
    public EmailType getEmailType() {
        return EmailType.USER_VERIFICATION;
    }

    @Override
    public EmailInstance generate(Map<String, Object> parameters) {
        return new EmailInstance()
                .setFrom(new Email(FROM_EMAIL))
                .setSubject("ViP CoffeeService account verification")
                .setContent(new Content("text/html", generateMailBody(parameters)));
    }

    private String generateMailBody(Map<String, Object> parameters){
        return new StringBuilder()
                .append("<html>")
                .append("<body>")
                .append(String.format("<h3>Вітаю, %s!</h3>", parameters.get(MailGenerator.USERNAME)))
                .append("<br>")
                .append("<p>Для завершення реєстрації перейдіть за ")
                .append(String.format("<a href=\"%s\">посиланням</a>", parameters.get(MailGenerator.VERIFICATION_TOKEN)))
                .append(".</p>")
                .append("</body>")
                .append("</html>")
                .toString();
    }
}
