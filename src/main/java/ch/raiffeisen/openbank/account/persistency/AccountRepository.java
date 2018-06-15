package ch.raiffeisen.openbank.account.persistency;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.account.persistency.model.Account;

/**
 * This interface represents the account repository to get the account information from the
 * database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {
  // intentionally empty
}

