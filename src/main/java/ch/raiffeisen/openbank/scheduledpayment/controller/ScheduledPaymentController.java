package ch.raiffeisen.openbank.scheduledpayment.controller;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.raiffeisen.openbank.scheduledpayment.controller.api.ScheduledPaymentResource;
import ch.raiffeisen.openbank.scheduledpayment.controller.api.ScheduledPaymentResourceAssembler;
import ch.raiffeisen.openbank.scheduledpayment.service.ScheduledPaymentService;
import ch.raiffeisen.openbank.scheduledpayment.service.api.ScheduledPaymentDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/***
 * A resource that contains a set of elements that describes the scheduled payments that have been
 * set up on a specific account (AccountId). A scheduled payment is a single one-off payment
 * scheduled for a future date.
 * 
 * An account (AccountId) may have no scheduled payments set up, or may have multiple scheduled
 * payments set up.
 * 
 * @author Timur Tokoev
 *
 */
@RestController
@ExposesResourceFor(ScheduledPaymentResource.class)
@RequestMapping("/api")
public class ScheduledPaymentController {
  private static final Logger log = LoggerFactory.getLogger(ScheduledPaymentController.class);

  @Inject
  private ScheduledPaymentService scheduledPaymentService;

  @Inject
  private ScheduledPaymentResourceAssembler assembler;

//@formatter:off
 @ApiOperation(
     tags= {"Scheduled-Payments"},
     value = "Get Scheduled-Payments.", 
     nickname = "GetScheduledPayments")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = "Scheduled-Payments successfully retrieved."),
     @ApiResponse(code = SC_UNAUTHORIZED, message = "Unauthorized"), 
     @ApiResponse(code = SC_FORBIDDEN, message = "Forbidden"), 
     @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error")
     })
 @ApiImplicitParams({
   @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
   @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
   @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
 })
 // @formatter:on
  @RequestMapping(value = "/scheduled-payments", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<ScheduledPaymentResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<ScheduledPaymentDTO> pagedAssembler) {
    log.debug("GET request to get all scheduled-payments.");

    final Page<ScheduledPaymentDTO> page = scheduledPaymentService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

//@formatter:off
 @ApiOperation(
     tags= {"Accounts"},
     value = "Get Account Scheduled-Payments", 
     nickname = "GetAccountScheduledPayments")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = " Scheduled-Payments successfully retrieved"),
     @ApiResponse(code = SC_UNAUTHORIZED, message = "Unauthorized"), 
     @ApiResponse(code = SC_FORBIDDEN, message = "Forbidden"), 
     @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error")
     })
 @ApiImplicitParams({
   @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
   @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
   @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
 }) 
 // @formatter:on
  @RequestMapping(value = "/accounts/{accountId}/scheduled-payments", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<ScheduledPaymentResource> findByAccountId(@PathVariable final String accountId, @PageableDefault Pageable pageable,
      PagedResourcesAssembler<ScheduledPaymentDTO> pagedAssembler) {
    log.debug("GET request to get scheduled-payments for account accountId: {}", accountId);

    final Page<ScheduledPaymentDTO> page = scheduledPaymentService.findByAccountId(accountId, pageable);
    return pagedAssembler.toResource(page, assembler);
  }
}
