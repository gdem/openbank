package ch.raiffeisen.openbank.branch.persistency.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This entity represents the branch entity.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "BRANCH")
public class Branch {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Unique and unambiguous identification of a branch of a financial institution.
   */
  @Column(name = "IDENTIFICATION", unique = true, length = 35)
  private String identification;

  /**
   * Sequence Number that is used in conjunction with Identification to uniquely identify a branch.
   * Physical branches should have 0 assigned, mobile and sub branches should have 1,2,3....etc
   * assigned.
   */
  @Column(name = "SEQUENCE_NUMBER", nullable = false, length = 35)
  private String sequenceNumber;

  /**
   * Name by which a branch is known and which is usually used to identify that branch.
   */
  @Column(name = "NAME", nullable = true, length = 140)
  private String name;

  /**
   * Codeset to indicate if a branch is physically in 1 location or is mobile
   */
  @Column(name = "BRANCH_TYPE", nullable = false)
  @Enumerated(EnumType.STRING)
  private BranchType branchType;

  /**
   * Image related to the branch
   */
  @Column(name = "PHOTO", nullable = true, length = 256)
  private String photo;

  @ElementCollection(targetClass = CustomerSegment.class)
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "BRANCH_CUSTOMER_SEGMENT")
  @Column(name = "CUSTOMER_SEGMENT")
  private Collection<CustomerSegment> customerSegments;

  @ElementCollection(targetClass = ServiceAndFacility.class)
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "BRANCH_SERVICE_AND_FACILITY")
  @Column(name = "SERVICE_AND_FACILITY")
  private Collection<ServiceAndFacility> serviceAndFacilities;

  @ElementCollection(targetClass = Accessibility.class)
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "BRANCH_ACCESSIBILITY")
  @Column(name = "ACCESSIBILITY")
  private Collection<Accessibility> accessibilities;

  @Embedded
  private StandardAvailability standardAvailability;

  @OneToOne
  private PhoneInfo phoneInfo;

  @Embedded
  private PostalAddress postalAddress;

  @OneToOne
  private GeoLocation geoLocation;

  /**
   * Summary description of services, facility and availability.
   */
  @Column(name = "NOTE", nullable = true, length = 2000)
  private String note;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BRAND_ID")
  private Brand brand;

  protected Branch() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public StandardAvailability getStandardAvailability() {
    return standardAvailability;
  }

  public void setStandardAvailability(StandardAvailability standardAvailability) {
    this.standardAvailability = standardAvailability;
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

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }
}
