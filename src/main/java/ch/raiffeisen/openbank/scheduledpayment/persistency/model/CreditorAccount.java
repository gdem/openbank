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

import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;

/**
 * Provides the details to identify the beneficiary account.
 * 
 * @author Timur Tokoev
 */
@Entity
@Table(name = "SCHEDULED_PAYMENT_CREDITOR_ACCOUNT")
public class CreditorAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   */
  @Column(name = "SCHEME_NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExternalAccountIdentificationCode schemeName;

  /**
   * Identification assigned by an institution to identify an account. This identification is known
   * by the account owner.
   */
  @Column(name = "IDENTIFICATION", nullable = false, length = 34)
  private String identification;

  /**
   * Name of the account, as assigned by the account servicing institution, in agreement with the
   * account owner in order to provide an additional means of identification of the account.
   */
  @Column(name = "NAME", length = 70)
  private String name;


  /**
   * This is secondary identification of the account, as assigned by the account servicing
   * institution. This can be used by building societies to additionally identify accounts with a
   * roll number (in addition to a sort code and account number combination).
   */
  @Column(name = "SECONDARY_IDENTIFICATION", length = 34)
  private String secondaryIdentification;


  @OneToOne
  @JoinColumn(name = "SCHEDULED_PAYMENT_ID")
  private ScheduledPayment scheduledPayment;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ExternalAccountIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalAccountIdentificationCode schemeName) {
    this.schemeName = schemeName;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSecondaryIdentification() {
    return secondaryIdentification;
  }

  public void setSecondaryIdentification(String secondaryIdentification) {
    this.secondaryIdentification = secondaryIdentification;
  }

  public ScheduledPayment getScheduledPayment() {
    return scheduledPayment;
  }

  public void setScheduledPayment(ScheduledPayment scheduledPayment) {
    this.scheduledPayment = scheduledPayment;
  }
}
