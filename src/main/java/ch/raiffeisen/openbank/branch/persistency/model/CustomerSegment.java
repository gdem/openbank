package ch.raiffeisen.openbank.branch.persistency.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum CustomerSegment {
  // The branch is able to provide services to business customers
  Business,
  // The branch is able to provide services to corporate customers
  Corporate,
  // Used to indicate that the Branch Customer Segment code does not exist in this standard code
  // list. Use OtherCustomerSegment to supply code, name & description.
  Other,
  // The branch is able to provide services to personal customers
  Personal,
  // The branch is able to provide services to private account holders
  Private,
  // The branch is able to provide services to premier account holders
  Premier,
  // The branch is able to provide services to select account holders
  Select,
  // The branch is able to provide services to SME customers
  SME,
  // The branch is able to provide wealth management services
  Wealth

}
