package ch.raiffeisen.openbank.account.service.api;

import java.util.ArrayList;
import java.util.List;

import ch.raiffeisen.openbank.account.persistency.model.AccountSubType;
import ch.raiffeisen.openbank.account.persistency.model.AccountType;

public class AccountDTO {
  private String accountId;
  private String currency;
  private AccountType accountType;
  private AccountSubType accountSubType;
  private String description;
  private String nickname;
  private List<AccountIdentificationDTO> accountIdentifications = new ArrayList<>();
  private ServicerDTO servicer;

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

  public List<AccountIdentificationDTO> getAccountIdentifications() {
    return accountIdentifications;
  }

  public void setAccountIdentifications(List<AccountIdentificationDTO> accountIdentifications) {
    this.accountIdentifications = accountIdentifications;
  }

  public ServicerDTO getServicer() {
    return servicer;
  }

  public void setServicer(ServicerDTO servicer) {
    this.servicer = servicer;
  }
}
