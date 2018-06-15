package ch.raiffeisen.openbank.transaction.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.transaction.persistency.model.Transaction;

/**
 * This interface represents the party repository to get the transaction information from the
 * database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

  Page<Transaction> findByAccountId(String accountId, Pageable pageable);
}

