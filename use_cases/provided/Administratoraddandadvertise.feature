Feature: Adding and Advertising Housing Units through the System

Background:
    Given The Administrator is Logged in

Scenario: Administrator adds a new housing unit
    Given the administrator accesses the app
    When the administrator adds a new housing unit with the following details:
      | Residence Name | Address       | Description                      |Residence ID|Rent Amount|Rent Inclusive |
      | New House      | 123 Main St   | A beautiful new house for rent   |1|1500|True|
    And specifies the available services:
      | Service       |
      | Wi-Fi         |
      | Gym Access    |
      | Parking Space |
    And sets the monthly rent amount to $1000
    And specifies that the rent includes electricity and water
    And provides the following contact information:
      | Contact Name | Email              | Phone          |
      | John Doe     | john@example.com   | +1 555-123-456 |
    Then the new housing unit is added and advertised through the system

