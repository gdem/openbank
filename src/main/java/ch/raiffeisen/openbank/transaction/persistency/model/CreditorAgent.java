package ch.raiffeisen.openbank.transaction.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;

/**
 * This entity represents the financial institution servicing an account for the creditor.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_CREDITOR_AGENT")
public class CreditorAgent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "TRANSACTION_ID")
  private Transaction transaction;

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   */
  @Column(name = "SCHEME_NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExternalFinancialInstitutionIdentificationCode schemeName;

  /**
   * Unique and unambiguous identification of a financial institution or a branch of a financial
   * institution..
   */
  @Column(name = "IDENTIFICATION", nullable = false, length = 35)
  private String identification;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

  public ExternalFinancialInstitutionIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalFinancialInstitutionIdentificationCode schemeName) {
    this.schemeName = schemeName;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }
}
