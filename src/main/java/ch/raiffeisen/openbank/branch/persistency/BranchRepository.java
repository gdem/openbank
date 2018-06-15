package ch.raiffeisen.openbank.branch.persistency;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.raiffeisen.openbank.branch.persistency.model.Branch;

/**
 * This interface represents the branch repository to get the branch information from the database.
 * 
 * @author Goekhan Demirkiyik
 */
@Repository
public interface BranchRepository extends PagingAndSortingRepository<Branch, String> {
  // intentionally empty
}

