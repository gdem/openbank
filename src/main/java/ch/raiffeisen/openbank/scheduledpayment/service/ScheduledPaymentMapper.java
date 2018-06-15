package ch.raiffeisen.openbank.scheduledpayment.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.scheduledpayment.persistency.model.CreditorAccount;
import ch.raiffeisen.openbank.scheduledpayment.persistency.model.CreditorAgent;
import ch.raiffeisen.openbank.scheduledpayment.persistency.model.ScheduledPayment;
import ch.raiffeisen.openbank.scheduledpayment.service.api.CreditorAccountDTO;
import ch.raiffeisen.openbank.scheduledpayment.service.api.CreditorAgentDTO;
import ch.raiffeisen.openbank.scheduledpayment.service.api.ScheduledPaymentDTO;

/**
 * This class represents the mapper for scheduled payment.
 * 
 * @author Timur Tokoev
 */
@Component
public class ScheduledPaymentMapper {

  public ScheduledPaymentDTO convert(ScheduledPayment scheduledPayment) {
    Objects.requireNonNull(scheduledPayment);

    final ScheduledPaymentDTO dto = new ScheduledPaymentDTO();
    dto.setAccountId(scheduledPayment.getAccountId());
    dto.setReference(scheduledPayment.getReference());
    dto.setScheduledPaymentDateTime(scheduledPayment.getScheduledPaymentDateTime());
    dto.setScheduledPaymentId(scheduledPayment.getScheduledPaymentId());
    dto.setScheduledType(scheduledPayment.getScheduledType());

    Amount instructedAmount = scheduledPayment.getInstructedAmount();
    if (instructedAmount != null) {
      dto.setInstructedAmount(new AmountDTO(instructedAmount.getAmount(), instructedAmount.getCurrency()));
    }

    CreditorAgent creditorAgent = scheduledPayment.getCreditorAgent();
    if (creditorAgent != null) {
      CreditorAgentDTO creditorAgentDTO = new CreditorAgentDTO();
      creditorAgentDTO.setSchemeName(creditorAgent.getSchemeName());
      creditorAgentDTO.setIdentification(creditorAgent.getIdentification());
      dto.setCreditorAgent(creditorAgentDTO);
    }

    CreditorAccount creditorAccount = scheduledPayment.getCreditorAccount();
    if (creditorAccount != null) {
      CreditorAccountDTO creditorAccountDTO = new CreditorAccountDTO();
      creditorAccountDTO.setSchemeName(creditorAccount.getSchemeName());
      creditorAccountDTO.setIdentification(creditorAccount.getIdentification());
      creditorAccountDTO.setName(creditorAccount.getName());
      creditorAccountDTO.setSecondaryIdentification(creditorAccount.getSecondaryIdentification());
      dto.setCreditorAccount(creditorAccountDTO);
    }

    return dto;
  }
}
