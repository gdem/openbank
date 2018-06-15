package ch.raiffeisen.openbank.party.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.party.persistency.PartyRepository;
import ch.raiffeisen.openbank.party.service.api.PartyDTO;

/**
 * This class represents the offer service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class PartyService {

  @Inject
  private PartyRepository partyRepository;

  @Inject
  private PartyMapper partyMapper;

  public Page<PartyDTO> findAll(Pageable pageable) {
    return partyRepository.findAll(pageable).map(partyMapper::convert);
  }

  public Page<PartyDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return partyRepository.findByAccountId(accountId, pageable).map(partyMapper::convert);
  }
}

