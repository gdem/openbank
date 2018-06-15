package ch.raiffeisen.openbank.account.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.account.persistency.model.Account;
import ch.raiffeisen.openbank.account.persistency.model.AccountIdentification;
import ch.raiffeisen.openbank.account.persistency.model.Servicer;
import ch.raiffeisen.openbank.account.service.api.AccountDTO;
import ch.raiffeisen.openbank.account.service.api.AccountIdentificationDTO;
import ch.raiffeisen.openbank.account.service.api.ServicerDTO;

/**
 * This class represents the account mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class AccountMapper {

  public AccountDTO convert(Account account) {
    Objects.requireNonNull(account);
    final AccountDTO dto = new AccountDTO();
    dto.setAccountId(account.getAccountId());
    dto.setCurrency(account.getCurrency());
    dto.setAccountType(account.getAccountType());
    dto.setAccountSubType(account.getAccountSubType());
    dto.setDescription(account.getDescription());
    dto.setNickname(account.getNickname());
    return dto;
  }

  public ServicerDTO convert(Servicer servicer) {
    final ServicerDTO dto = new ServicerDTO();
    dto.setIdentification(servicer.getIdentification());
    dto.setSchemeName(servicer.getSchemeName());
    return dto;
  }

  public AccountIdentificationDTO convert(AccountIdentification accountId) {
    final AccountIdentificationDTO dto = new AccountIdentificationDTO();
    dto.setIdentification(accountId.getIdentification());
    dto.setName(accountId.getName());
    dto.setSchemeName(accountId.getSchemeName());
    dto.setSecondaryIdentification(accountId.getSecondaryIdentification());
    return dto;
  }
}

