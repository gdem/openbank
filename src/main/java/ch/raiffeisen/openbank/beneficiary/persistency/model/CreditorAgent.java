package ch.raiffeisen.openbank.beneficiary.persistency.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ch.raiffeisen.openbank.common.repository.model.ExternalFinancialInstitutionIdentificationCode;

/**
 * Party that manages the account on behalf of the account owner, that is manages the registration
 * and booking of entries on the account, calculates balances on the account and provides
 * information about the account. This is the servicer of the beneficiary account.
 * 
 * @author Timur Tokoev
 *
 */
@Entity
@Table(name = "BENEFICIARY_CREDITOR_AGENT")
public class CreditorAgent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   */
  @Column(name = "SCHEME_NAME")
  @Enumerated(EnumType.STRING)
  private ExternalFinancialInstitutionIdentificationCode schemeName;


  /**
   * Unique and unambiguous identification of the servicing institution.
   */
  @Column(name = "IDENTIFICATION", unique = true, length = 35)
  private String identification;


  /**
   * Name by which an agent is known and which is usually used to identify that agent.
   */
  @Column(name = "NAME", length = 140)
  private String name;

  /**
   * Information that locates and identifies a specific address, as defined by postal services.
   */
  @Embedded
  private PostalAddress postalAddress;

  @OneToOne
  @JoinColumn(name = "BENEFICIARY_ID")
  private Beneficiary beneficiary;

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


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public PostalAddress getPostalAddress() {
    return postalAddress;
  }


  public void setPostalAddress(PostalAddress postalAddress) {
    this.postalAddress = postalAddress;
  }


  public Beneficiary getBeneficiary() {
    return beneficiary;
  }


  public void setBeneficiary(Beneficiary beneficiary) {
    this.beneficiary = beneficiary;
  }
}
