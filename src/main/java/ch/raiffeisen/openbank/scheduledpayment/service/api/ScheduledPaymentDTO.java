package ch.raiffeisen.openbank.scheduledpayment.service.api;

import java.util.Date;

import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.scheduledpayment.persistency.model.ExternalScheduleTypeCode;


/**
 * Represents the scheduled payment transport object.
 * 
 * @author Timur Tokoev
 */
public class ScheduledPaymentDTO {

  private String accountId;
  private String scheduledPaymentId;
  private Date scheduledPaymentDateTime;
  private ExternalScheduleTypeCode scheduledType;
  private AmountDTO instructedAmount;
  private String reference;
  private CreditorAgentDTO creditorAgent;
  private CreditorAccountDTO creditorAccount;


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

  public CreditorAgentDTO getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(CreditorAgentDTO creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public CreditorAccountDTO getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccountDTO creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

}
