package ch.raiffeisen.openbank.offer.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.offer.persistency.OfferRepository;
import ch.raiffeisen.openbank.offer.service.api.OfferDTO;

/**
 * This class represents the offer service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class OfferService {

  @Inject
  private OfferRepository offerRepository;

  @Inject
  private OfferMapper offerMapper;

  public Page<OfferDTO> findAll(Pageable pageable) {
    return offerRepository.findAll(pageable).map(offerMapper::convert);
  }

  public Page<OfferDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return offerRepository.findByAccountId(accountId, pageable).map(offerMapper::convert);
  }
}

