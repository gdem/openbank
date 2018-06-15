package ch.raiffeisen.openbank.directdebits.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.directdebits.repository.model.DirectDebit;

/**
 * This interface represents the account repository to get the account information from the
 * database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface DirectDebitRepository extends PagingAndSortingRepository<DirectDebit, Long> {

  Page<DirectDebit> findByAccountId(String accountId, Pageable pageable);
}

