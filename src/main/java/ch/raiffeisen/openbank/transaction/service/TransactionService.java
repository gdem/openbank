package ch.raiffeisen.openbank.transaction.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.transaction.persistency.TransactionRepository;
import ch.raiffeisen.openbank.transaction.persistency.model.TransactionBalance;
import ch.raiffeisen.openbank.transaction.persistency.model.BankTransactionCode;
import ch.raiffeisen.openbank.transaction.persistency.model.CreditorAccount;
import ch.raiffeisen.openbank.transaction.persistency.model.CreditorAgent;
import ch.raiffeisen.openbank.transaction.persistency.model.DebtorAccount;
import ch.raiffeisen.openbank.transaction.persistency.model.DebtorAgent;
import ch.raiffeisen.openbank.transaction.persistency.model.EquivalentAmount;
import ch.raiffeisen.openbank.transaction.persistency.model.MerchantDetails;
import ch.raiffeisen.openbank.transaction.persistency.model.ProprietaryBankTransactionCode;
import ch.raiffeisen.openbank.transaction.persistency.model.Transaction;
import ch.raiffeisen.openbank.transaction.service.api.TransactionDTO;

/**
 * This class represents the transaction service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class TransactionService {

  @Inject
  private TransactionRepository transactionRepository;

  @Inject
  private TransactionMapper transactionMapper;

  public Page<TransactionDTO> findAll(Pageable pageable) {
    return transactionRepository.findAll(pageable).map(this::map);
  }

  public Page<TransactionDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return transactionRepository.findByAccountId(accountId, pageable).map(this::map);
  }

  private TransactionDTO map(Transaction transaction) {
    TransactionDTO result = transactionMapper.convert(transaction);

    BankTransactionCode btc = transaction.getBankTransactionCode();
    if (btc != null) {
      result.setBankTransactionCode(transactionMapper.convert(btc));
    }

    ProprietaryBankTransactionCode pbtc = transaction.getProprietaryBankTransactionCode();
    if (pbtc != null) {
      result.setProprietaryBankTransactionCode(transactionMapper.convert(pbtc));
    }

    TransactionBalance balance = transaction.getBalance();
    if (balance != null) {
      result.setBalance(transactionMapper.convert(balance));
    }

    MerchantDetails merchantDetails = transaction.getMerchantDetails();
    if (merchantDetails != null) {
      result.setMerchantDetails(transactionMapper.convert(merchantDetails));
    }

    EquivalentAmount equivalentAmount = transaction.getEquivalentAmount();
    if (equivalentAmount != null) {
      result.setEquivalentAmount(transactionMapper.convert(equivalentAmount));
    }

    CreditorAgent creditorAgent = transaction.getCreditorAgent();
    if (creditorAgent != null) {
      result.setCreditorAgent(transactionMapper.convert(creditorAgent));
    }

    CreditorAccount creditorAccount = transaction.getCreditorAccount();
    if (creditorAccount != null) {
      result.setCreditorAccount(transactionMapper.convert(creditorAccount));
    }

    DebtorAgent debtorAgent = transaction.getDebtorAgent();
    if (debtorAgent != null) {
      result.setDebtorAgent(transactionMapper.convert(debtorAgent));
    }

    DebtorAccount debtorAccount = transaction.getDebtorAccount();
    if (debtorAccount != null) {
      result.setDebtorAccount(transactionMapper.convert(debtorAccount));
    }

    return result;
  }
}

