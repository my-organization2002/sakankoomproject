Feature: Tenant

Background:
    Given The Tenant is Logged in

Scenario: Tenant views available housing
    Given the tenant accesses the app
    When the tenant navigates to the available housing section
    Then the tenant can view a list of available housing units

Scenario: Tenant books accommodation for housing unit with ID 1
    Given the tenant has selected a housing unit with ID 1
    When the tenant makes a booking request
    Then the booking request for housing unit with ID 1 is confirmed
    And the housing unit with ID 1 is reserved for the tenant
