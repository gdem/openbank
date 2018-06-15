package ch.raiffeisen.openbank.party.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.party.persistency.model.Party;

/**
 * This interface represents the party repository to get the party information from the
 * database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface PartyRepository extends PagingAndSortingRepository<Party, Long> {

  Page<Party> findByAccountId(String accountId, Pageable pageable);
}

