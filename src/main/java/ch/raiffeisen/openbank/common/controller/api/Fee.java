package ch.raiffeisen.openbank.common.controller.api;

import java.math.BigDecimal;

public class Fee {
  private final BigDecimal fee;
  private final String currency;

  public Fee(BigDecimal fee, String currency) {
    this.fee = fee;
    this.currency = currency;
  }

  public BigDecimal getFee() {
    return fee;
  }

  public String getCurrency() {
    return currency;
  }
}
