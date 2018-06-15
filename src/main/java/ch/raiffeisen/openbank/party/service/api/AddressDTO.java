package ch.raiffeisen.openbank.party.service.api;

import java.util.HashSet;
import java.util.Set;

import ch.raiffeisen.openbank.common.repository.model.AddressType;

public class AddressDTO {
  private AddressType addressType;
  private Set<String> addressLines = new HashSet<>();
  private String streetName;
  private String buildingNumber;
  private String postalCode;
  private String townName;
  private String countrySubDivision;
  private String country;

  public AddressType getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  public Set<String> getAddressLines() {
    return addressLines;
  }
  
  public void setAddressLines(Set<String> addressLines) {
    this.addressLines = addressLines;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getBuildingNumber() {
    return buildingNumber;
  }

  public void setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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


}
