package ch.raiffeisen.openbank.directdebits.repository.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ch.raiffeisen.openbank.common.repository.model.Amount;


/**
 * This entity represents the account to or from which a cash entry is made.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "DIRECT_DEBIT")
public class DirectDebit {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the direct debit resource. This identifier
   * has no meaning to the account owner.
   */
  @Column(name = "DIRECT_DEBIT_ID", length = 40, nullable = true)
  private String directDebitId;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", length = 40, nullable = false)
  private String accountId;

  /**
   * Direct Debit reference. For AUDDIS service users provide Core Reference. For non AUDDIS service
   * users provide Core reference if possible or last used reference.
   */
  @Column(name = "MANDATE_IDENTIFICATION", length = 35, nullable = false)
  private String mandateIdentification;

  /**
   * Specifies the status of the direct debit in code form.
   */
  @Column(name = "DIRECT_DEBIT_STATUS_CODE", nullable = true)
  @Enumerated(EnumType.STRING)
  private DirectDebitStatusCode directDebitStatusCode;

  /**
   * Name of Service User.
   */
  @Column(name = "NAME", length = 70, nullable = false)
  private String name;

  /**
   * Date of most recent direct debit collection.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "PREVIOUS_PAYMENT_DATE_TIME", nullable = true)
  private Date previousPaymentDateTime;

  /**
   * The amount of the most recent direct debit collection.
   */
  @Embedded
  private Amount previousPaymentAmount;

  protected DirectDebit() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getDirectDebitId() {
    return directDebitId;
  }

  public void setDirectDebitId(String directDebitId) {
    this.directDebitId = directDebitId;
  }

  public String getMandateIdentification() {
    return mandateIdentification;
  }

  public void setMandateIdentification(String mandateIdentification) {
    this.mandateIdentification = mandateIdentification;
  }

  public DirectDebitStatusCode getDirectDebitStatusCode() {
    return directDebitStatusCode;
  }

  public void setDirectDebitStatusCode(DirectDebitStatusCode directDebitStatusCode) {
    this.directDebitStatusCode = directDebitStatusCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPreviousPaymentDateTime() {
    return previousPaymentDateTime;
  }

  public void setPreviousPaymentDateTime(Date previousPaymentDateTime) {
    this.previousPaymentDateTime = previousPaymentDateTime;
  }

  public Amount getPreviousPaymentAmount() {
    return previousPaymentAmount;
  }

  public void setPreviousPaymentAmount(Amount previousPaymentAmount) {
    this.previousPaymentAmount = previousPaymentAmount;
  }
}
