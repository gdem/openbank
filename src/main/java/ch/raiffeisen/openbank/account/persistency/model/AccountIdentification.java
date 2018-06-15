package ch.raiffeisen.openbank.account.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;

/**
 * This embeddable provides the details to identify an account.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "ACCOUNT_ACCOUNTID")
public class AccountIdentification {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ACCOUNT_ID")
  private Account account;

  /**
   * Unique and unambiguous identification of the servicing institution.
   */
  @Column(name = "IDENTIFICATION", nullable = false, length = 34)
  private String identification;

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   */
  @Column(name = "SCHEME_NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExternalAccountIdentificationCode schemeName;

  /**
   * Name of the account, as assigned by the account servicing institution, in agreement with the
   * account owner in order to provide an additional means of identification of the account.
   * 
   * Usage: The account name is different from the account owner name. The account name is used in
   * certain user communities to provide a means of identifying the account, in addition to the
   * account owner's identity and the account number.
   */
  @Column(name = "NAME", nullable = true, length = 70)
  private String name;

  /**
   * Unique and unambiguous identification of the servicing institution.
   */
  @Column(name = "SECONDARY_IDENTIFICATION", nullable = true, length = 34)
  private String secondaryIdentification;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public ExternalAccountIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemaName(ExternalAccountIdentificationCode schemeName) {
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
