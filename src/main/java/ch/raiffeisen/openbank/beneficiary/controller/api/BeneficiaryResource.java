package ch.raiffeisen.openbank.beneficiary.controller.api;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Relation(value = "beneficiary", collectionRelation = "beneficiaries")
@ApiModel(description = "Beneficiary")
public class BeneficiaryResource extends ResourceSupport {

  @ApiModelProperty(notes = "A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.")
  private String accountId;

  @ApiModelProperty(notes = "A unique and immutable identifier used to identify the beneficiary resource. This identifier has no meaning to the account owner.")
  private String beneficiaryId;

  @ApiModelProperty(
      notes = "Unique reference, as assigned by the creditor, to unambiguously refer to the payment transaction. Usage: If available, the initiating party should provide this reference in the structured remittance information, to enable reconciliation by the creditor upon receipt of the amount of money. If the business context requires the use of a creditor reference or a payment remit identification, and only one identifier can be passed through the end-to-end chain, the creditor's reference or payment remittance identification should be quoted in the end-to-end transaction identification.")
  private String reference;

  private CreditorAgent creditorAgent;

  private CreditorAccount creditorAccount;

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getBeneficiaryId() {
    return beneficiaryId;
  }

  public void setBeneficiaryId(String beneficiaryId) {
    this.beneficiaryId = beneficiaryId;
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
