package ch.raiffeisen.openbank.beneficiary.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.beneficiary.persistency.BeneficiaryRepository;
import ch.raiffeisen.openbank.beneficiary.service.api.BeneficiaryDTO;

/**
 * This class represents the beneficiary service.
 * 
 * @author Timur Tokoev
 */
@Service
public class BeneficiaryService {

  @Inject
  private BeneficiaryRepository beneficiaryRepository;

  @Inject
  private BeneficiaryMapper beneficiaryMapper;

  public Page<BeneficiaryDTO> findAll(Pageable pageable) {
    return beneficiaryRepository.findAll(pageable).map(beneficiaryMapper::convert);
  }

  public Page<BeneficiaryDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return beneficiaryRepository.findByAccountId(accountId, pageable).map(beneficiaryMapper::convert);
  }
}

