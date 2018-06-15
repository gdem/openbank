package ch.raiffeisen.openbank.scheduledpayment.controller.api;

import java.util.Objects;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ch.raiffeisen.openbank.scheduledpayment.controller.ScheduledPaymentController;
import ch.raiffeisen.openbank.scheduledpayment.service.api.CreditorAccountDTO;
import ch.raiffeisen.openbank.scheduledpayment.service.api.CreditorAgentDTO;
import ch.raiffeisen.openbank.scheduledpayment.service.api.ScheduledPaymentDTO;

/**
 * This class represents a resource assembler to transform the {@link ScheduledPaymentDTO} to
 * {@link ScheduledPaymentResource} object.
 * 
 * @author Timur Tokoev
 */
@Component
public class ScheduledPaymentResourceAssembler extends ResourceAssemblerSupport<ScheduledPaymentDTO, ScheduledPaymentResource> {

  public ScheduledPaymentResourceAssembler() {
    super(ScheduledPaymentController.class, ScheduledPaymentResource.class);
  }

  @Override
  public ScheduledPaymentResource toResource(ScheduledPaymentDTO dto) {
    Objects.requireNonNull(dto);

    final ScheduledPaymentResource resource = new ScheduledPaymentResource();
    resource.setAccountId(dto.getAccountId());
    resource.setReference(dto.getReference());
    resource.setScheduledPaymentDateTime(dto.getScheduledPaymentDateTime());
    resource.setScheduledPaymentId(dto.getScheduledPaymentId());
    resource.setScheduledType(dto.getScheduledType());
    resource.setInstructedAmount(dto.getInstructedAmount());

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
      resource.setSchemeName(dto.getSchemeName());
    }
    return resource;
  }
}
