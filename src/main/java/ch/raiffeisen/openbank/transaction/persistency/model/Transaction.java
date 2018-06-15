package ch.raiffeisen.openbank.transaction.persistency.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;

/**
 * This entity provides further details on an entry in the report.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", length = 40, nullable = false)
  private String accountId;

  /**
   * Unique identifier for the transaction within an servicing institution. This identifier is both
   * unique and immutable.
   */
  @Column(name = "TRANSACTION_ID", length = 40, nullable = false)
  private String transactionId;

  /**
   * Unique reference for the transaction. This reference is optionally populated, and may as an
   * example be the FPID in the Faster Payments context.
   */
  @Column(name = "TRANSACTION_REFERENCE", length = 35, nullable = false)
  private String transactionReference;

  /**
   * Amount of money in the cash transaction entry.
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
   * Status of a transaction entry on the books of the account servicer.
   */
  @Column(name = "TYPE", nullable = false)
  @Enumerated(EnumType.STRING)
  private TransactionStatus status;

  /**
   * Date and time when a transaction entry is posted to an account on the account servicer's books.
   * 
   * Usage: Booking date is the expected booking date, unless the status is booked, in which case it
   * is the actual booking date.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "BOOKING_DATETIME", nullable = false)
  private Date bookingDateTime;

  /**
   * Date and time at which assets become available to the account owner in case of a credit entry,
   * or cease to be available to the account owner in case of a debit transaction entry. Usage: If
   * transaction entry status is pending and value date is present, then the value date refers to an
   * expected/requested value date. For transaction entries subject to availability/float and for
   * which availability information is provided, the value date must not be used. In this case the
   * availability component identifies the number of availability days.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "VALUE_DATETIME", nullable = true)
  private Date valueDateTime;

  /**
   * Further details of the transaction. This is the transaction narrative, which is unstructured
   * text.
   */
  @Column(name = "TRANSACTION_INFORMATION", length = 500, nullable = true)
  private String transactionInformation;

  /**
   * Further details of the transaction. This is the transaction narrative, which is unstructured
   * text.
   */
  @Column(name = "ADDRESS_LINE", length = 70, nullable = true)
  private String addressLine;

  /**
   * Set of elements used to fully identify the type of underlying transaction resulting in an
   * entry.
   */
  @OneToOne(mappedBy = "transaction")
  private BankTransactionCode bankTransactionCode;

  /**
   * Set of elements to fully identify a proprietary bank transaction code.
   */
  @OneToOne(mappedBy = "transaction")
  private ProprietaryBankTransactionCode proprietaryBankTransactionCode;

  /**
   * Set of elements used to define the balance as a numerical representation of the net increases
   * and decreases in an account after a transaction entry is applied to the account.
   */
  @OneToOne
  private TransactionBalance balance;

  /**
   * Details of the merchant involved in the transaction.
   */
  @OneToOne(mappedBy = "transaction")
  private MerchantDetails merchantDetails;

  /**
   * Amount of money to be transferred between the debtor and creditor, before deduction of charges,
   * expressed in the currency of the debtor's account, and to be transferred into a different
   * currency.
   * 
   * Usage : Currency of the amount is expressed in the currency of the debtor's account, but the
   * amount to be transferred is in another currency. The debtor agent will convert the amount and
   * currency to the to be transferred amount and currency, eg, 'pay equivalent of 100000 EUR in
   * JPY'(and account is in EUR).
   */
  @OneToOne(mappedBy = "transaction")
  private EquivalentAmount equivalentAmount;

  /**
   * Financial institution servicing an account for the creditor.
   */
  @OneToOne(mappedBy = "transaction")
  private CreditorAgent creditorAgent;

  /**
   * Unambiguous identification of the account of the creditor, in the case of a debit transaction.
   */
  @OneToOne(mappedBy = "transaction")
  private CreditorAccount creditorAccount;

  /**
   * Financial institution servicing an account for the debtor.
   */
  @OneToOne(mappedBy = "transaction")
  private DebtorAgent debtorAgent;

  /**
   * Unambiguous identification of the account of the debtor, in the case of a credit transaction.
   */
  @OneToOne(mappedBy = "transaction")
  private DebtorAccount debtorAccount;

  /**
   * Set of elements to describe the card instrument used in the transaction.
   */
  @OneToOne(mappedBy = "transaction")
  private CardInstrument cardInstrument;

  protected Transaction() {}

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


  public String getTransactionId() {
    return transactionId;
  }


  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }


  public String getTransactionReference() {
    return transactionReference;
  }


  public void setTransactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
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


  public TransactionStatus getStatus() {
    return status;
  }


  public void setStatus(TransactionStatus status) {
    this.status = status;
  }


  public Date getBookingDateTime() {
    return bookingDateTime;
  }


  public void setBookingDateTime(Date bookingDateTime) {
    this.bookingDateTime = bookingDateTime;
  }


  public Date getValueDateTime() {
    return valueDateTime;
  }


  public void setValueDateTime(Date valueDateTime) {
    this.valueDateTime = valueDateTime;
  }


  public String getTransactionInformation() {
    return transactionInformation;
  }


  public void setTransactionInformation(String transactionInformation) {
    this.transactionInformation = transactionInformation;
  }


  public String getAddressLine() {
    return addressLine;
  }


  public void setAddressLine(String addressLine) {
    this.addressLine = addressLine;
  }


  public BankTransactionCode getBankTransactionCode() {
    return bankTransactionCode;
  }


  public void setBankTransactionCode(BankTransactionCode bankTransactionCode) {
    this.bankTransactionCode = bankTransactionCode;
  }


  public ProprietaryBankTransactionCode getProprietaryBankTransactionCode() {
    return proprietaryBankTransactionCode;
  }


  public void setProprietaryBankTransactionCode(ProprietaryBankTransactionCode proprietaryBankTransactionCode) {
    this.proprietaryBankTransactionCode = proprietaryBankTransactionCode;
  }


  public TransactionBalance getBalance() {
    return balance;
  }


  public void setBalance(TransactionBalance balance) {
    this.balance = balance;
  }


  public MerchantDetails getMerchantDetails() {
    return merchantDetails;
  }


  public void setMerchantDetails(MerchantDetails merchantDetails) {
    this.merchantDetails = merchantDetails;
  }


  public EquivalentAmount getEquivalentAmount() {
    return equivalentAmount;
  }


  public void setEquivalentAmount(EquivalentAmount equivalentAmount) {
    this.equivalentAmount = equivalentAmount;
  }

  public CreditorAgent getCreditorAgent() {
    return creditorAgent;
  }


  public void setCreditorAgent(CreditorAgent creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public CreditorAccount getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public DebtorAgent getDebtorAgent() {
    return debtorAgent;
  }

  public void setDebtorAgent(DebtorAgent debtorAgent) {
    this.debtorAgent = debtorAgent;
  }

  public DebtorAccount getDebtorAccount() {
    return debtorAccount;
  }

  public void setDebtorAccount(DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
  }

  public CardInstrument getCardInstrument() {
    return cardInstrument;
  }

  public void setCardInstrument(CardInstrument cardInstrument) {
    this.cardInstrument = cardInstrument;
  }

}
