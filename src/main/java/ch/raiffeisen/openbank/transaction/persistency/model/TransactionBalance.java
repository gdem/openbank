package ch.raiffeisen.openbank.transaction.persistency.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.repository.model.BalanceType;
import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;

/**
 * This entity represents the element used to define the balance as a numerical representation of
 * the net increases and decreases in an account after a transaction entry is applied to the
 * account.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_BALANCE")
public class TransactionBalance {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "TRANSACTION_ID")
  private Transaction transaction;

  /**
   * Amount of money of the cash balance.
   */
  @Embedded
  private Amount amount;

  /**
   * Indicates whether the balance is a credit or a debit balance. Usage: A zero balance is
   * considered to be a credit balance.
   */
  @Column(name = "CREDIT_DEBIT_CODE", nullable = false)
  @Enumerated(EnumType.STRING)
  private CreditDebitCode creditDebitIndicator;

  /**
   * Balance type, in a coded form.
   */
  @Column(name = "TYPE", nullable = false)
  @Enumerated(EnumType.STRING)
  private BalanceType balanceType;

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
}
