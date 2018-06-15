package ch.raiffeisen.openbank.common.repository.model;

/**
 * Identifies the nature of the postal address.
 * 
 * @author Goekhan Demirkiyik
 */
public enum AddressType {
  // Address is the business address.
  Business,
  // Address is the address where correspondence is sent.
  Correspondence,
  // Address is the address to which delivery is to take place.
  DeliveryTo,
  // Address is the address to which mail is sent.
  MailTo,
  // Address is a postal office (PO) box.
  POBox,
  // Address is the complete postal address.
  Postal,
  // Address is the home address.
  Residential,
  // Address is the address where statements are sent.
  Statement;
}
