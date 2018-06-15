package ch.raiffeisen.openbank.balance.persistency.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Set of elements used to provide details on the credit line.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BALANCE_CREDIT_LINES")
public class CreditLine {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BALANCE_ID")
  private Balance balance;

  /**
   * Indicates whether or not the credit line is included in the balance of the account.
   * 
   * Usage: If not present, credit line is not included in the balance amount of the account.
   */
  @Column(name = "INCLUDED", nullable = false)
  private Boolean included;

  /**
   * Amount of money of the credit line.
   */
  @Column(name = "AMOUNT", nullable = true)
  private BigDecimal amount;

  /**
   * A code allocated to a currency by a Maintenance Agency under an international identification
   * scheme, as described in the latest edition of the international standard ISO 4217 "Codes for
   * the representation of currencies and funds".
   */
  @Column(name = "CURRENCY", nullable = false, length = 3)
  private String currency;

  /**
   * Limit type, in a coded form.
   */
  @Column(name = "TYPE", nullable = true)
  @Enumerated(EnumType.STRING)
  private CreditLineType creditLineType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Balance getBalance() {
    return balance;
  }

  public void setBalance(Balance balance) {
    this.balance = balance;
  }

  public Boolean getIncluded() {
    return included;
  }

  public void setIncluded(Boolean included) {
    this.included = included;
  }

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

  public CreditLineType getCreditLineType() {
    return creditLineType;
  }

  public void setCreditLineType(CreditLineType creditLineType) {
    this.creditLineType = creditLineType;
  }



}
