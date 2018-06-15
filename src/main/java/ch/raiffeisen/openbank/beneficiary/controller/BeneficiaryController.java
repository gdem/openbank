package ch.raiffeisen.openbank.beneficiary.controller;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
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

import ch.raiffeisen.openbank.beneficiary.controller.api.BeneficiaryResource;
import ch.raiffeisen.openbank.beneficiary.service.BeneficiaryService;
import ch.raiffeisen.openbank.beneficiary.service.api.BeneficiaryDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * An AISP may retrieve the account beneficiaries information resource for a specific AccountId
 * 
 * @author Timur Tokoev
 *
 */
@RestController
@ExposesResourceFor(BeneficiaryResource.class)
@RequestMapping("/api")
public class BeneficiaryController {
  private static final Logger log = LoggerFactory.getLogger(BeneficiaryController.class);

  @Inject
  private BeneficiaryService beneficiaryService;

  @Inject
  private BeneficiaryResourceAssembler assembler;

//@formatter:off
 @ApiOperation(
     tags = {"Beneficiaries"},
     value = "Get Beneficiaries", 
     nickname = "getBeneficiaries")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = "Beneficiaries successfully retrieved"),
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
  @RequestMapping(value = "/beneficiaries", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<BeneficiaryResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<BeneficiaryDTO> pagedAssembler) {
    log.debug("GET request to get all beneficiaries.");

    final Page<BeneficiaryDTO> page = beneficiaryService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

//@formatter:off
 @ApiOperation(
     tags = {"Accounts"},
     value = "Get Account Beneficiaries", 
     nickname = "getAccountBeneficiaries")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = "Account Beneficiaries successfully retrieved"),
     @ApiResponse(code = SC_NOT_FOUND, message = "The requested resource not found."),
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
  @RequestMapping(value = "/accounts/{accountId}/beneficiaries", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<BeneficiaryResource> findByAccountId(@PathVariable final String accountId, @PageableDefault Pageable pageable,
      PagedResourcesAssembler<BeneficiaryDTO> pagedAssembler) {
    log.debug("GET request to get beneficiaries for account accountId: {}", accountId);

    final Page<BeneficiaryDTO> page = beneficiaryService.findByAccountId(accountId, pageable);
    return pagedAssembler.toResource(page, assembler);
  }
}
