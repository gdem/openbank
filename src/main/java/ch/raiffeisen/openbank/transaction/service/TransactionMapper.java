package ch.raiffeisen.openbank.transaction.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.transaction.persistency.model.TransactionBalance;
import ch.raiffeisen.openbank.transaction.persistency.model.BankTransactionCode;
import ch.raiffeisen.openbank.transaction.persistency.model.CardInstrument;
import ch.raiffeisen.openbank.transaction.persistency.model.CreditorAccount;
import ch.raiffeisen.openbank.transaction.persistency.model.CreditorAgent;
import ch.raiffeisen.openbank.transaction.persistency.model.DebtorAccount;
import ch.raiffeisen.openbank.transaction.persistency.model.DebtorAgent;
import ch.raiffeisen.openbank.transaction.persistency.model.EquivalentAmount;
import ch.raiffeisen.openbank.transaction.persistency.model.MerchantDetails;
import ch.raiffeisen.openbank.transaction.persistency.model.ProprietaryBankTransactionCode;
import ch.raiffeisen.openbank.transaction.persistency.model.Transaction;
import ch.raiffeisen.openbank.transaction.service.api.BalanceDTO;
import ch.raiffeisen.openbank.transaction.service.api.BankTransactionCodeDTO;
import ch.raiffeisen.openbank.transaction.service.api.CardInstrumentDTO;
import ch.raiffeisen.openbank.transaction.service.api.CreditorAccountDTO;
import ch.raiffeisen.openbank.transaction.service.api.CreditorAgentDTO;
import ch.raiffeisen.openbank.transaction.service.api.DebtorAccountDTO;
import ch.raiffeisen.openbank.transaction.service.api.DebtorAgentDTO;
import ch.raiffeisen.openbank.transaction.service.api.EquivalentAmountDTO;
import ch.raiffeisen.openbank.transaction.service.api.MerchantDetailsDTO;
import ch.raiffeisen.openbank.transaction.service.api.ProprietaryBankTransactionCodeDTO;
import ch.raiffeisen.openbank.transaction.service.api.TransactionDTO;

/**
 * This class represents the transaction mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class TransactionMapper {

  public TransactionDTO convert(Transaction transaction) {
    Objects.requireNonNull(transaction);
    final TransactionDTO dto = new TransactionDTO();
    dto.setAccountId(transaction.getAccountId());
    dto.setTransactionId(transaction.getTransactionId());
    dto.setTransactionReference(transaction.getTransactionReference());

    Amount amount = transaction.getAmount();
    if (amount != null) {
      dto.setAmount(new AmountDTO(amount.getAmount(), amount.getCurrency()));
    }

    dto.setCreditDebitIndicator(transaction.getCreditDebitIndicator());
    dto.setStatus(transaction.getStatus());
    dto.setBookingDateTime(transaction.getBookingDateTime());
    dto.setValueDateTime(transaction.getValueDateTime());
    dto.setTransactionInformation(transaction.getTransactionInformation());
    dto.setAddressLine(transaction.getAddressLine());

    return dto;
  }

  public ProprietaryBankTransactionCodeDTO convert(ProprietaryBankTransactionCode pbtc) {
    ProprietaryBankTransactionCodeDTO dto = new ProprietaryBankTransactionCodeDTO();
    dto.setId(pbtc.getId());
    dto.setCode(pbtc.getCode());
    dto.setIssuer(pbtc.getIssuer());
    return dto;
  }

  public BankTransactionCodeDTO convert(BankTransactionCode btc) {
    BankTransactionCodeDTO dto = new BankTransactionCodeDTO();
    dto.setId(btc.getId());
    dto.setCode(btc.getCode());
    dto.setSubCode(btc.getSubCode());
    return dto;
  }

  public BalanceDTO convert(TransactionBalance balance) {
    BalanceDTO dto = new BalanceDTO();
    dto.setId(balance.getId());
    Amount amount = balance.getAmount();
    dto.setAmount(new AmountDTO(amount.getAmount(), amount.getCurrency()));
    dto.setCreditDebitIndicator(balance.getCreditDebitIndicator());
    dto.setBalanceType(balance.getBalanceType());
    return dto;
  }

  public MerchantDetailsDTO convert(MerchantDetails merchantDetails) {
    MerchantDetailsDTO dto = new MerchantDetailsDTO();
    dto.setId(merchantDetails.getId());
    dto.setMerchantCategoryCode(merchantDetails.getMerchantCategoryCode());
    dto.setMerchantName(merchantDetails.getMerchantName());
    return dto;
  }

  public EquivalentAmountDTO convert(EquivalentAmount equivalentAmount) {
    EquivalentAmountDTO dto = new EquivalentAmountDTO();
    dto.setId(equivalentAmount.getId());
    dto.setCurrency(equivalentAmount.getCurrency());
    dto.setCurrencyOfTransfer(equivalentAmount.getCurrencyOfTransfer());
    dto.setAmount(equivalentAmount.getAmount());
    return dto;
  }

  public CreditorAgentDTO convert(CreditorAgent creditorAgent) {
    CreditorAgentDTO dto = new CreditorAgentDTO();
    dto.setId(creditorAgent.getId());
    dto.setSchemeName(creditorAgent.getSchemeName());
    dto.setIdentification(creditorAgent.getIdentification());
    return dto;
  }

  public CreditorAccountDTO convert(CreditorAccount creditorAccount) {
    CreditorAccountDTO dto = new CreditorAccountDTO();
    dto.setId(creditorAccount.getId());
    dto.setIdentification(creditorAccount.getIdentification());
    dto.setName(creditorAccount.getName());
    dto.setSchemeName(creditorAccount.getSchemeName());
    dto.setSecondaryIdentification(creditorAccount.getSecondaryIdentification());
    return dto;
  }

  public DebtorAgentDTO convert(DebtorAgent creditorAgent) {
    DebtorAgentDTO dto = new DebtorAgentDTO();
    dto.setId(creditorAgent.getId());
    dto.setSchemeName(creditorAgent.getSchemeName());
    dto.setIdentification(creditorAgent.getIdentification());
    return dto;
  }

  public DebtorAccountDTO convert(DebtorAccount creditorAccount) {
    DebtorAccountDTO dto = new DebtorAccountDTO();
    dto.setId(creditorAccount.getId());
    dto.setIdentification(creditorAccount.getIdentification());
    dto.setName(creditorAccount.getName());
    dto.setSchemeName(creditorAccount.getSchemeName());
    dto.setSecondaryIdentification(creditorAccount.getSecondaryIdentification());
    return dto;
  }

  public CardInstrumentDTO convert(CardInstrument cardInstrument) {
    CardInstrumentDTO dto = new CardInstrumentDTO();
    dto.setId(cardInstrument.getId());
    dto.setIdentification(cardInstrument.getIdentification());
    dto.setCardSchemeName(cardInstrument.getCardSchemeName());
    dto.setAuthorisationType(cardInstrument.getAuthorisationType());
    dto.setName(cardInstrument.getName());
    return dto;
  }
}
