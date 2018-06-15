package ch.raiffeisen.openbank.common.service.api;

import java.math.BigDecimal;

public class FeeDTO {
  private final BigDecimal fee;
  private final String currency;

  public FeeDTO(BigDecimal fee, String currency) {
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
