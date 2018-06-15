package ch.raiffeisen.openbank.beneficiary.service.api;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;

/**
 * The CreditorAgent transport object
 * 
 * @author Timur Tokoev
 *
 */
public class CreditorAgentDTO {

  private ExternalFinancialInstitutionIdentificationCode schemeName;
  private String identification;
  private String name;
  private PostalAddressDTO postalAddress;


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

  public PostalAddressDTO getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(PostalAddressDTO postalAddress) {
    this.postalAddress = postalAddress;
  }

}
