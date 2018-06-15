package ch.raiffeisen.openbank.common.repository.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This embeddable represents an amount of money.
 * 
 * @author Goekhan Demirkiyik
 */
@Embeddable
public class Amount {

  @Column(name = "AMOUNT", nullable = false)
  private BigDecimal amount;

  @Column(name = "CURRENCY", length = 3, nullable = false)
  private String currency;

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

}
