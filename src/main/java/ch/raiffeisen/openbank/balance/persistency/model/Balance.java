package ch.raiffeisen.openbank.balance.persistency.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ch.raiffeisen.openbank.account.persistency.model.Account;
import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.repository.model.BalanceType;
import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;


/**
 * This entity represents the net increases and decreases in an {@link Account} at a specific point
 * in time.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BALANCE")
public class Balance {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", nullable = false, length = 40)
  private String accountId;

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

  /**
   * Indicates the date (and time) of the balance.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DATE_TIME", nullable = false)
  private Date dateTime;

  /**
   * Set of elements used to provide details on the credit line.
   */
  @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL)
  private List<CreditLine> creditLines = new ArrayList<>();

  protected Balance() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
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

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public List<CreditLine> getCreditLines() {
    return creditLines;
  }

  public void setCreditLines(List<CreditLine> creditLines) {
    this.creditLines = creditLines;
  }
}
