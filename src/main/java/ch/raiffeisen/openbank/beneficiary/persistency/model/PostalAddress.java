package ch.raiffeisen.openbank.beneficiary.persistency.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

import ch.raiffeisen.openbank.common.repository.model.AddressType;

/**
 * Information that locates and identifies a specific address, as defined by postal services.
 * 
 * @author Goekhan Demirkiyik
 */
@Embeddable
public class PostalAddress {

  /**
   * Identifies the nature of the postal address.
   */
  @Column(name = "ADDRESS_TYPE", nullable = true)
  @Enumerated(EnumType.STRING)
  private AddressType addressType;

  /**
   * Identification of a division of a large organisation or building.
   */
  @Column(name = "DEPARTMENT", nullable = true, length = 70)
  private String department;

  /**
   * Identification of a sub-division of a large organisation or building.
   */
  @Column(name = "SUB_DEPARTMENT", nullable = true, length = 70)
  private String subDepartment;

  /**
   * Name of a street or thoroughfare.
   */
  @Column(name = "STREET_NAME", nullable = true, length = 70)
  private String streetName;

  /**
   * Name or Number that identifies the position of a building on a street.
   */
  @Column(name = "BUILDING_NUMBER", nullable = true, length = 350)
  private String buildingNumber;

  /**
   * Identifier consisting of a group of letters and/or numbers that is added to a postal address to
   * assist the sorting of mail.
   */
  @Column(name = "POST_CODE", nullable = true, length = 16)
  private String postCode;

  /**
   * Name of a built-up area, with defined boundaries, and a local government.
   */
  @Column(name = "TOWN_NAME", nullable = true, length = 35)
  private String townName;

  /**
   * Identifies a subdivision of a country eg, state, region, county.
   */
  @Column(name = "COUNTRY_SUB_DIVISION", nullable = true, length = 35)
  private String countrySubDivision;

  /**
   * Nation with its own government, occupying a particular territory. Pattern: ^[A-Z]{2,2}$
   */
  @Column(name = "COUNTRY", nullable = false, length = 2)
  private String country;


  /**
   * Information that locates and identifies a specific address, as defined by postal services, that
   * is presented in free format text.
   */
  @ElementCollection
  @CollectionTable(name = "BENEFICIARY_ADDRESS_LINES", joinColumns = {@JoinColumn(name = "BENEFICIARY_ID")})
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
