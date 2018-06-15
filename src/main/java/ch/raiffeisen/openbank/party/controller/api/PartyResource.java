package ch.raiffeisen.openbank.party.controller.api;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.party.persistency.model.PartyType;

@Relation(value = "party", collectionRelation = "parties")
public class PartyResource extends ResourceSupport {
  private String accountId;
  private String partyId;
  private String partyNumber;
  private PartyType partyType;
  private String name;
  private String emailAddress;
  private String phone;
  private String mobile;
  private Address address;

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
