package ch.raiffeisen.openbank.directdebits.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.directdebits.repository.model.DirectDebit;
import ch.raiffeisen.openbank.directdebits.service.api.DirectDebitDTO;

/**
 * This class represents the direct debit mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class DirectDebitMapper {

  public DirectDebitDTO convert(DirectDebit directDebit) {
    Objects.requireNonNull(directDebit);
    final DirectDebitDTO dto = new DirectDebitDTO();
    dto.setId(directDebit.getId());
    dto.setAccountId(directDebit.getAccountId());
    dto.setDirectDebitId(directDebit.getDirectDebitId());
    dto.setDirectDebitStatusCode(directDebit.getDirectDebitStatusCode());
    dto.setMandateIdentification(directDebit.getMandateIdentification());
    dto.setName(directDebit.getName());
    dto.setPreviousPaymentDateTime(directDebit.getPreviousPaymentDateTime());

    final Amount amount = directDebit.getPreviousPaymentAmount();
    if (amount != null) {
      dto.setPreviousPaymentAmount(new AmountDTO(amount.getAmount(), amount.getCurrency()));
    }

    return dto;
  }
}
