package ch.raiffeisen.openbank.scheduledpayment.persistency.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ch.raiffeisen.openbank.common.repository.model.Amount;


/**
 * A resource that contains a set of elements that describes the scheduled payments that have been
 * set up on a specific account (AccountId). A scheduled payment is a single one-off payment
 * scheduled for a future date. An account (AccountId) may have no scheduled payments set up, or may
 * have multiple scheduled payments set up.
 * 
 * @author Timur Tokoev
 */
@Entity
@Table(name = "SCHEDULED_PAYMENT")
public class ScheduledPayment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", unique = true, nullable = false, length = 40)
  private String accountId;

  /**
   * A unique and immutable identifier used to identify the scheduled payment resource. This
   * identifier has no meaning to the account owner.
   */
  @Column(name = "SCHEDULED_PAYMENT_ID", unique = true, length = 40)
  private String scheduledPaymentId;

  /**
   * The date on which the scheduled payment will be made.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "SCHEDULED_PAYMENT_DATETIME", nullable = false)
  private Date scheduledPaymentDateTime;

  /**
   * Specifies the scheduled payment date type requested
   */
  @Column(name = "SCHEDULED_TYPE", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExternalScheduleTypeCode scheduledType;

  /**
   * Amount of money to be moved between the debtor and creditor, before deduction of charges,
   * expressed in the currency as ordered by the initiating party.
   * 
   * Usage: This amount has to be transported unchanged through the transaction chain.
   */
  @Embedded
  private Amount instructedAmount;

  /**
   * Unique reference, as assigned by the creditor, to unambiguously refer to the payment
   * transaction.
   * 
   * Usage: If available, the initiating party should provide this reference in the structured
   * remittance information, to enable reconciliation by the creditor upon receipt of the amount of
   * money.
   * 
   * If the business context requires the use of a creditor reference or a payment remit
   * identification, and only one identifier can be passed through the end-to-end chain, the
   * creditor's reference or payment remittance identification should be quoted in the end-to-end
   * transaction identification.
   */
  @Column(name = "REFERENCE", unique = true, length = 35)
  private String reference;


  /**
   * Party that manages the account on behalf of the account owner, that is manages the registration
   * and booking of entries on the account, calculates balances on the account and provides
   * information about the account. This is the servicer of the beneficiary account.
   */
  @OneToOne(mappedBy = "scheduledPayment")
  private CreditorAgent creditorAgent;

  /**
   * Provides the details to identify the beneficiary account.
   */
  @OneToOne(mappedBy = "scheduledPayment")
  private CreditorAccount creditorAccount;

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

  public String getScheduledPaymentId() {
    return scheduledPaymentId;
  }

  public void setScheduledPaymentId(String scheduledPaymentId) {
    this.scheduledPaymentId = scheduledPaymentId;
  }

  public Date getScheduledPaymentDateTime() {
    return scheduledPaymentDateTime;
  }

  public void setScheduledPaymentDateTime(Date scheduledPaymentDateTime) {
    this.scheduledPaymentDateTime = scheduledPaymentDateTime;
  }

  public ExternalScheduleTypeCode getScheduledType() {
    return scheduledType;
  }

  public void setScheduledType(ExternalScheduleTypeCode scheduledType) {
    this.scheduledType = scheduledType;
  }

  public Amount getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(Amount instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public CreditorAgent getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(CreditorAgent creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public CreditorAccount getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

}
