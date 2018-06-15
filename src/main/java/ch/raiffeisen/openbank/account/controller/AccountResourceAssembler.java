package ch.raiffeisen.openbank.account.controller;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.account.controller.api.AccountIdentification;
import ch.raiffeisen.openbank.account.controller.api.AccountResource;
import ch.raiffeisen.openbank.account.controller.api.Servicer;
import ch.raiffeisen.openbank.account.service.api.AccountDTO;
import ch.raiffeisen.openbank.account.service.api.AccountIdentificationDTO;
import ch.raiffeisen.openbank.account.service.api.ServicerDTO;

/**
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class AccountResourceAssembler extends ResourceAssemblerSupport<AccountDTO, AccountResource> {

  public AccountResourceAssembler() {
    super(AccountController.class, AccountResource.class);
  }

  @Override
  public AccountResource toResource(AccountDTO dto) {
    final AccountResource resource = createResourceWithId(dto.getAccountId(), dto);
    resource.setCurrency(dto.getCurrency());
    resource.setAccountType(dto.getAccountType());
    resource.setAccountSubType(dto.getAccountSubType());
    resource.setDescription(dto.getDescription());
    resource.setNickname(dto.getNickname());

    List<AccountIdentificationDTO> accounts = dto.getAccountIdentifications();
    if (accounts != null && !accounts.isEmpty()) {
      final List<AccountIdentification> account = resource.getAccount();
      accounts.forEach(i -> account.add(map(i)));
    }

    ServicerDTO servicerDTO = dto.getServicer();
    if (servicerDTO != null) {
      resource.setServicer(map(servicerDTO));
    }

    return resource;
  }

  private Servicer map(ServicerDTO dto) {
    Servicer result = new Servicer();
    result.setSchemaName(dto.getSchemeName());
    result.setIdentification(dto.getIdentification());
    return result;
  }

  private AccountIdentification map(AccountIdentificationDTO dto) {
    AccountIdentification result = new AccountIdentification();
    result.setSchemeName(dto.getSchemeName());
    result.setIdentification(dto.getIdentification());
    result.setName(dto.getName());
    result.setSecondaryIdentification(dto.getSecondaryIdentification());
    return result;
  }
}
