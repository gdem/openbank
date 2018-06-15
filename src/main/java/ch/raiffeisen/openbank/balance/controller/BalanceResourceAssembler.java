package ch.raiffeisen.openbank.balance.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.balance.controller.api.BalanceResource;
import ch.raiffeisen.openbank.balance.service.api.BalanceDTO;
import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;

/**
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class BalanceResourceAssembler
    extends ResourceAssemblerSupport<BalanceDTO, BalanceResource> {

  public BalanceResourceAssembler() {
    super(BalanceController.class, BalanceResource.class);
  }

  @Override
  public BalanceResource toResource(BalanceDTO dto) {
    final BalanceResource resource = createResourceWithId(dto.getId(), dto);
    resource.setAccountId(dto.getAccountId());
    AmountDTO amount = dto.getAmount();
    if (amount != null) {
      resource.setAmount(new Amount(amount.getAmount(), amount.getCurrency()));
    }
    resource.setBalanceType(dto.getBalanceType());
    resource.setCreditDebitIndicator(dto.getCreditDebitIndicator());
    resource.setDateTime(dto.getDateTime());
    return resource;
  }
}
