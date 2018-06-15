package ch.raiffeisen.openbank.beneficiary.service.api;

import java.util.HashSet;
import java.util.Set;

import ch.raiffeisen.openbank.common.repository.model.AddressType;

public class PostalAddressDTO {

  private AddressType addressType;
  private String department;
  private String subDepartment;
  private String streetName;
  private String buildingNumber;
  private String postCode;
  private String townName;
  private String countrySubDivision;
  private String country;
  private Set<String> addressLines = new HashSet<>();

  public AddressType getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getSubDepartment() {
    return subDepartment;
  }

  public void setSubDepartment(String subDepartment) {
    this.subDepartment = subDepartment;
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

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
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

  public Set<String> getAddressLines() {
    return addressLines;
  }

  public void setAddressLines(Set<String> addressLines) {
    this.addressLines = addressLines;
  }

}
