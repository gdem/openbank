package ch.raiffeisen.openbank.beneficiary.service.api;

/**
 * The beneficiary transport object
 * 
 * @author Timur Tokoev
 */
public class BeneficiaryDTO {

  private String accountId;
  private String beneficiaryId;
  private String reference;
  private CreditorAgentDTO creditorAgent;
  private CreditorAccountDTO creditorAccount;


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getBeneficiaryId() {
    return beneficiaryId;
  }

  public void setBeneficiaryId(String beneficiaryId) {
    this.beneficiaryId = beneficiaryId;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public CreditorAgentDTO getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(CreditorAgentDTO creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public CreditorAccountDTO getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccountDTO creditorAccount) {
    this.creditorAccount = creditorAccount;
  }


}
