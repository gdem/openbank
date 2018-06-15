package ch.raiffeisen.openbank.branch.persistency.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Geographic location of the ATM specified by geographic coordinates or UTM coordinates.
 * 
 * @author Goekhan Demirkiyik
 */
@Embeddable
public class GeographicCoordinates {

  /**
   * Latitude measured in decimal degrees.
   */
  @Column(name = "LATITUDE", nullable = false)
  private Double latitude;

  /**
   * "Angular measurement of the distance of a location on the earth east or west of the Greenwich
   * observatory. The longitude is measured in decimal degrees."
   */
  @Column(name = "LONGITUDE", nullable = false)
  private Double longitude;

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }
}
