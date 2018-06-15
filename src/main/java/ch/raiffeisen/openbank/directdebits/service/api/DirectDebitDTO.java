package ch.raiffeisen.openbank.directdebits.service.api;

import java.util.Date;

import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.directdebits.repository.model.DirectDebitStatusCode;

public class DirectDebitDTO {
  private Long id;
  private String directDebitId;
  private String accountId;
  private String mandateIdentification;
  private DirectDebitStatusCode directDebitStatusCode;
  private String name;
  private Date previousPaymentDateTime;
  private AmountDTO previousPaymentAmount;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDirectDebitId() {
    return directDebitId;
  }

  public void setDirectDebitId(String directDebitId) {
    this.directDebitId = directDebitId;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getMandateIdentification() {
    return mandateIdentification;
  }

  public void setMandateIdentification(String mandateIdentification) {
    this.mandateIdentification = mandateIdentification;
  }

  public DirectDebitStatusCode getDirectDebitStatusCode() {
    return directDebitStatusCode;
  }

  public void setDirectDebitStatusCode(DirectDebitStatusCode directDebitStatusCode) {
    this.directDebitStatusCode = directDebitStatusCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPreviousPaymentDateTime() {
    return previousPaymentDateTime;
  }

  public void setPreviousPaymentDateTime(Date previousPaymentDateTime) {
    this.previousPaymentDateTime = previousPaymentDateTime;
  }

  public AmountDTO getPreviousPaymentAmount() {
    return previousPaymentAmount;
  }

  public void setPreviousPaymentAmount(AmountDTO previousPaymentAmount) {
    this.previousPaymentAmount = previousPaymentAmount;
  }
}
