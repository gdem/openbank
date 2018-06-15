package ch.raiffeisen.openbank.scheduledpayment.controller.api;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.scheduledpayment.persistency.model.ExternalScheduleTypeCode;

@Relation(value = "scheduledPayment", collectionRelation = "scheduledPayments")
public class ScheduledPaymentResource extends ResourceSupport {

  private String accountId;
  private String scheduledPaymentId;
  private Date scheduledPaymentDateTime;
  private ExternalScheduleTypeCode scheduledType;
  private AmountDTO instructedAmount;
  private String reference;
  private CreditorAgent creditorAgent;
  private CreditorAccount creditorAccount;


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getScheduledPaymentId() {
    return scheduledPaymentId;
  }

  public void setScheduledPaymentId(String scheduledPaymentId) {
    this.scheduledPaymentId = scheduledPaymentId;
  }

  public Date getScheduledPaymentDateTime() {
    return scheduledPaymentDateTime;
  }

  public void setScheduledPaymentDateTime(Date scheduledPaymentDateTime) {
    this.scheduledPaymentDateTime = scheduledPaymentDateTime;
  }

  public ExternalScheduleTypeCode getScheduledType() {
    return scheduledType;
  }

  public void setScheduledType(ExternalScheduleTypeCode scheduledType) {
    this.scheduledType = scheduledType;
  }

  public AmountDTO getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(AmountDTO instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public CreditorAgent getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(CreditorAgent creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public CreditorAccount getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

}
