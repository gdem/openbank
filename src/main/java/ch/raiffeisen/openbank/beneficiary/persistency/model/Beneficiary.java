package ch.raiffeisen.openbank.beneficiary.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This entity represents the beneficiary to which credit and debit entries are made.
 * 
 * @author Timur Tokoev
 */
@Entity
@Table(name = "BENEFICIARY")
public class Beneficiary {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", nullable = false, length = 40)
  private String accountId;

  /**
   * A unique and immutable identifier used to identify the beneficiary resource. This identifier
   * has no meaning to the account owner.
   */
  @Column(name = "BENEFICIARY_ID", unique = true, length = 40)
  private String beneficiaryId;

  /**
   * Unique reference, as assigned by the creditor, to unambiguously refer to the payment
   * transaction.
   */
  @Column(name = "REFERENCE", unique = true, length = 35)
  private String reference;

  /**
   * Party that manages the account on behalf of the account owner, that is manages the registration
   * and booking of entries on the account, calculates balances on the account and provides
   * information about the account. This is the servicer of the beneficiary account.
   */
  @OneToOne(mappedBy = "beneficiary")
  private CreditorAgent creditorAgent;

  /**
   * Provides the details to identify the beneficiary account.
   */
  @OneToOne(mappedBy = "beneficiary")
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

  public String getBeneficiaryId() {
    return beneficiaryId;
  }

  public void setBeneficiaryId(String beneficiaryId) {
    this.beneficiaryId = beneficiaryId;
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
