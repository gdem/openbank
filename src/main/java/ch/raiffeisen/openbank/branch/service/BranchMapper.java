package ch.raiffeisen.openbank.branch.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.branch.persistency.model.Branch;
import ch.raiffeisen.openbank.branch.persistency.model.GeoLocation;
import ch.raiffeisen.openbank.branch.persistency.model.GeographicCoordinates;
import ch.raiffeisen.openbank.branch.persistency.model.PhoneInfo;
import ch.raiffeisen.openbank.branch.persistency.model.PostalAddress;
import ch.raiffeisen.openbank.branch.service.api.BranchDTO;
import ch.raiffeisen.openbank.branch.service.api.GeoLocationDTO;
import ch.raiffeisen.openbank.branch.service.api.PhoneInfoDTO;
import ch.raiffeisen.openbank.branch.service.api.PostalAddressDTO;

/**
 * This class represents the branch mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class BranchMapper {

  public BranchDTO convert(Branch branch) {
    Objects.requireNonNull(branch);
    final BranchDTO dto = new BranchDTO();
    dto.setIdentification(branch.getIdentification());
    dto.setSequenceNumber(branch.getSequenceNumber());
    dto.setName(branch.getName());
    dto.setBranchType(branch.getBranchType());
    dto.setPhoto(branch.getPhoto());
    dto.setCustomerSegments(branch.getCustomerSegments());
    dto.setServiceAndFacilities(branch.getServiceAndFacilities());
    dto.setAccessibilities(branch.getAccessibilities());
    dto.setNote(branch.getNote());
    
    PostalAddress address = branch.getPostalAddress();
    if(address != null) {
      PostalAddressDTO addressDTO = new PostalAddressDTO();
      addressDTO.setAddressLines(address.getAddressLines());
      addressDTO.setBuildingNumber(address.getBuildingNumber());
      addressDTO.setCountry(address.getCountry());
      addressDTO.setCountrySubDivision(address.getCountrySubDivision());
      addressDTO.setPostCode(address.getPostCode());
      addressDTO.setStreetName(address.getStreetName());
      addressDTO.setTownName(address.getTownName());
      dto.setPostalAddress(addressDTO);
    }
    
    return dto;
  }
  
  public GeoLocationDTO convert(GeoLocation geoLocation) {
    GeoLocationDTO result = null;
    if(geoLocation != null && geoLocation.getGeographicCoordinates() != null) {
      GeographicCoordinates coords = geoLocation.getGeographicCoordinates();
      result = new GeoLocationDTO();
      result.setLatitude(coords.getLatitude());
      result.setLongitude(coords.getLongitude());
    }
    return result;
  }
  
  public PhoneInfoDTO convert(PhoneInfo phoneInfo) {
    PhoneInfoDTO result = null;
    if(phoneInfo != null) {
      result = new PhoneInfoDTO();
      result.setId(phoneInfo.getId());
      result.setPhone(phoneInfo.getPhone());
      result.setAlternatePhone(phoneInfo.getAlternatePhone());
      result.setAlternatePhoneDescription(phoneInfo.getAlternatePhoneDescription());
      result.setFaxNumber(phoneInfo.getFaxNumber());
    }
    return result;
  }
  
}
