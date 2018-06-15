package ch.raiffeisen.openbank.party.persistency.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This entity represents the party information linked to a specific account.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "PARTY")
public class Party {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no
   * meaning to the account owner.
   */
  @Column(name = "ACCOUNT_ID", length = 40)
  private String accountId;

  /**
   * A unique and immutable identifier used to identify the customer resource. This identifier has
   * no meaning to the account owner.
   */
  @Column(name = "PARTY_ID", unique = true, length = 40)
  private String partyId;

  /**
   * Number assigned by an agent to identify its customer.
   */
  @Column(name = "PARTY_NUMBER", nullable = true, length = 35)
  private String partyNumber;

  /**
   * Party type, in a coded form.
   */
  @Column(name = "PARTY_TYPE", nullable = true)
  @Enumerated(EnumType.STRING)
  private PartyType partyType;

  /**
   * Name by which a party is known and which is usually used to identify that party.
   */
  @Column(name = "NAME", nullable = true, length = 70)
  private String name;

  /**
   * Address for electronic mail (e-mail).
   */
  @Column(name = "EMAIL", nullable = true, length = 256)
  private String emailAddress;

  /**
   * Collection of information that identifies a phone number, as defined by telecom services.
   * Pattern: \+[0-9]{1,3}-[0-9()+\-]{1,30}
   */
  @Column(name = "PHONE", nullable = true, length = 30)
  private String phone;

  /**
   * Collection of information that identifies a mobile phone number, as defined by telecom
   * services. * Pattern: \+[0-9]{1,3}-[0-9()+\-]{1,30}
   */
  @Column(name = "MOBILE", nullable = true, length = 30)
  private String mobile;

  /**
   * Postal address of a party.
   */
  @Embedded
  private Address address;

  protected Party() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getPartyId() {
    return partyId;
  }

  public void setPartyId(String partyId) {
    this.partyId = partyId;
  }

  public String getPartyNumber() {
    return partyNumber;
  }

  public void setPartyNumber(String partyNumber) {
    this.partyNumber = partyNumber;
  }

  public PartyType getPartyType() {
    return partyType;
  }

  public void setPartyType(PartyType partyType) {
    this.partyType = partyType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
