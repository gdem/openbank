package ch.raiffeisen.openbank.transaction.persistency.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This embeddable represents amoun of money to be transferred between the debtor and creditor,
 * before deduction of charges, expressed in the currency of the debtor's account, and to be
 * transferred into a different currency.
 * 
 * Usage : Currency of the amount is expressed in the currency of the debtor's account, but the
 * amount to be transferred is in another currency. The debtor agent will convert the amount and
 * currency to the to be transferred amount and currency, eg, 'pay equivalent of 100000 EUR in
 * JPY'(and account is in EUR).
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_EQUIVALENT_AMOUNT")
public class EquivalentAmount {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "TRANSACTION_ID")
  private Transaction transaction;

  @Column(name = "AMOUNT", nullable = false)
  private BigDecimal amount;

  @Column(name = "CURRENCY", length = 3, nullable = false)
  private String currency;

  @Column(name = "CURRENCY_OF_TRANSFER", length = 3, nullable = false)
  private String currencyOfTransfer;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
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

  public String getCurrencyOfTransfer() {
    return currencyOfTransfer;
  }

  public void setCurrencyOfTransfer(String currencyOfTransfer) {
    this.currencyOfTransfer = currencyOfTransfer;
  }

}
