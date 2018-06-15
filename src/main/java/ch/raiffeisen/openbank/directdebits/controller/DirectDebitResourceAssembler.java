package ch.raiffeisen.openbank.directdebits.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.directdebits.controller.api.DirectDebitResource;
import ch.raiffeisen.openbank.directdebits.service.api.DirectDebitDTO;

/**
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class DirectDebitResourceAssembler extends ResourceAssemblerSupport<DirectDebitDTO, DirectDebitResource> {

  public DirectDebitResourceAssembler() {
    super(DirectDebitController.class, DirectDebitResource.class);
  }

  @Override
  public DirectDebitResource toResource(DirectDebitDTO dto) {
    final DirectDebitResource resource = createResourceWithId(dto.getId(), dto);
    resource.setAccountId(dto.getAccountId());
    resource.setDirectDebitId(dto.getDirectDebitId());
    resource.setDirectDebitStatusCode(dto.getDirectDebitStatusCode());
    resource.setMandateIdentification(dto.getMandateIdentification());
    resource.setName(dto.getName());
    resource.setPreviousPaymentDateTime(dto.getPreviousPaymentDateTime());
    AmountDTO amount = dto.getPreviousPaymentAmount();
    if (amount != null) {
      resource.setPreviousPaymentAmount(new Amount(amount.getAmount(), amount.getCurrency()));
    }
    return resource;
  }
}
