package ch.raiffeisen.openbank.beneficiary.service.api;

import ch.raiffeisen.openbank.beneficiary.persistency.model.Beneficiary;
import ch.raiffeisen.openbank.common.repository.model.ExternalAccountIdentificationCode;

/**
 * The CreditorAccount transport object
 * 
 * @author Timur Tokoev
 * 
 */
public class CreditorAccountDTO {

  private ExternalAccountIdentificationCode schemeName;
  private String identification;
  private String name;
  private String secondaryIdentification;
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
