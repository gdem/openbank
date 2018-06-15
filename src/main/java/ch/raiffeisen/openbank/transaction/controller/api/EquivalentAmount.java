package ch.raiffeisen.openbank.transaction.controller.api;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
    description = "Amount of money to be transferred between the debtor and creditor, before deduction of charges, expressed in the currency of the debtor's account, and to be transferred into a different currency. Usage : Currency of the amount is expressed in the currency of the debtor's account, but the amount to be transferred is in another currency. The debtor agent will convert the amount and currency to the to be transferred amount and currency, eg, 'pay equivalent of 100000 EUR in JPY'(and account is in EUR).")
public class EquivalentAmount {

  @ApiModelProperty(
      notes = "Amount of money to be transferred between debtor and creditor, before deduction of charges, expressed in the currency of the debtor's account, and to be transferred in a different currency. Usage : Currency of the amount is expressed in the currency of the debtor's account, but the amount to be transferred is in another currency. The first agent will convert the amount and currency to the to be transferred amount and currency, eg, 'pay equivalent of 100000 EUR in JPY'(and account is in EUR).")
  private BigDecimal amount;

  @ApiModelProperty(
      notes = "Code allocated to a currency, by a maintenance agency, under an international identification scheme as described in the latest edition of the international standard ISO 4217 \"Codes for the representation of currencies and funds\". Valid currency codes are registered with the ISO 4217 Maintenance Agency, and consist of three contiguous letters.")
  private String currency;

  @ApiModelProperty(notes = "Specifies the currency of the to be transferred amount, which is different from the currency of the debtor's account.")
  private String currencyOfTransfer;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCurrencyOfTransfer() {
    return currencyOfTransfer;
  }

  public void setCurrencyOfTransfer(String currencyOfTransfer) {
    this.currencyOfTransfer = currencyOfTransfer;
  }


}
