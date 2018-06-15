package ch.raiffeisen.openbank.transaction.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.transaction.controller.api.BankTransactionCode;
import ch.raiffeisen.openbank.transaction.controller.api.CardInstrument;
import ch.raiffeisen.openbank.transaction.controller.api.CreditorAccount;
import ch.raiffeisen.openbank.transaction.controller.api.CreditorAgent;
import ch.raiffeisen.openbank.transaction.controller.api.DebtorAccount;
import ch.raiffeisen.openbank.transaction.controller.api.DebtorAgent;
import ch.raiffeisen.openbank.transaction.controller.api.EquivalentAmount;
import ch.raiffeisen.openbank.transaction.controller.api.MerchantDetails;
import ch.raiffeisen.openbank.transaction.controller.api.ProprietaryBankTransactionCode;
import ch.raiffeisen.openbank.transaction.controller.api.TransactionResource;
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
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class TransactionResourceAssembler extends ResourceAssemblerSupport<TransactionDTO, TransactionResource> {

  public TransactionResourceAssembler() {
    super(TransactionController.class, TransactionResource.class);
  }

  @Override
  public TransactionResource toResource(TransactionDTO dto) {
    final TransactionResource resource = createResourceWithId(dto.getId(), dto);
    resource.setAccountId(dto.getAccountId());
    resource.setTransactionId(dto.getTransactionId());
    resource.setTransactionReference(dto.getTransactionReference());

    AmountDTO amount = dto.getAmount();
    if (amount != null) {
      resource.setAmount(new Amount(amount.getAmount(), amount.getCurrency()));
    }

    resource.setCreditDebitIndicator(dto.getCreditDebitIndicator());
    resource.setStatus(dto.getStatus());
    resource.setBookingDateTime(dto.getBookingDateTime());
    resource.setValueDateTime(dto.getValueDateTime());
    resource.setTransactionInformation(dto.getTransactionInformation());
    resource.setAddressLine(dto.getAddressLine());

    BankTransactionCodeDTO bankTransactionCodeDTO = dto.getBankTransactionCode();
    if (bankTransactionCodeDTO != null) {
      BankTransactionCode btc = new BankTransactionCode();
      btc.setCode(bankTransactionCodeDTO.getCode());
      btc.setSubCode(bankTransactionCodeDTO.getSubCode());
      resource.setBankTransactionCode(btc);
    }

    ProprietaryBankTransactionCodeDTO proprietaryBankTransactionCodeDTO = dto.getProprietaryBankTransactionCode();
    if (proprietaryBankTransactionCodeDTO != null) {
      ProprietaryBankTransactionCode pbtc = new ProprietaryBankTransactionCode();
      pbtc.setCode(proprietaryBankTransactionCodeDTO.getCode());
      pbtc.setCode(pbtc.getIssuer());
      resource.setProprietaryBankTransactionCode(pbtc);
    }

    MerchantDetailsDTO merchantDetailsDTO = dto.getMerchantDetails();
    if (merchantDetailsDTO != null) {
      MerchantDetails mer = new MerchantDetails();
      mer.setMerchantCategoryCode(merchantDetailsDTO.getMerchantCategoryCode());
      mer.setMerchantName(merchantDetailsDTO.getMerchantName());
      resource.setMerchantDetails(mer);
    }

    EquivalentAmountDTO equivalentAmountDTO = dto.getEquivalentAmount();
    if (equivalentAmountDTO != null) {
      EquivalentAmount ea = new EquivalentAmount();
      ea.setAmount(equivalentAmountDTO.getAmount());
      ea.setCurrency(equivalentAmountDTO.getCurrency());
      ea.setCurrencyOfTransfer(equivalentAmountDTO.getCurrencyOfTransfer());
      resource.setEquivalentAmount(ea);
    }

    CreditorAgentDTO creditorAgentDTO = dto.getCreditorAgent();
    if (creditorAgentDTO != null) {
      CreditorAgent ca = new CreditorAgent();
      ca.setIdentification(creditorAgentDTO.getIdentification());
      ca.setSchemeName(creditorAgentDTO.getSchemeName());
      resource.setCreditorAgent(ca);
    }

    CreditorAccountDTO creditorAccountDTO = dto.getCreditorAccount();
    if (creditorAccountDTO != null) {
      CreditorAccount ca = new CreditorAccount();
      ca.setIdentification(creditorAccountDTO.getIdentification());
      ca.setName(creditorAccountDTO.getName());
      ca.setSchemeName(creditorAccountDTO.getSchemeName());
      ca.setSecondaryIdentification(creditorAccountDTO.getIdentification());
      resource.setCreditorAccount(ca);
    }

    DebtorAgentDTO debtorAgentDTO = dto.getDebtorAgent();
    if (debtorAgentDTO != null) {
      DebtorAgent ca = new DebtorAgent();
      ca.setIdentification(debtorAgentDTO.getIdentification());
      ca.setSchemeName(debtorAgentDTO.getSchemeName());
      resource.setDebtorAgent(ca);
    }

    DebtorAccountDTO debtorAccountDTO = dto.getDebtorAccount();
    if (debtorAccountDTO != null) {
      DebtorAccount ca = new DebtorAccount();
      ca.setIdentification(debtorAccountDTO.getIdentification());
      ca.setName(debtorAccountDTO.getName());
      ca.setSchemeName(debtorAccountDTO.getSchemeName());
      ca.setSecondaryIdentification(debtorAccountDTO.getIdentification());
      resource.setDebtorAccount(ca);
    }

    CardInstrumentDTO cardInstrumentDTO = dto.getCardInstrument();
    if (cardInstrumentDTO != null) {
      CardInstrument ci = new CardInstrument();
      ci.setIdentification(cardInstrumentDTO.getIdentification());
      ci.setCardSchemeName(cardInstrumentDTO.getCardSchemeName());
      ci.setAuthorisationType(cardInstrumentDTO.getAuthorisationType());
      ci.setName(cardInstrumentDTO.getName());
      resource.setCardInstrument(ci);
    }


    return resource;
  }
}
