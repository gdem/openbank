package ch.raiffeisen.openbank.branch.controller.api;

import java.util.Collection;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import ch.raiffeisen.openbank.branch.persistency.model.Accessibility;
import ch.raiffeisen.openbank.branch.persistency.model.BranchType;
import ch.raiffeisen.openbank.branch.persistency.model.CustomerSegment;
import ch.raiffeisen.openbank.branch.persistency.model.ServiceAndFacility;

@Relation(value = "branch", collectionRelation = "branches")
public class BranchResource extends ResourceSupport {
  private String sequenceNumber;
  private String name;
  private BranchType branchType;
  private String photo;
  private Collection<CustomerSegment> customerSegments;
  private Collection<ServiceAndFacility> serviceAndFacilities;
  private Collection<Accessibility> accessibilities;
  private String note;
  private PhoneInfo phoneInfo;
  private PostalAddress postalAddress;
  private GeoLocation geoLocation;
  
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

  public PhoneInfo getPhoneInfo() {
    return phoneInfo;
  }

  public void setPhoneInfo(PhoneInfo phoneInfo) {
    this.phoneInfo = phoneInfo;
  }

  public PostalAddress getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(PostalAddress postalAddress) {
    this.postalAddress = postalAddress;
  }
  
  public GeoLocation getGeoLocation() {
    return geoLocation;
  }
  
  public void setGeoLocation(GeoLocation geoLocation) {
    this.geoLocation = geoLocation;
  }

}
