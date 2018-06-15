package ch.raiffeisen.openbank.branch.service.api;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

  private String brandName;
  private List<BranchDTO> branches = new ArrayList<>();

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public List<BranchDTO> getBranches() {
    return branches;
  }

  public void setBranches(List<BranchDTO> branches) {
    this.branches = branches;
  }


}
