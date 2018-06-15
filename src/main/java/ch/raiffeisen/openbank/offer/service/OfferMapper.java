package ch.raiffeisen.openbank.offer.service;

import java.util.Objects;

import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.common.repository.model.Amount;
import ch.raiffeisen.openbank.common.repository.model.Fee;
import ch.raiffeisen.openbank.common.service.api.AmountDTO;
import ch.raiffeisen.openbank.common.service.api.FeeDTO;
import ch.raiffeisen.openbank.offer.persistency.model.Offer;
import ch.raiffeisen.openbank.offer.service.api.OfferDTO;

/**
 * This class represents the offer mapper.
 * 
 * @author Goekhan Demirkiyik
 */
@Component
public class OfferMapper {

  public OfferDTO convert(Offer offer) {
    Objects.requireNonNull(offer);
    final OfferDTO dto = new OfferDTO();
    dto.setId(offer.getId());
    dto.setAccountId(offer.getAccountId());
    dto.setOfferId(offer.getOfferId());
    dto.setOfferType(offer.getOfferType());
    dto.setDescription(offer.getDescription());
    dto.setStartDateTime(offer.getStartDateTime());
    dto.setEndDateTime(offer.getEndDateTime());

    final Amount amount = offer.getAmount();
    if (amount != null) {
      dto.setAmount(new AmountDTO(amount.getAmount(), amount.getCurrency()));
    }

    final Fee fee = offer.getFee();
    if (fee != null) {
      dto.setFee(new FeeDTO(fee.getFee(), fee.getCurrency()));
    }

    dto.setRate(offer.getRate());
    dto.setTerm(offer.getTerm());
    dto.setUrl(offer.getUrl());
    return dto;
  }
}
