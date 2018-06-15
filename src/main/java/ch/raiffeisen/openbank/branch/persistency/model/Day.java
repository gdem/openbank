package ch.raiffeisen.openbank.branch.persistency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Working day information
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BRANCH_WORKING_DAY")
public class Day {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Specifies the day of the week
   */
  @Column(name = "NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private Weekday name;

  /**
   * Specify any note that is related the particular opening day e.g. Closed half day on Monday
   */
  @Column(name = "NOTE", nullable = true, length = 2000)
  private String note;

  @OneToMany(mappedBy = "day")
  private List<OpeningHours> openingHours = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BRANCH_ID")
  private Branch branch;


  protected Day() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Weekday getName() {
    return name;
  }

  public void setName(Weekday name) {
    this.name = name;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public List<OpeningHours> getOpeningHours() {
    return openingHours;
  }

  public void setOpeningHours(List<OpeningHours> openingHours) {
    this.openingHours = openingHours;
  }

  public Branch getBranch() {
    return branch;
  }

  public void setBranch(Branch branch) {
    this.branch = branch;
  }
}
