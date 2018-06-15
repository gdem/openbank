package ch.raiffeisen.openbank.transaction.service.api;

import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;

public class CreditorAccountDTO {

  private Long id;
  private ExternalAccountIdentificationCode schemeName;
  private String identification;
  private String name;
  private String secondaryIdentification;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
}
