package ch.raiffeisen.openbank.account.controller;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import java.util.NoSuchElementException;
import java.util.Optional;

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

import ch.raiffeisen.openbank.account.controller.api.AccountResource;
import ch.raiffeisen.openbank.account.service.AccountService;
import ch.raiffeisen.openbank.account.service.api.AccountDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ExposesResourceFor(AccountResource.class)
@RequestMapping("/api/accounts")
public class AccountController {

  @Inject
  private AccountService accountService;

  @Inject
  private AccountResourceAssembler assembler;

  private static final Logger log = LoggerFactory.getLogger(AccountController.class);

  // @formatter:off
  @ApiOperation(
      tags= {"Accounts"},
      value = "Gets Accounts", 
      nickname = "findAll")
  @ApiResponses({
      @ApiResponse(code = SC_OK, message = "Accounts successfully retrieved"),
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
  @RequestMapping(method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<AccountResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<AccountDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of account", pageable);

    Page<AccountDTO> page = accountService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

//@formatter:off
 @ApiOperation(
     tags= {"Accounts"},
     value = "Get Account", 
     nickname = "findById")
 @ApiResponses({
     @ApiResponse(code = SC_OK, message = "Account resource successfully retrieved"),
     @ApiResponse(code = SC_NOT_FOUND, message = "Account resource not found."),
     @ApiResponse(code = SC_UNAUTHORIZED, message = "Unauthorized"), 
     @ApiResponse(code = SC_FORBIDDEN, message = "Forbidden"), 
     @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error")
     })
 // @formatter:on
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public AccountResource findById(@PathVariable("accountId") final String accountId) {
    log.debug("GET request to get account with accountId: {}", accountId);

    final Optional<AccountDTO> maybeAccount = accountService.findById(accountId);
    return maybeAccount.map(assembler::toResource).orElseThrow(NoSuchElementException::new);
  }
}
