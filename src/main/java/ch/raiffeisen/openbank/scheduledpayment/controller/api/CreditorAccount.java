package ch.raiffeisen.openbank.scheduledpayment.controller.api;

import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.beneficiary.persistency.model.Beneficiary;
import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Relation(value = "creditorAccount", collectionRelation = "creditorAccounts")
@ApiModel(description = "Provides the details to identify the beneficiary account.")
public class CreditorAccount {

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private ExternalAccountIdentificationCode schemeName;

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private String identification;

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private String name;

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private String secondaryIdentification;

  @ApiModelProperty(notes = "Unique and unambiguous identification of the servicing institution.")
  private Beneficiary beneficiary;

  public ExternalAccountIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalAccountIdentificationCode schemeName) {
    this.schemeName = schemeName;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSecondaryIdentification() {
    return secondaryIdentification;
  }

  public void setSecondaryIdentification(String secondaryIdentification) {
    this.secondaryIdentification = secondaryIdentification;
  }

  public Beneficiary getBeneficiary() {
    return beneficiary;
  }

  public void setBeneficiary(Beneficiary beneficiary) {
    this.beneficiary = beneficiary;
  }

}
