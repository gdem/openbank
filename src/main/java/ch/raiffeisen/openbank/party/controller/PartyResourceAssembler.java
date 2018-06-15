package ch.raiffeisen.openbank.party.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.party.controller.api.Address;
import ch.raiffeisen.openbank.party.controller.api.PartyResource;
import ch.raiffeisen.openbank.party.service.api.AddressDTO;
import ch.raiffeisen.openbank.party.service.api.PartyDTO;

/**
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class PartyResourceAssembler
    extends ResourceAssemblerSupport<PartyDTO, PartyResource> {

  public PartyResourceAssembler() {
    super(PartyController.class, PartyResource.class);
  }

  @Override
  public PartyResource toResource(PartyDTO dto) {
    final PartyResource resource = createResourceWithId(dto.getId(), dto);
    resource.setAccountId(dto.getAccountId());
    resource.setPartyId(dto.getPartyId());
    resource.setPartyType(dto.getPartyType());
    resource.setPartyNumber(dto.getPartyNumber());
    resource.setName(dto.getName());
    resource.setEmailAddress(dto.getEmailAddress());
    resource.setPhone(dto.getPhone());
    resource.setMobile(dto.getMobile());

    final AddressDTO addressDTO = dto.getAddress();
    if (addressDTO != null) {
      Address address = new Address();
      address.setAddressType(addressDTO.getAddressType());
      address.setAddressLines(addressDTO.getAddressLines());
      address.setStreetName(addressDTO.getStreetName());
      address.setBuildingNumber(addressDTO.getBuildingNumber());
      address.setPostalCode(addressDTO.getPostalCode());
      address.setTownName(addressDTO.getTownName());
      address.setCountrySubDivision(addressDTO.getCountrySubDivision());
      address.setCountry(addressDTO.getCountry());
      resource.setAddress(address);
    }
    return resource;
  }
}
