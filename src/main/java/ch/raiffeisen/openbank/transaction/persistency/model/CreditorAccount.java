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

import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;

/**
 * This entity represents an unambiguous identification of the account of the creditor, in the case
 * of a debit transaction
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_CREDIT_ACCOUNT")
public class CreditorAccount {

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
   * 
   * Usage: The account name is different from the account owner name. The account name is used in
   * certain user communities to provide a means of identifying the account, in addition to the
   * account owner's identity and the account number. OB: No name validation is expected for
   * confirmation of payee.
   */
  @Column(name = "NAME", nullable = true, length = 70)
  private String name;

  /**
   * This is secondary identification of the account, as assigned by the account servicing
   * institution. This can be used by building societies to additionally identify accounts with a
   * roll number (in addition to a sort code and account number combination).
   */
  @Column(name = "SECONDARY_IDENTIFICATION", nullable = true, length = 34)
  private String secondaryIdentification;

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
}
