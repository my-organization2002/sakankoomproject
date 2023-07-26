
Feature: Tenant



  Background:
    Given The Tenant is Logged in
    
    
    
Scenario: Tenant views available housing
Given the tenant accesses the app
When the tenant navigates to the available housing section
Then the tenant can view a list of housing units




Scenario: Tenant books accommodation
Given the tenant has selected a housing unit
When the tenant makes a booking request
Then the booking is confirmed, and the housing unit is reserved for the tenant


