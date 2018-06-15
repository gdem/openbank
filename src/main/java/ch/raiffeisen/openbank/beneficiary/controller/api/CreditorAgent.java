package ch.raiffeisen.openbank.beneficiary.controller.api;

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

  @ApiModelProperty(notes = "Name by which an agent is known and which is usually used to identify that agent")
  private String name;

  private PostalAddress postalAddress;


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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PostalAddress getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(PostalAddress postalAddress) {
    this.postalAddress = postalAddress;
  }

}
