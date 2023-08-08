Feature: Announce Private Residence
  As a housing owner
  I want to announce my private residence for rent
  So that potential tenants can view the available options and contact me

  Background:
    Given That owner is Logged in

  Scenario: Announce a Private Residence With All Options
    When I choose to announce my private residence with ID 1
    And I add the following photos:
      | Photo Name       | Photo URL                              |
      | Living Room      | https://example.com/photos/living.jpg   |
      | Bedroom          | https://example.com/photos/bedroom.jpg  |
    And provide the following details about the residence:
      | Residence Name   | Cozy Apartment                         |
      | Address          | 123 Main Street                        |
      | Description      | A lovely apartment with great amenities |
    And specify the following available services:
      | Service         |
      | Wi-Fi           |
      | Gym Access      |
      | Parking Space   |
    And set the monthly rent amount to $1200
    And specify that the rent includes electricity and water
    And provide the following contact information:
      | Contact Name    | John Doe                   |
      | Email           | john.doe@example.com       |
      | Phone           | +1 (555) 123-4567         |
    Then the private residence should be successfully announced

  Scenario: Announce a Private Residence With Non-Existing ID
    Given I am trying to add a residence with ID 5 that does not exist
    And I add the following photos:
      | Photo Name       | Photo URL                              |
      | Living Room      | https://example.com/photos/living.jpg   |
      | Bedroom          | https://example.com/photos/bedroom.jpg  |
    And provide the following details about the residence:
      | Residence Name   | Cozy Apartment                         |
      | Address          | 123 Main Street                        |
      | Description      | A lovely apartment with great amenities |
    And specify the following available services:
      | Service         |
      | Wi-Fi           |
      | Gym Access      |
      | Parking Space   |
    And set the monthly rent amount to $1200
    And specify that the rent includes electricity and water
    And provide the following contact information:
      | Contact Name    | John Doe                   |
      | Email           | john.doe@example.com       |
      | Phone           | +1 (555) 123-4567         |
    Then I Should get A Message "The ID of the residence you're trying to announce does not exist"

  Scenario: Select housing unit with matching ID
    Given The owner has the following housing units:
      | Residence ID | Residence Name |
      | 1            | Apartment A    |
      | 2            | Apartment B    |
    When The owner selects housing unit with ID 1
    Then The selected housing unit should be "Apartment A"

  Scenario: Select housing unit with non-matching ID
    Given The owner has the following housing units:
      | Residence ID | Residence Name |
      | 1            | Apartment A    |
      | 2            | Apartment B    |
    When The owner selects housing unit with ID 3
    Then No housing unit should be selected

  Scenario: Select housing unit from an empty list
    Given The owner has no housing units
    When The owner selects housing unit with ID 1
    Then No housing unit should be selected

  Scenario: Select housing unit from a list with a single unit
    Given The owner has the following housing units:
      | Residence ID | Residence Name |
      | 1            | Apartment A    |
    When The owner selects housing unit with ID 1
    Then The selected housing unit should be "Apartment A"