package ch.raiffeisen.openbank.branch.persistency.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Opening & Closing Times of a branch of an organisation.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BRANCH_OPENING_HOURS")
public class OpeningHours {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * "A particular point in the progression of time in a calendar day expressed in either UTC time
   * format (hh:mm:ss.sssZ), local time with UTC offset format (hh:mm:ss.sss+/-hh:mm), or local time
   * format (hh:mm:ss.sss). These representations are defined in ""XML Schema Part 2: Datatypes
   * Second Edition - W3C Recommendation 28 October 2004"" which is aligned with ISO 8601. Note on
   * the time format: 1) beginning / end of calendar day 00:00:00 = the beginning of a calendar day
   * 24:00:00 = the end of a calendar day 2) fractions of second in time format Decimal fractions of
   * seconds may be included. In this case, the involved parties shall agree on the maximum number
   * of digits that are allowed."
   */
  @Temporal(TemporalType.TIME)
  @Column(name = "OPENING_TIME", nullable = false)
  private Date openingTime;

  /**
   * "A particular point in the progression of time in a calendar day expressed in either UTC time
   * format (hh:mm:ss.sssZ), local time with UTC offset format (hh:mm:ss.sss+/-hh:mm), or local time
   * format (hh:mm:ss.sss). These representations are defined in ""XML Schema Part 2: Datatypes
   * Second Edition - W3C Recommendation 28 October 2004"" which is aligned with ISO 8601. Note on
   * the time format: 1) beginning / end of calendar day 00:00:00 = the beginning of a calendar day
   * 24:00:00 = the end of a calendar day 2) fractions of second in time format Decimal fractions of
   * seconds may be included. In this case, the involved parties shall agree on the maximum number
   * of digits that are allowed."
   */
  @Temporal(TemporalType.TIME)
  @Column(name = "CLOSING_TIME", nullable = false)
  private Date closingTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DAY_ID")
  private Day day;

  protected OpeningHours() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getOpeningTime() {
    return openingTime;
  }

  public void setOpeningTime(Date openingTime) {
    this.openingTime = openingTime;
  }

  public Date getClosingTime() {
    return closingTime;
  }

  public void setClosingTime(Date closingTime) {
    this.closingTime = closingTime;
  }

  public Day getDay() {
    return day;
  }

  public void setDay(Day day) {
    this.day = day;
  }

}
