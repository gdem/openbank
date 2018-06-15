package ch.raiffeisen.openbank.offer.persistency.model;

/**
 * Offer type, in a coded form.
 * 
 * @author Goekhan Demirkiyik
 */
public enum OfferType {
  // Offer is a balance transfer.
  BalanceTransfer,
  // Offer is a limit increase.
  LimitIncrease,
  // Offer is a money transfer.
  MoneyTransfer,
  // Offer is of an other type.
  Other,
  // Offer is a promotional rate.
  PromotionalRate
}
