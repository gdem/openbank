package ch.raiffeisen.openbank.branch.persistency.model;

/**
 * Service/Facilities offered at a branch.
 * 
 * @author Goekhan Demirkiyik
 */
public enum ServiceAndFacility {
  // Branch provides assisted service counters which are machines providing a wide range of banking
  // facililities similar to those provided by counter services
  AssistedServiceCounter,
  // The branch provides an external ATM
  ExternalATM,
  // Branch provides AVS verifying, for instance, Account Holders (Name /Company No), Account (Code,
  // Branch No, Status, Type, Length open and if it accapts debits/credits)
  AccountVerificationService,
  // The branch has a business counter
  BusinessCounter,
  // The branch provides Bureau de Change services
  BureauDeChange,
  // The branch provides automated terminals for taking business deposits
  BusinessDepositTerminal,
  // The branch provides business IT consultancy services
  BusinessITSupport,
  // The branch provides a card issuance facility. Note this is usually an emergency for issuing
  // standard debit cards with personalised magnetic stripe and chip data only.
  CardIssuanceFacility,
  // The branch has Click and Collect Lockers
  CollectionLockers,
  // The branch provides counter teller services
  CounterServices,
  // The branch provides one or more external quick service points, which are machines providing
  // banking services.
  ExternalQuickServicePoint,
  // The branch provides internal quick service points, which are machines providing banking
  // services.
  InternalQuickServicePoint,
  // The branch provides an internal ATM
  InternalAtm,
  // The branch provides lodgement devices which are ATMs which can accept cash and cheque deposits
  LodgementDevice,
  // The branch provides mortgage advisor services
  MortgageAdvisor,
  // The branch has meeting rooms for customer interaction
  MeetingRooms,
  // The branch has a night safe
  NightSafe,
  // The branch provides facilities for on-line banking
  OnlineBankingPoint,
  // The branch can provide foreign currency on demand.
  OnDemandCurrency,
  // Used to indicate that the Branch Self Service code does not exist in this standard code list.
  // Use OtherSelfService to supply code, name & description.
  Other,
  // The branch has parking facilities
  Parking,
  // The branch has a couter for the banks premier account customers
  PremierCounter,
  // The branch provides quick deposit devices for automatic deposition of cash and cheques.
  QuickDeposit,
  // The branch provides a Saturday counter service
  SaturdayCounterService,
  // The branch has a statement printer
  StatementPrinter,
  // The branch offers a digital service for account opening.
  SelfServiceAccountOpening,
  // The branch has a video banking terminal for remote banking services.
  VideoBanking,
  // The branch has Wi-Fi facilities for use by its customers
  WiFi;
}
