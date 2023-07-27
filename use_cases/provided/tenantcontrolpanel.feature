Feature: Tenant Control Panel
  Background:
    Given The Tenant is Logged in
    And The Tenant has Booked an Appartment
Scenario:  presence of tenant control panel
Then the tenant can see his name "Ahmad" and his age 21 and his email "Ahmad@email.com" and his phoneNumber "0542111222"
And the tenant can see the residence owner information:
|Contact Name| Email|Phone|
      | Saleem           | Saleem@email.com       |+1 (555) 123-4567       |
And the rent payment deadline being at "31-08-2023"