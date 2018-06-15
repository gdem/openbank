package ch.raiffeisen.openbank.common.service.api;

import java.math.BigDecimal;

public class AmountDTO {
  private final BigDecimal amount;
  private final String currency;

  public AmountDTO(BigDecimal amount, String currency) {
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
