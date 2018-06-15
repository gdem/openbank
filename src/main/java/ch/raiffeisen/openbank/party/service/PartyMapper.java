package ch.raiffeisen.openbank.party.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.party.persistency.model.Address;
import ch.raiffeisen.openbank.party.persistency.model.Party;
import ch.raiffeisen.openbank.party.service.api.AddressDTO;
import ch.raiffeisen.openbank.party.service.api.PartyDTO;

/**
 * This class represents the balance mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class PartyMapper {

  public PartyDTO convert(Party party) {
    Objects.requireNonNull(party);
    final PartyDTO dto = new PartyDTO();
    dto.setId(party.getId());
    dto.setAccountId(party.getAccountId());
    dto.setPartyId(party.getPartyId());
    dto.setPartyType(party.getPartyType());
    dto.setPartyNumber(party.getPartyNumber());
    dto.setName(party.getName());
    dto.setEmailAddress(party.getEmailAddress());
    dto.setPhone(party.getPhone());
    dto.setMobile(party.getMobile());

    final Address address = party.getAddress();
    if (address != null) {
      AddressDTO addressDTO = new AddressDTO();
      addressDTO.setAddressType(address.getAddressType());
      addressDTO.setAddressLines(address.getAddressLines());
      addressDTO.setStreetName(address.getStreetName());
      addressDTO.setBuildingNumber(address.getBuildingNumber());
      addressDTO.setPostalCode(address.getPostalCode());
      addressDTO.setTownName(address.getTownName());
      addressDTO.setCountrySubDivision(address.getCountrySubDivision());
      addressDTO.setCountry(address.getCountry());
      dto.setAddress(addressDTO);
    }

    return dto;
  }
}
