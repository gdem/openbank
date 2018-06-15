package ch.raiffeisen.openbank.balance.controller.api;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.repository.model.BalanceType;
import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Relation(value = "balance", collectionRelation = "balances")
@ApiModel(description = "Set of elements used to define the balance details.")
public class BalanceResource extends ResourceSupport {

  @ApiModelProperty(notes = "A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.")
  private String accountId;

  private Amount amount;

  @ApiModelProperty(notes = "Indicates whether the balance is a credit or a debit balance. Usage: A zero balance is considered to be a credit balance.")
  private CreditDebitCode creditDebitIndicator;

  @ApiModelProperty(notes = "Balance type, in a coded form.")
  private BalanceType balanceType;

  @ApiModelProperty(notes = "Indicates the date (and time) of the balance.")
  private Date dateTime;

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
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
