package ch.raiffeisen.openbank.account.persistency.model;

/**
 * Specifies the sub type of account (product family group).
 * 
 * @author Goekhan Demirkiyik
 * @see https://openbanking.atlassian.net/wiki/spaces/DZ/pages/129040604/Accounts+v2.0.0
 */
public enum AccountSubType {
  // Account sub-type is a Charge Card.
  ChargeCard,
  // Account sub-type is a Credit Card.
  CreditCard,
  // Account sub-type is a Current Account.
  CurrentAccount,
  // Account sub-type is an EMoney.
  EMoney,
  // Account sub-type is a Loan.
  Loan,
  // Account sub-type is a Mortgage.
  Mortgage,
  // Account sub-type is a PrePaid Card.
  PrePaidCard,
  // Account sub-type is a Savings.
  Savings;
}
