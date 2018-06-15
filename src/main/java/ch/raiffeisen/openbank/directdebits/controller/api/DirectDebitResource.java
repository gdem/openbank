package ch.raiffeisen.openbank.directdebits.controller.api;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.directdebits.repository.model.DirectDebitStatusCode;

@Relation(value = "direct-debit", collectionRelation = "direct-debits")
public class DirectDebitResource extends ResourceSupport {

  private String directDebitId;
  private String accountId;
  private String mandateIdentification;
  private DirectDebitStatusCode directDebitStatusCode;
  private String name;
  private Date previousPaymentDateTime;
  private Amount previousPaymentAmount;

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

  public Amount getPreviousPaymentAmount() {
    return previousPaymentAmount;
  }

  public void setPreviousPaymentAmount(Amount previousPaymentAmount) {
    this.previousPaymentAmount = previousPaymentAmount;
  }


}
