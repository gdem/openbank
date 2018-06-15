package ch.raiffeisen.openbank.beneficiary.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.beneficiary.persistency.model.Beneficiary;
import ch.raiffeisen.openbank.beneficiary.persistency.model.CreditorAccount;
import ch.raiffeisen.openbank.beneficiary.persistency.model.CreditorAgent;
import ch.raiffeisen.openbank.beneficiary.persistency.model.PostalAddress;
import ch.raiffeisen.openbank.beneficiary.service.api.BeneficiaryDTO;
import ch.raiffeisen.openbank.beneficiary.service.api.CreditorAccountDTO;
import ch.raiffeisen.openbank.beneficiary.service.api.CreditorAgentDTO;
import ch.raiffeisen.openbank.beneficiary.service.api.PostalAddressDTO;

/**
 * This class represents the Beneficiary mapper.
 * 
 * @author Timur Tokoev
 */
@Component
public class BeneficiaryMapper {

  public BeneficiaryDTO convert(Beneficiary beneficiary) {
    Objects.requireNonNull(beneficiary);
    final BeneficiaryDTO dto = new BeneficiaryDTO();
    dto.setAccountId(beneficiary.getAccountId());
    dto.setBeneficiaryId(beneficiary.getBeneficiaryId());
    dto.setReference(beneficiary.getReference());

    CreditorAccount creditorAccount = beneficiary.getCreditorAccount();
    if (creditorAccount != null) {
      CreditorAccountDTO creditorAccountDTO = new CreditorAccountDTO();
      creditorAccountDTO.setIdentification(creditorAccount.getIdentification());
      creditorAccountDTO.setName(creditorAccount.getName());
      creditorAccountDTO.setSchemeName(creditorAccount.getSchemeName());
      creditorAccountDTO.setSecondaryIdentification(creditorAccount.getSecondaryIdentification());
      dto.setCreditorAccount(creditorAccountDTO);
    }

    CreditorAgent creditorAgent = beneficiary.getCreditorAgent();
    if (creditorAgent != null) {
      CreditorAgentDTO creditorAgentDTO = new CreditorAgentDTO();
      creditorAgentDTO.setIdentification(creditorAgent.getIdentification());
      creditorAgentDTO.setName(creditorAgent.getName());
      creditorAgentDTO.setSchemeName(creditorAgent.getSchemeName());

      PostalAddress address = creditorAgent.getPostalAddress();
      if (address != null) {
        PostalAddressDTO addressDTO = new PostalAddressDTO();
        addressDTO.setAddressType(address.getAddressType());
        addressDTO.setDepartment(address.getDepartment());
        addressDTO.setSubDepartment(address.getSubDepartment());
        addressDTO.setStreetName(address.getStreetName());
        addressDTO.setBuildingNumber(address.getBuildingNumber());
        addressDTO.setPostCode(address.getPostCode());
        addressDTO.setTownName(address.getTownName());
        addressDTO.setCountrySubDivision(address.getCountrySubDivision());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setAddressLines(address.getAddressLines());
        creditorAgentDTO.setPostalAddress(addressDTO);
      }

      dto.setCreditorAgent(creditorAgentDTO);
    }

    return dto;
  }
}
