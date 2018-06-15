package ch.raiffeisen.openbank.scheduledpayment.controller.api;

import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Relation(value = "creditorAgent", collectionRelation = "creditorAgents")
@ApiModel(
    description = " Party that manages the account on behalf of the account owner, that is manages the registration and booking of entries on the account, calculates balances on the account and provides information about the account. This is the servicer of the beneficiary account.")
public class CreditorAgent {

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private String identification;

  @ApiModelProperty(notes = "Name of the identification scheme, in a coded form as published in an external list.")
  private ExternalFinancialInstitutionIdentificationCode schemeName;

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public ExternalFinancialInstitutionIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalFinancialInstitutionIdentificationCode schemeName) {
    this.schemeName = schemeName;
  }
}
