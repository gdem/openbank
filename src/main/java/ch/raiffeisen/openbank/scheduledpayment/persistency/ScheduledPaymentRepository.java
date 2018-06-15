package ch.raiffeisen.openbank.scheduledpayment.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.scheduledpayment.persistency.model.ScheduledPayment;

/**
 * This interface represents the scheduled payment repository to get the scheduled payment
 * information from the database.
 * 
 * @author Timur Tokoev
 */
@Repository
public interface ScheduledPaymentRepository extends PagingAndSortingRepository<ScheduledPayment, Long> {

  Page<ScheduledPayment> findByAccountId(String accountId, Pageable pageable);
}

