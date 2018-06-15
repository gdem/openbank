package ch.raiffeisen.openbank.branch.persistency.model;

/**
 * Accessibility is the ability and ease a customer can access a service, good, associate, or
 * facility. Features which make the Bank accessible to disabled people
 * 
 * @author Goekhan Demirkiyik
 */
public enum Accessibility {
  // Access to the branch is provided by automatic doors
  AutomaticDoors,
  // The branch has ATM(s) that have a headphone jack
  AudioCashMachine,
  // Access to the branch is provided by means of an external ramp
  ExternalRamp,
  // Branches with Helping Hand units that contain items to assist customers who have a disability
  // to transact with us in the branch. This may include items such as: magnifiers, pen grips,
  // cheque templates, bank note gauges, clipboards and lap-pads
  HelpingHandUnit,
  // The branch has a hearing aid induction loop
  InductionLoop,
  // Access to the branch is provided by means of an internal ramp
  InternalRamp,
  // Level access to the branch not impeded by any step or ramp
  LevelAccess,
  // The branch counter is at a lower level, suitable for wheelchair users
  LowerLevelCounter,
  // Used to indicate that the code is not in this standard accessiblity list. Note:
  // OtherAccessibility can be used to supply the code, name and description.
  Other,
  // The branch is accessible by wheelchair users
  WheelChairAccess;
}
