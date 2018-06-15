package ch.raiffeisen.openbank.account.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.account.persistency.model.AccountSubType;
import ch.raiffeisen.openbank.account.persistency.model.AccountType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Relation(value = "account", collectionRelation = "accounts")
@ApiModel(description = "Unambiguous identification of the account to which credit and debit entries are made.")
public class AccountResource extends ResourceSupport {

  @ApiModelProperty(notes = "A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.")
  private String accountId;

  @ApiModelProperty(notes = "Identification of the currency in which the account is held.")
  private String currency;

  @ApiModelProperty(notes = "Specifies the type of account (personal or business).")
  private AccountType accountType;

  @ApiModelProperty(notes = "Specifies the sub type of account (product family group).")
  private AccountSubType accountSubType;

  @ApiModelProperty(notes = "Specifies the description of the account type.")
  private String description;

  @ApiModelProperty(notes = "The nickname of the account, assigned by the account owner in order to provide an additional means of identification of the account.")
  private String nickname;

  private List<AccountIdentification> account = new ArrayList<>();

  private Servicer servicer;

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

  public Servicer getServicer() {
    return servicer;
  }

  public void setServicer(Servicer servicer) {
    this.servicer = servicer;
  }

  public List<AccountIdentification> getAccount() {
    return account;
  }

  public void setAccount(List<AccountIdentification> account) {
    this.account = account;
  }
}
