package ch.raiffeisen.openbank.transaction.controller.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of the merchant involved in the transaction.")
public class MerchantDetails {

  @ApiModelProperty(notes = "Name by which the merchant is known.")
  private String merchantName;

  @ApiModelProperty(notes = "Category code conform to ISO 18245, related to the type of services or goods the merchant provides for the transaction.")
  private String merchantCategoryCode;

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getMerchantCategoryCode() {
    return merchantCategoryCode;
  }

  public void setMerchantCategoryCode(String merchantCategoryCode) {
    this.merchantCategoryCode = merchantCategoryCode;
  }

}
