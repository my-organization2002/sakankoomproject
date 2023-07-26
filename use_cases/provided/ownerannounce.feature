#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Announce Private Residence
  As a housing owner
  I want to announce my private residence for rent
  So that potential tenants can view the available options and contact me

  Background:
    Given The owner is Logged in

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
   
