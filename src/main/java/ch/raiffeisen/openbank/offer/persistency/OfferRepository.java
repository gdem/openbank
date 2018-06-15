package ch.raiffeisen.openbank.offer.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.offer.persistency.model.Offer;

/**
 * This interface represents the account repository to get the offer information from the
 * database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface OfferRepository extends PagingAndSortingRepository<Offer, Long> {

  Page<Offer> findByAccountId(String accountId, Pageable pageable);
}

