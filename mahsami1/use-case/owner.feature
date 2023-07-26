@tag
Feature: controlpanel
  As a housing owner
  I want to access my control panel
  So that I can manage my housing units and communicate with tenants

  Scenario: Access owner control panel
    Given The owner is logged in
    When i access my control panel
    Then i should see a list of my housing units

  Scenario: Access Owner Control Panel and View Housing Unit Details
    Given the owner is logged in
    When I access my control panel
    Then I should see a list of my housing units
    And I enter one of the housing units
    Then I should see the number of tenants and the number of floors of the residence

  Scenario: Viewing Apartments from a Specific Floor
    Given the owner is logged in
    When I choose a specific floor
    Then the apartments from that floor should appear
    And the names of the tenants and the means of communication with them should be displayed
    And the number of bathrooms, bedrooms, and if it has a balcony should be shown
