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
 * This entity represents the merchant details
 * 
 * @author Goekhan Demirkiyik
 */
@Entity
@Table(name = "TRANSACTION_MERCHANT_DETAIL")
public class MerchantDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "TRANSACTION_ID")
  private Transaction transaction;


  /**
   * Name by which the merchant is known.
   */
  @Column(name = "MERCHANT_NAME", length = 350, nullable = true)
  private String merchantName;


  /**
   * Category code conform to ISO 18245, related to the type of services or goods the merchant
   * provides for the transaction.
   */
  @Column(name = "MERCHANT_CATEGORY_CODE", length = 4, nullable = true)
  private String merchantCategoryCode;


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
