package ch.raiffeisen.openbank.branch.persistency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This entity represents the brand entity.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BRAND")
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Brand Name that an organisation uses to market its products or services to a consumer.
   */
  @Column(name = "BRAND_NAME", length = 140)
  private String brandName;

  @OneToMany(mappedBy = "brand")
  private List<Branch> branches = new ArrayList<>();

  protected Brand() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public List<Branch> getBranches() {
    return branches;
  }

  public void setBranches(List<Branch> branches) {
    this.branches = branches;
  }
}
