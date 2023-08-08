Feature: Watching Reservations via the System

Background:
    Given The System Administrator is Logged in

Scenario: System Administrator views the list of reservations
    Given the System Administrator accesses the system
    When the System Administrator navigates to the reservations section
    Then the System Administrator can view a list of reservations

Scenario: System Administrator views the details of a reservation
    Given the System Administrator has a reservation with ID 123
    When the System Administrator selects the reservation with ID 123
    Then the System Administrator can view the details of the reservation

Scenario: System Administrator approves a reservation
    Given the System Administrator has a reservation with ID 456
    When the System Administrator selects the reservation with ID 456
    And approves the reservation
    Then the reservation is accepted, and the housing unit is reserved

Scenario: System Administrator rejects a reservation
    Given the System Administrator has a reservation with ID 789
    When the System Administrator selects the reservation with ID 789
    And rejects the reservation with the reason "Unavailable Dates"
    Then the reservation is rejected, and the housing unit remains available for booking
