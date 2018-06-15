package ch.raiffeisen.openbank.scheduledpayment.service.api;

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
