package ch.raiffeisen.openbank.transaction.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This entity describes the card instrument used in the transaction.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_CARD_INSTRUMENT")
public class CardInstrument {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "TRANSACTION_ID")
  private Transaction transaction;

  /**
   * Name of the card scheme.
   */
  @Column(name = "CARD_SCHEME_NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExternalCardSchemeType cardSchemeName;

  /**
   * The card authorisation type.
   */
  @Column(name = "AUTHORISATION_TYPE", nullable = true)
  @Enumerated(EnumType.STRING)
  private ExternalCardAuthorisationType authorisationType;

  /**
   * Name of the cardholder using the card instrument.
   */
  @Column(name = "NAME", nullable = true, length = 70)
  private String name;

  /**
   * Identification assigned by an institution to identify the card instrument used in the
   * transaction. This identification is known by the account owner, and may be masked.
   */
  @Column(name = "IDENTIFICATION", nullable = true, length = 34)
  private String identification;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
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
