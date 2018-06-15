package ch.raiffeisen.openbank.beneficiary.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.beneficiary.persistency.model.Beneficiary;

/**
 * This interface represents the beneficiary repository to get the beneficiary information from the
 * database.
 * 
 * @author Timur Tokoev
 */
@Repository
public interface BeneficiaryRepository extends PagingAndSortingRepository<Beneficiary, Long> {

  Page<Beneficiary> findByAccountId(String accountId, Pageable pageable);
}

