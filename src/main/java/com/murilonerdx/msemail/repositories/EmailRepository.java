package com.murilonerdx.msemail.repositories;

import com.murilonerdx.msemail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
