package ch.raiffeisen.openbank.branch.controller.api;

public class PhoneInfo {

  private String phone;
  private String alternatePhone;
  private String alternatePhoneDescription;
  private String faxNumber;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAlternatePhone() {
    return alternatePhone;
  }

  public void setAlternatePhone(String alternatePhone) {
    this.alternatePhone = alternatePhone;
  }

  public String getAlternatePhoneDescription() {
    return alternatePhoneDescription;
  }

  public void setAlternatePhoneDescription(String alternatePhoneDescription) {
    this.alternatePhoneDescription = alternatePhoneDescription;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }
}
