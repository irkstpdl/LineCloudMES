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
}
