package com.murilonerdx.msemail.dtos;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
  @NotBlank
  private String ownerRef;
  @NotBlank
  @Email
  private String emailFrom;
  @NotBlank
  @Email
  private String emailTo;
  @NotBlank
  private String subject;
  @Column(columnDefinition = "TEXT")
  @NotBlank
  private String text;
}
