package ch.raiffeisen.openbank.account.controller.api;

import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = " Provides the details to identify an account.")
public class AccountIdentification {

  @ApiModelProperty(notes = "Name of the identification scheme, in a coded form as published in an external list.")
  private ExternalAccountIdentificationCode schemeName;

  @ApiModelProperty(notes = "Identification assigned by an institution to identify an account. This identification is known by the account owner.")
  private String identification;

  @ApiModelProperty(
      notes = "Name of the account, as assigned by the account servicing institution, in agreement with the account owner in order to provide an additional means of identification of the account. Usage: The account name is different from the account owner name. The account name is used in certain user communities to provide a means of identifying the account, in addition to the account owner's identity and the account number.")
  private String name;

  @ApiModelProperty(
      notes = "This is secondary identification of the account, as assigned by the account servicing institution. This can be used by building societies to additionally identify accounts with a roll number (in addition to a sort code and account number combination).")
  private String secondaryIdentification;

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public ExternalAccountIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalAccountIdentificationCode schemeName) {
    this.schemeName = schemeName;
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
}
