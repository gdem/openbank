package ch.raiffeisen.openbank.account.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;

/**
 * Party that manages the account on behalf of the account owner, that is manages the registration
 * and booking of entries on the account, calculates balances on the account and provides
 * information about the account.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "ACCOUNT_SERVICER")
public class Servicer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Unique and unambiguous identification of the servicing institution.
   */
  @Column(name = "IDENTIFICATION", nullable = false, length = 35)
  private String identification;

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   */
  @Column(name = "SCHEME_NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private ExternalFinancialInstitutionIdentificationCode schemeName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ExternalFinancialInstitutionIdentificationCode getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(ExternalFinancialInstitutionIdentificationCode schemeName) {
    this.schemeName = schemeName;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }
}
