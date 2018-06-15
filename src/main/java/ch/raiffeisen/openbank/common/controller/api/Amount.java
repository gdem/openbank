package ch.raiffeisen.openbank.common.controller.api;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class Amount {

  @ApiModelProperty(notes = "Amount of money.")
  private final BigDecimal amount;

  @ApiModelProperty(
      notes = "A code allocated to a currency by a Maintenance Agency under an international identification scheme, as described in the latest edition of the international standard ISO 4217 \"Codes for the representation of currencies and funds\".")
  private final String currency;

  public Amount(BigDecimal amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }
}
