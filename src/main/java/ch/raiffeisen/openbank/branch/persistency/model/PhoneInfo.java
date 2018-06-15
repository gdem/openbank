package ch.raiffeisen.openbank.branch.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Communication device number or electronic address used for communication.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BRANCH_PHONE_INFO")
public class PhoneInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Collection of information that identifies a phone number, as defined by telecom services.
   */
  @Column(name = "PHONE", nullable = true, length = 30)
  private String phone;

  /**
   * Collection of information that identifies a phone number, as defined by telecom services.
   */
  @Column(name = "ALTERNATE_PHONE", nullable = true, length = 30)
  private String alternatePhone;

  /**
   * Description of an alternate phone number - Max 75 characters
   */
  @Column(name = "ALTERNATE_PHONE_DESCRIPTION", nullable = true, length = 70)
  private String alternatePhoneDescription;

  /**
   * 
   * Collection of information that identifies a FAX number, as defined by telecom services.
   */
  @Column(name = "FAX_NUMBER", nullable = true, length = 30)
  private String faxNumber;

  protected PhoneInfo() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
