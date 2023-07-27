Feature: Tenant views student housing details

Background:
    Given The Tenant is Logged in

Scenario: Tenant views student housing details
    Given the tenant selects a student housing unit with id = 1
    Then the tenant views pictures:
      | Photo Name      | Photo URL                             |
      | Living Room     | https://example.com/photos/living.jpg  |
      | Bedroom         | https://example.com/photos/bedroom.jpg |
    And the price is $560
    And the location is:
      | City Name | Street Name |
      | Nablus    | Rafidia     |
    And the available services of the housing are:
      | Service       |
      | Wi-Fi         |
      | Gym Access    |
      | Parking Space |
    And the tenant can view general data about the people living in the housing:
      | Name    | Age | University Major |
      | John    | 22  | Computer Science |
      | Sarah   | 21  | Business         |
