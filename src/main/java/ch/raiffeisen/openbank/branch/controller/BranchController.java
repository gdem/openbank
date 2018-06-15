package ch.raiffeisen.openbank.branch.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.raiffeisen.openbank.branch.controller.api.BranchResource;
import ch.raiffeisen.openbank.branch.service.BranchService;
import ch.raiffeisen.openbank.branch.service.api.BranchDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class represents the controller to provide the branch data.
 * 
 * @author Goekhan Demirkiyik
 */
@RestController
@ExposesResourceFor(BranchResource.class)
@RequestMapping("/api")
public class BranchController {

  @Inject
  private BranchService branchService;

  @Inject
  private BranchResourceAssembler assembler;

  private static final Logger log = LoggerFactory.getLogger(BranchController.class);

  // @formatter:off
  @ApiOperation(
      tags = {"Branches"},
      value = "Get Branches.", 
      nickname = "getBranches")
  @ApiResponses({
      @ApiResponse(code = SC_OK, message = "Branches successfully retrieved"),
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
  @RequestMapping(value = "/branches", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public PagedResources<BranchResource> findAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<BranchDTO> pagedAssembler) {
    log.debug("GET request to get page [{}] of branch", pageable);

    Page<BranchDTO> page = branchService.findAll(pageable);
    return pagedAssembler.toResource(page, assembler);
  }

}
