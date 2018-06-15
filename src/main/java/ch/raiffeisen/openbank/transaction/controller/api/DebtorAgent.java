package ch.raiffeisen.openbank.transaction.controller.api;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Financial institution servicing an account for the debtor.")
public class DebtorAgent {

  @ApiModelProperty(notes = "Name of the identification scheme, in a coded form as published in an external list.")
  private ExternalFinancialInstitutionIdentificationCode schemeName;

  @ApiModelProperty(notes = "Unique and unambiguous identification of a financial institution or a branch of a financial institution.")
  private String identification;

  public ExternalFinancialInstitutionIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalFinancialInstitutionIdentificationCode schemeName) {
    this.schemeName = schemeName;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }
}
