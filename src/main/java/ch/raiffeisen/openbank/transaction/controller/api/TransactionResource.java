package ch.raiffeisen.openbank.transaction.controller.api;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;
import ch.raiffeisen.openbank.transaction.persistency.model.TransactionStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Relation(value = "transaction", collectionRelation = "transactions")
@ApiModel(description = "Provides further details on an entry in the report.")
public class TransactionResource extends ResourceSupport {

  @ApiModelProperty(notes = "A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.")
  private String accountId;

  @ApiModelProperty(notes = "Unique identifier for the transaction within an servicing institution. This identifier is both unique and immutable.")
  private String transactionId;

  @ApiModelProperty(notes = "Unique reference for the transaction. This reference is optionally populated, and may as an example be the FPID in the Faster Payments context.")
  private String transactionReference;

  private Amount amount;

  @ApiModelProperty(notes = "Indicates whether the transaction is a credit or a debit entry.")
  private CreditDebitCode creditDebitIndicator;

  @ApiModelProperty(notes = "Status of a transaction entry on the books of the account servicer.")
  private TransactionStatus status;

  @ApiModelProperty(
      notes = "Date and time when a transaction entry is posted to an account on the account servicer's books. Usage: Booking date is the expected booking date, unless the status is booked, in which case it is the actual booking date.")
  private Date bookingDateTime;

  @ApiModelProperty(
      notes = "Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry. Usage: If transaction entry status is pending and value date is present, then the value date refers to an expected/requested value date. For transaction entries subject to availability/float and for which availability information is provided, the value date must not be used. In this case the availability component identifies the number of availability days.")
  private Date valueDateTime;

  @ApiModelProperty(notes = "Further details of the transaction. This is the transaction narrative, which is unstructured text.")
  private String transactionInformation;

  @ApiModelProperty(notes = "Information that locates and identifies a specific address for a transaction entry, that is presented in free format text.")
  private String addressLine;

  private BankTransactionCode bankTransactionCode;

  private ProprietaryBankTransactionCode proprietaryBankTransactionCode;

  private EquivalentAmount equivalentAmount;

  private MerchantDetails merchantDetails;

  private CreditorAgent creditorAgent;

  private CreditorAccount creditorAccount;

  private DebtorAgent debtorAgent;

  private DebtorAccount debtorAccount;

  private CardInstrument cardInstrument;

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
