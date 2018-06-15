package ch.raiffeisen.openbank.branch.controller.api;

public class GeoLocation {

  private GeographicCoordinates geographicCoordinates;

  public GeoLocation() {}

  public GeoLocation(Double latitude, Double longitude) {
    this.geographicCoordinates = new GeographicCoordinates();
    this.geographicCoordinates.setLatitude(latitude);
    this.geographicCoordinates.setLongitude(longitude);
  }


  public GeographicCoordinates getGeographicCoordinates() {
    return geographicCoordinates;
  }

  public void setGeographicCoordinates(GeographicCoordinates geographicCoordinates) {
    this.geographicCoordinates = geographicCoordinates;
  }

  public static class GeographicCoordinates {
    private Double latitude;
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
}
