package ch.raiffeisen.openbank.branch.persistency.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 * Information that locates and identifies a specific address, as defined by postal services.
 * 
 * @author Goekhan Demirkiyik
 */
@Embeddable
public class PostalAddress {

  /**
   * Information that locates and identifies a specific address, as defined by postal services, that
   * is presented in free format text.
   */
  @ElementCollection
  @CollectionTable(name = "BRANCH_POSTALADDRESS_ADDRESS_LINES", joinColumns = {@JoinColumn(name = "BRANCH_ID")})
  protected Set<String> addressLines = new HashSet<>();

  /**
   * Name or Number that identifies the position of a building on a street.
   */
  @Column(name = "BUILDING_NUMBER", nullable = true, length = 350)
  private String buildingNumber;

  /**
   * Name of a street or thoroughfare.
   */
  @Column(name = "STREET_NAME", nullable = true, length = 70)
  private String streetName;

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
   * Identifier consisting of a group of letters and/or numbers that is added to a postal address to
   * assist the sorting of mail.
   */
  @Column(name = "POST_CODE", nullable = true, length = 16)
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
