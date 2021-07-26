package com.murilonerdx.msemail.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="TB_EMAIL")
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel implements Serializable {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long emailId;
  private String ownerRef;
  private String emailFrom;
  private String emailTo;
  private String subject;
  @Column(columnDefinition = "TEXT")
  private String text;
  private LocalDateTime sendDateEmail;
  private StatusEmail statusEmail;
}
