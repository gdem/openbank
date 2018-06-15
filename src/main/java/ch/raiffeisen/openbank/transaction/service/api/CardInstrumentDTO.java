package ch.raiffeisen.openbank.transaction.service.api;

import ch.raiffeisen.openbank.transaction.persistency.model.ExternalCardAuthorisationType;
import ch.raiffeisen.openbank.transaction.persistency.model.ExternalCardSchemeType;

public class CardInstrumentDTO {

  private Long id;
  private ExternalCardSchemeType cardSchemeName;
  private ExternalCardAuthorisationType authorisationType;
  private String name;
  private String identification;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
