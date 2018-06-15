package ch.raiffeisen.openbank.balance.service.api;

import java.util.Date;

import ch.raiffeisen.openbank.common.repository.model.BalanceType;
import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;

public class BalanceDTO {
  private Long id;
  private String accountId;
  private AmountDTO amount;
  private CreditDebitCode creditDebitIndicator;
  private BalanceType balanceType;
  private Date dateTime;

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

  public AmountDTO getAmount() {
    return amount;
  }

  public void setAmount(AmountDTO amount) {
    this.amount = amount;
  }

  public CreditDebitCode getCreditDebitIndicator() {
    return creditDebitIndicator;
  }

  public void setCreditDebitIndicator(CreditDebitCode creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
  }

  public BalanceType getBalanceType() {
    return balanceType;
  }

  public void setBalanceType(BalanceType balanceType) {
    this.balanceType = balanceType;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }


}
