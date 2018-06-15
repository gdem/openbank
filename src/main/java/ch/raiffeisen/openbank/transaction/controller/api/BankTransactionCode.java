package ch.raiffeisen.openbank.transaction.controller.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Set of elements used to fully identify the type of underlying transaction resulting in an entry.")
public class BankTransactionCode {

  @ApiModelProperty(notes = "Specifies the family within a domain.")
  private String code;

  @ApiModelProperty(notes = "pecifies the sub-product family within a specific family.")
  private String subCode;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSubCode() {
    return subCode;
  }

  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }

}
