package ch.raiffeisen.openbank.offer.controller;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.controller.api.Amount;
import ch.raiffeisen.openbank.common.controller.api.Fee;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.common.service.api.FeeDTO;
import ch.raiffeisen.openbank.offer.controller.api.OfferResource;
import ch.raiffeisen.openbank.offer.service.api.OfferDTO;

/**
 * This class represents a resource assembler to move the knowledge on how to build and link
 * resources out of the Resource and Controller implementations.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class OfferResourceAssembler
    extends ResourceAssemblerSupport<OfferDTO, OfferResource> {

  public OfferResourceAssembler() {
    super(OfferController.class, OfferResource.class);
  }

  @Override
  public OfferResource toResource(OfferDTO dto) {
    final OfferResource resource = createResourceWithId(dto.getId(), dto);
    resource.setAccountId(dto.getAccountId());
    resource.setOfferId(dto.getOfferId());
    resource.setOfferType(dto.getOfferType());
    resource.setDescription(dto.getDescription());
    resource.setStartDateTime(dto.getStartDateTime());
    resource.setEndDateTime(dto.getEndDateTime());
    AmountDTO amount = dto.getAmount();
    if(amount != null) {
      resource.setAmount(new Amount(amount.getAmount(), amount.getCurrency()));
    }
    FeeDTO fee = dto.getFee();
    if(fee != null) {
      resource.setFee(new Fee(fee.getFee(), fee.getCurrency()));
    }
    resource.setRate(dto.getRate());
    resource.setTerm(dto.getTerm());
    resource.setUrl(dto.getUrl());
    return resource;
  }
}
