package com.murilonerdx.msemail.controllers;

import com.murilonerdx.msemail.dtos.EmailDTO;
import com.murilonerdx.msemail.models.EmailModel;
import com.murilonerdx.msemail.services.EmailService;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

  @Autowired
  EmailService emailService;

  @PostMapping("/sending-email")
  public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
    EmailModel emailModel = new EmailModel();
    //Conversão de DTO para Model.
    BeanUtils.copyProperties(emailDTO, emailModel);
    emailService.sendEmail(emailModel);
    return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

  }

}
