package ch.raiffeisen.openbank.balance.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.balance.persistency.model.Balance;

/**
 * This interface represents the account repository to get the account information from the
 * database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface BalanceRepository extends PagingAndSortingRepository<Balance, Long> {

  Page<Balance> findByAccountId(String accountId, Pageable pageable);
}

