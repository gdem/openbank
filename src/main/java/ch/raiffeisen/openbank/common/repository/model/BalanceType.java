package ch.raiffeisen.openbank.common.repository.model;

/**
 * Balance type, in a coded form.
 * 
 * @author Goekhan Demirkiyik
 */
public enum BalanceType {

  // Closing balance of amount of money that is at the disposal of the account owner on the date
  // specified.
  ClosingAvailable,
  // Balance of the account at the end of the pre-agreed account reporting period. It is the sum of
  // the opening booked balance at the beginning of the period and all entries booked to the account
  // during the pre-agreed account reporting period.
  ClosingBooked,
  // Balance, composed of booked entries and pending items known at the time of calculation, which
  // projects the end of day balance if everything is booked on the account and no other entry is
  // posted.
  Expected,
  // Forward available balance of money that is at the disposal of the account owner on the date
  // specified.
  ForwardAvailable,
  // Balance for informational purposes.
  Information,
  // Available balance calculated in the course of the account servicer's business day, at the time
  // specified, and subject to further changes during the business day. The interim balance is
  // calculated on the basis of booked credit and debit items during the calculation time/period
  // specified.
  InterimAvailable,
  // Balance calculated in the course of the account servicer's business day, at the time specified,
  // and subject to further changes during the business day. The interim balance is calculated on
  // the basis of booked credit and debit items during the calculation time/period specified.
  InterimBooked,
  // Opening balance of amount of money that is at the disposal of the account owner on the date
  // specified.
  OpeningAvailable,
  // Book balance of the account at the beginning of the account reporting period. It always equals
  // the closing book balance from the previous report.
  OpeningBooked,
  // Balance of the account at the previously closed account reporting period. The opening booked
  // balance for the new period has to be equal to this balance. Usage: the previously booked
  // closing balance should equal (inclusive date) the booked closing balance of the date it
  // references and equal the actual booked opening balance of the current date.
  PreviouslyClosedBooked;
}
