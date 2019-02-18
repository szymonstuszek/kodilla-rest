package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SimpleMailServiceTestSuite {

    @InjectMocks
    private SimpleMailService simpleMailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendMail() {
        //Given
        Mail mail = new Mail("test@test.com", "test", "Test message", "");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());

        //When
        simpleMailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }

    @Test
    public void shouldSendMailWithCc() {
        //Given
        Mail mail = new Mail("test@test.com", "test", "Test message", "secondrecipient@test.com");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());

        //When
        simpleMailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }

    @Test
    public void shouldSendMailCcNull() {
        //Given
        Mail mail = new Mail("test@test.com", "test", "Test message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());

        //When
        simpleMailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }

//    @Test
//    public void checkSettingUpFields() {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        SimpleMailMessage mailMessage2 = new SimpleMailMessage();
//        SimpleMailMessage mailMessage3 = new SimpleMailMessage();
//        SimpleMailMessage blankMessage = new SimpleMailMessage();
//
//        String mailBody = "Sample text";
//        String emtpyBody = "";
//        String nullBody = null;
//
//        mailMessage.setText(mailBody);
//        mailMessage2.setText(emtpyBody);
//        mailMessage3.setText(nullBody);
//
//        System.out.println(mailMessage.getText());
//        System.out.println(mailMessage.getText().isEmpty());
//
//        System.out.println(mailMessage2.getText());
//        System.out.println(mailMessage2.getText().isEmpty());
//
//        System.out.println(blankMessage.getText());
//        System.out.println(blankMessage.getText() == null);
//
//        System.out.println(mailMessage3.getText());
//        System.out.println(mailMessage3.getText() == null);
//    }
}