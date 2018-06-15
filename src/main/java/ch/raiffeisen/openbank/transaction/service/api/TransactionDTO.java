package ch.raiffeisen.openbank.transaction.service.api;

import java.util.Date;

import ch.raiffeisen.openbank.common.repository.model.CreditDebitCode;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.transaction.persistency.model.TransactionStatus;

public class TransactionDTO {
  private Long id;
  private String accountId;
  private String transactionId;
  private String transactionReference;
  private AmountDTO amount;
  private CreditDebitCode creditDebitIndicator;
  private TransactionStatus status;
  private Date bookingDateTime;
  private Date valueDateTime;
  private String transactionInformation;
  private String addressLine;
  private BankTransactionCodeDTO bankTransactionCode;
  private ProprietaryBankTransactionCodeDTO proprietaryBankTransactionCode;
  private BalanceDTO balance;
  private MerchantDetailsDTO merchantDetails;
  private EquivalentAmountDTO equivalentAmount;
  private CreditorAgentDTO creditorAgent;
  private CreditorAccountDTO creditorAccount;
  private DebtorAgentDTO debtorAgent;
  private DebtorAccountDTO debtorAccount;
  private CardInstrumentDTO cardInstrument;

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

  public AmountDTO getAmount() {
    return amount;
  }

  public void setAmount(AmountDTO amount) {
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

  public BankTransactionCodeDTO getBankTransactionCode() {
    return bankTransactionCode;
  }

  public void setBankTransactionCode(BankTransactionCodeDTO bankTransactionCode) {
    this.bankTransactionCode = bankTransactionCode;
  }

  public ProprietaryBankTransactionCodeDTO getProprietaryBankTransactionCode() {
    return proprietaryBankTransactionCode;
  }

  public void setProprietaryBankTransactionCode(ProprietaryBankTransactionCodeDTO proprietaryBankTransactionCode) {
    this.proprietaryBankTransactionCode = proprietaryBankTransactionCode;
  }

  public BalanceDTO getBalance() {
    return balance;
  }

  public void setBalance(BalanceDTO balance) {
    this.balance = balance;
  }

  public MerchantDetailsDTO getMerchantDetails() {
    return merchantDetails;
  }

  public void setMerchantDetails(MerchantDetailsDTO merchantDetails) {
    this.merchantDetails = merchantDetails;
  }

  public EquivalentAmountDTO getEquivalentAmount() {
    return equivalentAmount;
  }

  public void setEquivalentAmount(EquivalentAmountDTO equivalentAmount) {
    this.equivalentAmount = equivalentAmount;
  }

  public CreditorAgentDTO getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(CreditorAgentDTO creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public CreditorAccountDTO getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccountDTO creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public DebtorAgentDTO getDebtorAgent() {
    return debtorAgent;
  }

  public void setDebtorAgent(DebtorAgentDTO debtorAgent) {
    this.debtorAgent = debtorAgent;
  }

  public DebtorAccountDTO getDebtorAccount() {
    return debtorAccount;
  }

  public void setDebtorAccount(DebtorAccountDTO debtorAccount) {
    this.debtorAccount = debtorAccount;
  }

  public CardInstrumentDTO getCardInstrument() {
    return cardInstrument;
  }

  public void setCardInstrument(CardInstrumentDTO cardInstrument) {
    this.cardInstrument = cardInstrument;
  }

}
