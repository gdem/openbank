package ch.raiffeisen.openbank.offer.service.api;

import java.util.Date;

import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.common.service.api.FeeDTO;
import ch.raiffeisen.openbank.offer.persistency.model.OfferType;

public class OfferDTO {

  private Long id;
  private String accountId;
  private String offerId;
  private OfferType offerType;
  private String description;
  private Date startDateTime;
  private Date endDateTime;
  private AmountDTO amount;
  private FeeDTO fee;
  private String rate;
  private String term;
  private String url;

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

  public AmountDTO getAmount() {
    return amount;
  }

  public void setAmount(AmountDTO amount) {
    this.amount = amount;
  }

  public FeeDTO getFee() {
    return fee;
  }

  public void setFee(FeeDTO fee) {
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
