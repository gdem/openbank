package ch.raiffeisen.openbank.account.persistency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * This entity represents the account to which credit and debit entries are made.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Id
  @Column(name = "ACCOUNT_ID", length = 40)
  private String accountId;

  /**
   * Identification of the currency in which the account is held. Pattern: ^[A-Z]{3,3}$
   */
  @Column(name = "CURRENCY")
  private String currency;

  /**
   * Specifies the type of account (personal or business).
   */
  @Column(name = "ACCOUNT_TYPE")
  @Enumerated(EnumType.STRING)
  private AccountType accountType;

  /**
   * Specifies the sub type of account (product family group).
   */
  @Column(name = "ACCOUNT_SUB_TYPE")
  @Enumerated(EnumType.STRING)
  private AccountSubType accountSubType;

  /**
   * Specifies the description of the account type.
   */
  @Column(name = "DESCRIPTION", nullable = true, length = 35)
  private String description;

  /**
   * The nickname of the account, assigned by the account owner in order to provide an additional
   * means of identification of the account.
   */
  @Column(name = "NICKNAME", nullable = true, length = 70)
  private String nickname;

  /**
   * Provides the details to identify an account.
   */
  @OneToMany(mappedBy = "account")
  private List<AccountIdentification> accountIdentifications = new ArrayList<>();

  /**
   * Party that manages the account on behalf of the account owner, that is manages the registration
   * and booking of entries on the account, calculates balances on the account and provides
   * information about the account.
   */
  @OneToOne
  private Servicer servicer;

  protected Account() {}

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public AccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public AccountSubType getAccountSubType() {
    return accountSubType;
  }

  public void setAccountSubType(AccountSubType accountSubType) {
    this.accountSubType = accountSubType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public List<AccountIdentification> getAccountIdentifications() {
    return accountIdentifications;
  }

  public void setAccountIdentifications(List<AccountIdentification> accountIdentifications) {
    this.accountIdentifications = accountIdentifications;
  }

  public Servicer getServicer() {
    return servicer;
  }

  public void setServicer(Servicer servicer) {
    this.servicer = servicer;
  }
}
