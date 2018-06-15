package ch.raiffeisen.openbank.transaction.persistency.model;

public enum ExternalCardAuthorisationType {
  // Card authorisation was via Contactless.
  Contactless,
  // No card authorisation was used.
  None,
  // Card authorisation was via PIN.
  PIN
}
