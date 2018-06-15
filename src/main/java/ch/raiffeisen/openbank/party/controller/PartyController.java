package ch.raiffeisen.openbank.party.controller;

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

import ch.raiffeisen.openbank.party.controller.api.PartyResource;
import ch.raiffeisen.openbank.party.service.PartyService;
import ch.raiffeisen.openbank.party.service.api.PartyDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class represents the controller to provide the parties.
 * 
 * @author Goekhan Demirkiyik
 */
@RestController
@ExposesResourceFor(PartyResource.class)
@RequestMapping("/api")
public class PartyController {

  @Inject
  private PartyService partyService;

  @Inject
  private PartyResourceAssembler assembler;

  private static final Logger log = LoggerFactory.getLogger(PartyController.class);

  // @formatter:off
  @ApiOperation(
      tags = {"Parties"},
      value = "Get Parties", 
      nickname = "GetParties")
  @ApiResponses({
    @ApiResponse(code = SC_OK, message = "Parties successfully retrieved"),
    @ApiResponse(code = SC_UNAUTHORIZED, message = "Unauthorized"), 
    @ApiResponse(code = SC_FORBIDDEN, message = "Forbidden"), 
    @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error")
      })
  @ApiImplicitParams({
    @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
    @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
    @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
  })
  // @formatter:on
  @RequestMapping(value = "/parties", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<PartyResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<PartyDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of parties", pageable);

    Page<PartyDTO> page = partyService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

//@formatter:off
 @ApiOperation(
     tags = {"Accounts"},
     value = "Get Account Parties", 
     nickname = "GetAccountParties")
 @ApiResponses({
   @ApiResponse(code = SC_OK, message = "Account Parties successfully retrieved"),
   @ApiResponse(code = SC_NOT_FOUND, message = "The requested resource not found."),
   @ApiResponse(code = SC_UNAUTHORIZED, message = "Unauthorized"), 
   @ApiResponse(code = SC_FORBIDDEN, message = "Forbidden"), 
   @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error")
     })
 @ApiImplicitParams({
   @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
   @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
   @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
 })
 // @formatter:on
  @RequestMapping(value = "/accounts/{accountId}/parties", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<PartyResource> findByAccountId(@PathVariable("accountId") final String accountId, @PageableDefault Pageable pageable,
      PagedResourcesAssembler<PartyDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of parties for account: {}", pageable, accountId);

    Page<PartyDTO> page = partyService.findByAccountId(accountId, pageable);
    return pagedAssembler.toResource(page, assembler);
  }
}
