package ch.raiffeisen.openbank.balance.controller;

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

import ch.raiffeisen.openbank.balance.controller.api.BalanceResource;
import ch.raiffeisen.openbank.balance.service.BalanceService;
import ch.raiffeisen.openbank.balance.service.api.BalanceDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class represents the controller to provide the account balance information.
 * 
 * @author Goekhan Demirkiyik
 */
@RestController
@ExposesResourceFor(BalanceResource.class)
@RequestMapping("/api")
public class BalanceController {

  @Inject
  private BalanceService balanceService;

  @Inject
  private BalanceResourceAssembler assembler;

  private static final Logger log = LoggerFactory.getLogger(BalanceController.class);

  // @formatter:off
  @ApiOperation(
      tags= {"Balances"},
      value = "Get Balances", 
      nickname = "findAll")
  @ApiResponses({
      @ApiResponse(code = SC_OK, message = "Balances successfully retrieved"),
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
  @RequestMapping(value = "/balances", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<BalanceResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<BalanceDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of balance", pageable);

    Page<BalanceDTO> page = balanceService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

//@formatter:off
 @ApiOperation(
     tags= {"Accounts"},
     value = "Get Account Balances", 
     nickname = "findByAccountId")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = "Account Balances successfully retrieved"),
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
  @RequestMapping(value = "/accounts/{accountId}/balances", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<BalanceResource> findByAccountId(@PathVariable("accountId") final String accountId, @PageableDefault Pageable pageable,
      PagedResourcesAssembler<BalanceDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of account balance information for account: {}", pageable, accountId);

    Page<BalanceDTO> page = balanceService.findByAccountId(accountId, pageable);
    return pagedAssembler.toResource(page, assembler);
  }
}
