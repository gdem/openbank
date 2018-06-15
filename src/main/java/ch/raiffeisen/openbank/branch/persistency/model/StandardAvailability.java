package ch.raiffeisen.openbank.branch.persistency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

/**
 * Standard hours of availability for the branch of the organisation
 * 
 * @author Goekhan Demirkiyik
 */
@Embeddable
public class StandardAvailability {

  @OneToMany(mappedBy = "branch")
  private List<Day> days = new ArrayList<>();

  public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }
}
