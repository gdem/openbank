package ch.raiffeisen.openbank.party.persistency.model;

/**
 * Party type, in a coded form.
 * 
 * @author Goekhan Demirkiyik
 */
public enum PartyType {
  // Party that has delegated access.
  Delegate,
  // Party is a joint owner of the account.
  Joint,
  // Party is a sole owner of the account.
  Sole
}
