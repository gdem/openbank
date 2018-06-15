package ch.raiffeisen.openbank.beneficiary.controller.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.common.repository.model.AddressType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Information that locates and identifies a specific address, as defined by postal services.")
@Relation(value = "postalAddress", collectionRelation = "postalAddresses")
public class PostalAddress {

  @ApiModelProperty(notes = "Identifies the nature of the postal address.")
  private AddressType addressType;

  @ApiModelProperty(notes = "Identification of a division of a large organisation or building.")
  private String department;

  @ApiModelProperty(notes = "Identification of a sub-division of a large organisation or building.")
  private String subDepartment;

  @ApiModelProperty(notes = "Name of a street or thoroughfare.")
  private String streetName;

  @ApiModelProperty(notes = "Number that identifies the position of a building on a street.")
  private String buildingNumber;

  @ApiModelProperty(notes = "Identifier consisting of a group of letters and/or numbers that is added to a postal address to assist the sorting of mail.")
  private String postCode;

  @ApiModelProperty(notes = "Name of a built-up area, with defined boundaries, and a local government.")
  private String townName;

  @ApiModelProperty(notes = "Identifies a subdivision of a country such as state, region, county.")
  private String countrySubDivision;

  @ApiModelProperty(notes = "Nation with its own government.")
  private String country;

  @ApiModelProperty(notes = "Information that locates and identifies a specific address, as defined by postal services, presented in free format text.")
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
