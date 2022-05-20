package com.lc.mail.internal;

import com.google.common.base.Preconditions;
import com.lc.mail.api.InvalidMailAddressException;
import com.lc.mail.api.MailService;
import com.lc.mail.api.MailConfigurationException;

import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    protected JavaMailSender mailSender;

    @Value("${mail.address}")
    private String defaultSender;

    @Override
    public void sendEmail(final String recipient, final String subject, final String body) {
        sendHtmlTextEmail(getDefaultSender(), recipient, subject, body);
    }

    protected String getDefaultSender() {
        if (isValidEmail(defaultSender)) {
            return defaultSender;
        }
        throw new MailConfigurationException('\'' + defaultSender + "' 不是有效的电子邮件地址，请检查！");
    }

    protected void sendHtmlTextEmail(final String sender, final String recipient, final String subject, final String body) {
        validateEmail(sender);
        validateEmail(recipient);
        Preconditions.checkArgument(StringUtils.isNotBlank(subject), "电子邮件主题不应为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(body), "电子邮件正文不应为空");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(recipient);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body, true);
        } catch (MessagingException e) {
            throw new MailPreparationException(e);
        }

        mailSender.send(mimeMessage);
    }

    private void validateEmail(final String email) {
        if (!isValidEmail(email)) {
            throw new InvalidMailAddressException('\'' + email + "' 不是有效的电子邮件地址");
        }
    }

    public static boolean isValidEmail(final String email) {
        return StringUtils.isNotBlank(email) && EmailValidator.getInstance().isValid(email);
    }

}