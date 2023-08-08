@tag
Feature: Control Panel Access
  As a housing owner
  I want to access my control panel
  So that I can manage my housing units and communicate with tenants

  Background:
    Given The owner is Logged in

  Scenario: Accessing control panel
    When I access my control panel
    Then I should see a list of my housing units

  Scenario: Upon choosing a Housing Unit
    When I choose housing unit with ID 1
    Then I should see that it has 125 Tenants and 9 Floors

  Scenario: Upon choosing Specific Floor
  Given I have chose housing unit with ID 1
    When I choose the Floor with ID 3
    Then I should see that it has 40 Apartements
    
  Scenario: Upon choosing Specific Apartment
  Given I have chose housing unit with ID 1
  And I choose the Floor with ID 3
  	When I choose the Apartment with ID 1
    Then I should see that it has 2 Tenants
    And Their names being "Ali" and "Omar"
		And the means of communication with them should be displayed "Ali@email.com","Omar@email.com"
    And the number of bathrooms being 2
    And the number of bedrooms being 4
    And  if it has a balcony of not being true
