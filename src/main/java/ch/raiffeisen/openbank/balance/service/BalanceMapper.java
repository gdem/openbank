package ch.raiffeisen.openbank.balance.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.balance.persistency.model.Balance;
import ch.raiffeisen.openbank.balance.service.api.BalanceDTO;
import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;

/**
 * This class represents the balance mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class BalanceMapper {

  public BalanceDTO convert(Balance balance) {
    Objects.requireNonNull(balance);
    final BalanceDTO dto = new BalanceDTO();
    dto.setId(balance.getId());
    dto.setAccountId(balance.getAccountId());
    Amount amount = balance.getAmount();
    if (amount != null) {
      dto.setAmount(new AmountDTO(amount.getAmount(), amount.getCurrency()));
    }
    dto.setBalanceType(balance.getBalanceType());
    dto.setCreditDebitIndicator(balance.getCreditDebitIndicator());
    dto.setDateTime(balance.getDateTime());
    return dto;
  }
}
