package ch.raiffeisen.openbank.scheduledpayment.persistency.model;

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
 * Party that manages the account on behalf of the account owner, that is manages the registration
 * and booking of entries on the account, calculates balances on the account and provides
 * information about the account. This is the servicer of the beneficiary account.
 * 
 * @author Timur Tokoev
 *
 */
@Entity
@Table(name = "SCHEDULED_PAYMENT_CREDITOR_AGENT")
public class CreditorAgent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   */
  @Column(name = "SCHEME_NAME")
  @Enumerated(EnumType.STRING)
  private ExternalFinancialInstitutionIdentificationCode schemeName;


  /**
   * Unique and unambiguous identification of the servicing institution.
   */
  @Column(name = "IDENTIFICATION", unique = true, length = 35)
  private String identification;


  @OneToOne
  @JoinColumn(name = "SCHEDULED_PAYMENT_ID")
  private ScheduledPayment scheduledPayment;


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
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


  public ScheduledPayment getScheduledPayment() {
    return scheduledPayment;
  }

  public void setScheduledPayment(ScheduledPayment scheduledPayment) {
    this.scheduledPayment = scheduledPayment;
  }
}
