package ch.raiffeisen.openbank.branch.service;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.raiffeisen.openbank.branch.persistency.BranchRepository;
import ch.raiffeisen.openbank.branch.service.api.BranchDTO;

/**
 * This class represents the branch service.
 * 
 * @author Goekhan Demirkiyik
 */
@Service
public class BranchService {

  @Inject
  private BranchRepository branchRepository;

  @Inject
  private BranchMapper branchMapper;

  public Page<BranchDTO> findAll(Pageable pageable) {
    return branchRepository.findAll(pageable).map(branch -> {
      final BranchDTO branchDTO = branchMapper.convert(branch);
      branchDTO.setGeoLocation(branchMapper.convert(branch.getGeoLocation()));
      branchDTO.setPhoneInfo(branchMapper.convert(branch.getPhoneInfo()));
      return branchDTO;
    });
  }
}

