package com.murilonerdx.msemail.services;


import com.murilonerdx.msemail.models.EmailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EmailService {
    EmailModel sendEmail(EmailModel emailModel);
    Page<EmailModel> findAll(Pageable pageable);
    Optional<EmailModel> findById(UUID emailId);
}
