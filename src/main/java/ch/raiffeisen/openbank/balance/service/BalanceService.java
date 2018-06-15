package ch.raiffeisen.openbank.balance.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.balance.persistency.BalanceRepository;
import ch.raiffeisen.openbank.balance.service.api.BalanceDTO;

/**
 * This class represents the balance service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class BalanceService {

  @Inject
  private BalanceRepository balanceRepository;

  @Inject
  private BalanceMapper balanceMapper;

  public Page<BalanceDTO> findAll(Pageable pageable) {
    return balanceRepository.findAll(pageable).map(balanceMapper::convert);
  }

  public Page<BalanceDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return balanceRepository.findByAccountId(accountId, pageable).map(balanceMapper::convert);
  }
}

