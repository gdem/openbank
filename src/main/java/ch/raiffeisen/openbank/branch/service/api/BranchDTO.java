package ch.raiffeisen.openbank.branch.service.api;

import java.util.Collection;

import ch.raiffeisen.openbank.branch.persistency.model.Accessibility;
import ch.raiffeisen.openbank.branch.persistency.model.BranchType;
import ch.raiffeisen.openbank.branch.persistency.model.CustomerSegment;
import ch.raiffeisen.openbank.branch.persistency.model.ServiceAndFacility;

public class BranchDTO {
  private String identification;
  private String sequenceNumber;
  private String name;
  private BranchType branchType;
  private String photo;
  private Collection<CustomerSegment> customerSegments;
  private Collection<ServiceAndFacility> serviceAndFacilities;
  private Collection<Accessibility> accessibilities;
  private String note;
  private PostalAddressDTO postalAddress;
  private GeoLocationDTO geoLocation;
  private PhoneInfoDTO phoneInfo;

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public String getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(String sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BranchType getBranchType() {
    return branchType;
  }

  public void setBranchType(BranchType branchType) {
    this.branchType = branchType;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Collection<CustomerSegment> getCustomerSegments() {
    return customerSegments;
  }

  public void setCustomerSegments(Collection<CustomerSegment> customerSegments) {
    this.customerSegments = customerSegments;
  }

  public Collection<ServiceAndFacility> getServiceAndFacilities() {
    return serviceAndFacilities;
  }

  public void setServiceAndFacilities(Collection<ServiceAndFacility> serviceAndFacilities) {
    this.serviceAndFacilities = serviceAndFacilities;
  }

  public Collection<Accessibility> getAccessibilities() {
    return accessibilities;
  }

  public void setAccessibilities(Collection<Accessibility> accessibilities) {
    this.accessibilities = accessibilities;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public PostalAddressDTO getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(PostalAddressDTO postalAddress) {
    this.postalAddress = postalAddress;
  }

  public GeoLocationDTO getGeoLocation() {
    return geoLocation;
  }

  public void setGeoLocation(GeoLocationDTO geoLocation) {
    this.geoLocation = geoLocation;
  }

  public PhoneInfoDTO getPhoneInfo() {
    return phoneInfo;
  }

  public void setPhoneInfo(PhoneInfoDTO phoneInfo) {
    this.phoneInfo = phoneInfo;
  }
}
