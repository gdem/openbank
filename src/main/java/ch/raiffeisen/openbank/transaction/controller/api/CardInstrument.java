package ch.raiffeisen.openbank.transaction.controller.api;

import ch.raiffeisen.openbank.transaction.persistency.model.ExternalCardAuthorisationType;
import ch.raiffeisen.openbank.transaction.persistency.model.ExternalCardSchemeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Set of elements to describe the card instrument used in the transaction.")
public class CardInstrument {

  @ApiModelProperty(notes = "Name of the card scheme.")
  private ExternalCardSchemeType cardSchemeName;

  @ApiModelProperty(notes = "The card authorisation type.")
  private ExternalCardAuthorisationType authorisationType;

  @ApiModelProperty(notes = "Name of the cardholder using the card instrument.")
  private String name;

  @ApiModelProperty(
      notes = "Identification assigned by an institution to identify the card instrument used in the transaction. This identification is known by the account owner, and may be masked.")
  private String identification;

  public ExternalCardSchemeType getCardSchemeName() {
    return cardSchemeName;
  }

  public void setCardSchemeName(ExternalCardSchemeType cardSchemeName) {
    this.cardSchemeName = cardSchemeName;
  }

  public ExternalCardAuthorisationType getAuthorisationType() {
    return authorisationType;
  }

  public void setAuthorisationType(ExternalCardAuthorisationType authorisationType) {
    this.authorisationType = authorisationType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }


}
