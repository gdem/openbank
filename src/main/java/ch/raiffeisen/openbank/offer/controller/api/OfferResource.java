package ch.raiffeisen.openbank.offer.controller.api;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.controller.api.Fee;
import ch.raiffeisen.openbank.offer.persistency.model.OfferType;

@Relation(value = "offer", collectionRelation = "offers")
public class OfferResource extends ResourceSupport {

  private String accountId;
  private String offerId;
  private OfferType offerType;
  private String description;
  private Date startDateTime;
  private Date endDateTime;
  private Amount amount;
  private Fee fee;
  private String rate;
  private String term;
  private String url;

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
