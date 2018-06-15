package ch.raiffeisen.openbank.directdebits.controller;

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

import ch.raiffeisen.openbank.directdebits.controller.api.DirectDebitResource;
import ch.raiffeisen.openbank.directdebits.service.DirectDebitService;
import ch.raiffeisen.openbank.directdebits.service.api.DirectDebitDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class represents the controller to provide the direct debit information.
 * 
 * @author Goekhan Demirkiyik
 */
@RestController
@ExposesResourceFor(DirectDebitResource.class)
@RequestMapping("/api")
public class DirectDebitController {

  @Inject
  private DirectDebitService directDebitService;

  @Inject
  private DirectDebitResourceAssembler assembler;

  private static final Logger log = LoggerFactory.getLogger(DirectDebitController.class);

  // @formatter:off
  @ApiOperation(
      tags = {"Direct-Debits"},
      value = "Get Direct Debits", 
      nickname = "getDirectDebits")
  @ApiResponses({
      @ApiResponse(code = SC_OK, message = "Direct Debits successfully retrieved"),
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
  @RequestMapping(value = "/direct-debits", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<DirectDebitResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<DirectDebitDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of balance", pageable);

    Page<DirectDebitDTO> page = directDebitService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

//@formatter:off
 @ApiOperation(
     tags = {"Accounts"},
     value = "Get Account Direct Debits", 
     nickname = "getAccountDirectDebits")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = "Account Direct Debits successfully retrieved"),
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
  @RequestMapping(value = "/accounts/{accountId}/direct-debits", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<DirectDebitResource> findByAccountId(@PathVariable("accountId") final String accountId, @PageableDefault Pageable pageable,
      PagedResourcesAssembler<DirectDebitDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of direct debit for account: {}", pageable, accountId);

    Page<DirectDebitDTO> page = directDebitService.findByAccountId(accountId, pageable);
    return pagedAssembler.toResource(page, assembler);
  }
}
