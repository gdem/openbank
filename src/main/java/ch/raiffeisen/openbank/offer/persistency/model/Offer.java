package ch.raiffeisen.openbank.offer.persistency.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.repository.model.Fee;

/**
 * This entity represents the account to which credit and debit entries are made.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "OFFER")
public class Offer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", length = 40)
  private String accountId;

  /**
   * A unique and immutable identifier used to identify the offer resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "OFFER_ID", unique = true)
  private String offerId;

  /**
   * Offer type, in a coded form.
   */
  @Column(name = "OFFER_TYPE", nullable = true)
  @Enumerated(EnumType.STRING)
  private OfferType offerType;

  /**
   * Further details of the offer.
   */
  @Column(name = "DESCRIPTION", nullable = true, length = 500)
  private String description;

  /**
   * Date and time at which the offer starts.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "START_DATETIME", nullable = true)
  private Date startDateTime;

  /**
   * Date and time at which the offer ends.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "END_DATETIME", nullable = true)
  private Date endDateTime;

  /**
   * Amount of money associated with the offer type.
   */
  @Embedded
  //@formatter:off
  @AttributeOverrides({
    @AttributeOverride(name="amount", column=@Column(name="AMOUNT")),
    @AttributeOverride(name="currency", column=@Column(name="AMOUNT_CURRENCY"))
  })
  //@formatter:on
  private Amount amount;

  /**
   * Fee associated with the offer type
   */
  @Embedded
  //@formatter:off
  @AttributeOverrides({
    @AttributeOverride(name="fee", column=@Column(name="FEE")),
    @AttributeOverride(name="currency", column=@Column(name="FEE_CURRENCY"))
  })
  //@formatter:on
  private Fee fee;

  /**
   * Rate associated with the offer type.
   */
  @Column(name = "RATE", nullable = true, length = 10)
  private String rate;

  /**
   * Further details of the offer.
   */
  @Column(name = "TERM", nullable = true, length = 500)
  private String term;

  /**
   * URL (Uniform Resource Locator) where the document can be found
   */
  @Column(name = "URL", nullable = true, length = 256)
  private String url;

  protected Offer() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getOfferId() {
    return offerId;
  }

  public void setOfferId(String offerId) {
    this.offerId = offerId;
  }

  public OfferType getOfferType() {
    return offerType;
  }

  public void setOfferType(OfferType offerType) {
    this.offerType = offerType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public Fee getFee() {
    return fee;
  }

  public void setFee(Fee fee) {
    this.fee = fee;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


}
