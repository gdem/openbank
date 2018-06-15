package ch.raiffeisen.openbank.transaction.persistency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This entity represents the proprietary bank transaction code.
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_PROPIERTARY_BANK_TRANSACTION_CODE")
public class ProprietaryBankTransactionCode {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "TRANSACTION_ID")
  private Transaction transaction;

  /**
   * Proprietary bank transaction code to identify the underlying transaction.
   */
  @Column(name = "CODE", nullable = false, length = 35)
  private String code;

  /**
   * Identification of the issuer of the proprietary bank transaction code.
   */
  @Column(name = "ISSUER", nullable = true, length = 35)
  private String issuer;

  protected ProprietaryBankTransactionCode() {}

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
