package ch.raiffeisen.openbank.balance.persistency.model;

public enum CreditLineType {

  // The amount of credit limit available to the account holder
  Available,
  // The amount of a credit limit that has been agreed with the account holder
  Credit,
  // The amount of an arranged lending limit that can be borrowed on top of pre-agreed lending, that has been agreed with the account holder
  Emergency,
  // The amount of a temporary lending limit that has been agreed with the account holder
  Temporary,
  // The amount of an arranged lending limit that has been agreed with the account holder
  PreAgreed;
}
