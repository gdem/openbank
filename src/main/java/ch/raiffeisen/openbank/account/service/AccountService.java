package ch.raiffeisen.openbank.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.account.persistency.AccountRepository;
import ch.raiffeisen.openbank.account.persistency.model.Account;
import ch.raiffeisen.openbank.account.persistency.model.Servicer;
import ch.raiffeisen.openbank.account.service.api.AccountDTO;
import ch.raiffeisen.openbank.account.service.api.AccountIdentificationDTO;

/**
 * This class represents the account service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class AccountService {

  @Inject
  private AccountRepository accountRepository;

  @Inject
  private AccountMapper accountMapper;

  public Page<AccountDTO> findAll(Pageable pageable) {
    return accountRepository.findAll(pageable).map(this::map);
  }

  public Optional<AccountDTO> findById(String accountId) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    Optional<Account> maybeAccount = accountRepository.findById(accountId);
    return maybeAccount.isPresent() ? Optional.ofNullable(map(maybeAccount.get())) : Optional.empty();
  }

  private AccountDTO map(Account account) {
    final AccountDTO dto = accountMapper.convert(account);

    List<AccountIdentificationDTO> accIds = new ArrayList<>();
    account.getAccountIdentifications().forEach(accountId -> accIds.add(accountMapper.convert(accountId)));

    if (!accIds.isEmpty()) {
      dto.setAccountIdentifications(accIds);
    }

    Servicer servicer = account.getServicer();
    if (servicer != null) {
      dto.setServicer(accountMapper.convert(servicer));
    }
    return dto;
  }
}
