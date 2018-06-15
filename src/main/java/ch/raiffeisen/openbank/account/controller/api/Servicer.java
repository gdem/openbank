package ch.raiffeisen.openbank.account.controller.api;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
    description = "Party that manages the account on behalf of the account owner, that is manages the registration and booking of entries on the account, calculates balances on the account and provides information about the account.")
public class Servicer {

  @ApiModelProperty(notes = "Name of the identification scheme, in a coded form as published in an external list.")
  private String identification;

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private ExternalFinancialInstitutionIdentificationCode schemaName;

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public ExternalFinancialInstitutionIdentificationCode getSchemaName() {
    return schemaName;
  }

  public void setSchemaName(ExternalFinancialInstitutionIdentificationCode schemaName) {
    this.schemaName = schemaName;
  }
}
