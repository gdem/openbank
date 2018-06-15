package ch.raiffeisen.openbank.transaction.controller.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Set of elements to fully identify a proprietary bank transaction code.")
public class ProprietaryBankTransactionCode {

  @ApiModelProperty(notes = "Proprietary bank transaction code to identify the underlying transaction.")
  private String code;

  @ApiModelProperty(notes = "Identification of the issuer of the proprietary bank transaction code.")
  private String issuer;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }
}
