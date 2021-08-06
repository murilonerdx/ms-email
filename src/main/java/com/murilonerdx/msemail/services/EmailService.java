package com.murilonerdx.msemail.services;

import com.murilonerdx.msemail.enums.StatusEmail;
import com.murilonerdx.msemail.models.EmailModel;
import com.murilonerdx.msemail.repositories.EmailRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  final EmailRepository repository;

  @Autowired
  private JavaMailSender emailSender;

  public EmailService(EmailRepository repository) {
    this.repository = repository;
  }


  public EmailModel sendEmail(EmailModel emailModel) {
    emailModel.setSendDateEmail(LocalDateTime.now());
    try{
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(emailModel.getEmailFrom());
      message.setTo(emailModel.getEmailTo());
      message.setSubject(emailModel.getSubject());
      message.setText(emailModel.getText());
      emailSender.send(message);
      emailModel.setStatusEmail(StatusEmail.SENT);
    }catch(MailException e){
      emailModel.setStatusEmail(StatusEmail.ERROR);
    }finally {
      return repository.save(emailModel);
    }
  }
}
