package ch.raiffeisen.openbank.directdebits.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.directdebits.repository.DirectDebitRepository;
import ch.raiffeisen.openbank.directdebits.service.api.DirectDebitDTO;

/**
 * This class represents the offer service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class DirectDebitService {

  @Inject
  private DirectDebitRepository directDebitRepository;

  @Inject
  private DirectDebitMapper directDebitMapper;

  public Page<DirectDebitDTO> findAll(Pageable pageable) {
    return directDebitRepository.findAll(pageable).map(directDebitMapper::convert);
  }

  public Page<DirectDebitDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return directDebitRepository.findByAccountId(accountId, pageable).map(directDebitMapper::convert);
  }
}

