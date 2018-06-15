package ch.raiffeisen.openbank.branch.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.branch.controller.api.BranchResource;
import ch.raiffeisen.openbank.branch.controller.api.GeoLocation;
import ch.raiffeisen.openbank.branch.controller.api.PhoneInfo;
import ch.raiffeisen.openbank.branch.controller.api.PostalAddress;
import ch.raiffeisen.openbank.branch.service.api.BranchDTO;
import ch.raiffeisen.openbank.branch.service.api.GeoLocationDTO;
import ch.raiffeisen.openbank.branch.service.api.PhoneInfoDTO;
import ch.raiffeisen.openbank.branch.service.api.PostalAddressDTO;

/**
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class BranchResourceAssembler extends ResourceAssemblerSupport<BranchDTO, BranchResource> {

  public BranchResourceAssembler() {
    super(BranchController.class, BranchResource.class);
  }

  @Override
  public BranchResource toResource(BranchDTO dto) {
    final BranchResource resource = createResourceWithId(dto.getIdentification(), dto);
    resource.setName(dto.getName());
    resource.setSequenceNumber(dto.getSequenceNumber());
    resource.setBranchType(dto.getBranchType());
    resource.setPhoto(dto.getPhoto());
    resource.setCustomerSegments(dto.getCustomerSegments());
    resource.setServiceAndFacilities(dto.getServiceAndFacilities());
    resource.setAccessibilities(dto.getAccessibilities());
    resource.setNote(dto.getNote());

    PhoneInfoDTO phoneInfo = dto.getPhoneInfo();
    if (phoneInfo != null) {
      resource.setPhoneInfo(map(phoneInfo));
    }

    PostalAddressDTO postalAddress = dto.getPostalAddress();
    if (postalAddress != null) {
      resource.setPostalAddress(map(postalAddress));
    }

    GeoLocationDTO geoLocation = dto.getGeoLocation();
    if (geoLocation != null) {
      resource.setGeoLocation(map(geoLocation));
    }
    return resource;
  }

  private PhoneInfo map(PhoneInfoDTO dto) {
    PhoneInfo result = new PhoneInfo();
    result.setPhone(dto.getPhone());
    result.setAlternatePhone(dto.getAlternatePhoneDescription());
    result.setAlternatePhoneDescription(dto.getAlternatePhoneDescription());
    result.setFaxNumber(dto.getFaxNumber());
    return result;
  }

  private PostalAddress map(PostalAddressDTO dto) {
    PostalAddress result = new PostalAddress();
    result.setAddressLines(dto.getAddressLines());
    result.setBuildingNumber(dto.getBuildingNumber());
    result.setCountry(dto.getCountry());
    result.setCountrySubDivision(dto.getCountrySubDivision());
    result.setPostCode(dto.getPostCode());
    result.setStreetName(dto.getStreetName());
    result.setTownName(dto.getTownName());
    return result;
  }

  private GeoLocation map(GeoLocationDTO dto) {
    return new GeoLocation(dto.getLatitude(), dto.getLongitude());
  }
}
