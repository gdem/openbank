package ch.raiffeisen.openbank.account.service.api;

import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;

public class AccountIdentificationDTO {

  private String identification;
  private ExternalAccountIdentificationCode schemeName;
  private String name;
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
