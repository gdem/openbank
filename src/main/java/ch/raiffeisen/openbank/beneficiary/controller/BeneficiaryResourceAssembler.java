package ch.raiffeisen.openbank.beneficiary.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.beneficiary.controller.api.BeneficiaryResource;
import ch.raiffeisen.openbank.beneficiary.controller.api.CreditorAccount;
import ch.raiffeisen.openbank.beneficiary.controller.api.CreditorAgent;
import ch.raiffeisen.openbank.beneficiary.controller.api.PostalAddress;
import ch.raiffeisen.openbank.beneficiary.service.api.BeneficiaryDTO;
import ch.raiffeisen.openbank.beneficiary.service.api.CreditorAccountDTO;
import ch.raiffeisen.openbank.beneficiary.service.api.CreditorAgentDTO;
import ch.raiffeisen.openbank.beneficiary.service.api.PostalAddressDTO;

/**
 * This class represents a resource assembler to transform the {@link BeneficiaryDTO} to
 * {@link BeneficiaryResource} object.
 * 
 * @author Timur Tokoev
 */
@Component
public class BeneficiaryResourceAssembler extends ResourceAssemblerSupport<BeneficiaryDTO, BeneficiaryResource> {

  public BeneficiaryResourceAssembler() {
    super(BeneficiaryController.class, BeneficiaryResource.class);
  }

  @Override
  public BeneficiaryResource toResource(BeneficiaryDTO dto) {
    final BeneficiaryResource resource = new BeneficiaryResource();
    resource.setAccountId(dto.getAccountId());
    resource.setBeneficiaryId(dto.getBeneficiaryId());
    resource.setReference(dto.getReference());

    resource.setCreditorAccount(map(dto.getCreditorAccount()));
    resource.setCreditorAgent(map(dto.getCreditorAgent()));

    return resource;
  }


  private CreditorAccount map(CreditorAccountDTO dto) {
    CreditorAccount resource = null;
    if (dto != null) {
      resource = new CreditorAccount();
      resource.setIdentification(dto.getIdentification());
      resource.setName(dto.getName());
      resource.setSchemeName(dto.getSchemeName());
      resource.setSecondaryIdentification(dto.getSecondaryIdentification());
    }
    return resource;
  }

  public CreditorAgent map(CreditorAgentDTO dto) {
    CreditorAgent resource = null;
    if (dto != null) {
      resource = new CreditorAgent();
      resource.setIdentification(dto.getIdentification());
      resource.setName(dto.getName());
      resource.setSchemeName(dto.getSchemeName());
      resource.setPostalAddress(map(dto.getPostalAddress()));
    }
    return resource;
  }

  public PostalAddress map(PostalAddressDTO dto) {
    PostalAddress resource = null;
    if (dto != null) {
      resource = new PostalAddress();
      resource.setAddressType(dto.getAddressType());
      resource.setDepartment(dto.getDepartment());
      resource.setSubDepartment(dto.getSubDepartment());
      resource.setStreetName(dto.getStreetName());
      resource.setBuildingNumber(dto.getBuildingNumber());
      resource.setPostCode(dto.getPostCode());
      resource.setTownName(dto.getTownName());
      resource.setCountrySubDivision(dto.getCountrySubDivision());
      resource.setCountry(dto.getCountry());
      resource.setAddressLines(dto.getAddressLines());
    }
    return resource;
  }
}
