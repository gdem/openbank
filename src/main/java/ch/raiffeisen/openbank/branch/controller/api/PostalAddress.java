package ch.raiffeisen.openbank.branch.controller.api;

import java.util.HashSet;
import java.util.Set;

public class PostalAddress {

  private Set<String> addressLines = new HashSet<>();
  private String buildingNumber;
  private String streetName;
  private String townName;
  private String countrySubDivision;
  private String country;
  private String postCode;

  public Set<String> getAddressLines() {
    return addressLines;
  }

  public void setAddressLines(Set<String> addressLines) {
    this.addressLines = addressLines;
  }

  public String getBuildingNumber() {
    return buildingNumber;
  }

  public void setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public String getCountrySubDivision() {
    return countrySubDivision;
  }

  public void setCountrySubDivision(String countrySubDivision) {
    this.countrySubDivision = countrySubDivision;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
}
