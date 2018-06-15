package ch.raiffeisen.openbank.branch.persistency.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Geographic location of the ATM specified by geographic coordinates or UTM coordinates.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BRANCH_GEO_LOCATION")
public class GeoLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Embedded
  private GeographicCoordinates geographicCoordinates;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GeographicCoordinates getGeographicCoordinates() {
    return geographicCoordinates;
  }

  public void setGeographicCoordinates(GeographicCoordinates geographicCoordinates) {
    this.geographicCoordinates = geographicCoordinates;
  }
}
