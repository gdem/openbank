package ch.raiffeisen.openbank.common.repository.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This embeddable represents the fee value object.
 * 
 * @author Goekhan Demirkiyik
 */
@Embeddable
public class Fee {

  @Column(name = "FEE", nullable = false)
  private BigDecimal fee;

  @Column(name = "CURRENCY", nullable = false)
  private String currency;

  public BigDecimal getFee() {
    return fee;
  }

  public void setFee(BigDecimal fee) {
    this.fee = fee;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
