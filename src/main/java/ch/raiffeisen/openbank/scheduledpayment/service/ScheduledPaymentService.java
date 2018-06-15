package ch.raiffeisen.openbank.scheduledpayment.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.scheduledpayment.persistency.ScheduledPaymentRepository;
import ch.raiffeisen.openbank.scheduledpayment.service.api.ScheduledPaymentDTO;

/**
 * This class represents the scheduled payment service.
 * 
 * @author Timur Tokoev
 */
@Service
public class ScheduledPaymentService {

  @Inject
  private ScheduledPaymentRepository scheduledPaymentRepository;

  @Inject
  private ScheduledPaymentMapper scheduledPaymentMapper;

  public Page<ScheduledPaymentDTO> findAll(Pageable pageable) {
    return scheduledPaymentRepository.findAll(pageable).map(scheduledPaymentMapper::convert);
  }

  public Page<ScheduledPaymentDTO> findByAccountId(String accountId, Pageable pageable) {
    Objects.requireNonNull(accountId, "accountId must not be null");
    return scheduledPaymentRepository.findByAccountId(accountId, pageable).map(scheduledPaymentMapper::convert);
  }
}

