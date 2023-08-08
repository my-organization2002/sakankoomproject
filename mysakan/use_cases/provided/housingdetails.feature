Feature: Tenant views housing details

Background:
    Given The Tenant is Logged in

Scenario Outline: Tenant views housing details
Given the tenant selects a housing unit with id = <housingUnitId>
Then the tenant views pictures:
  | Photo Name   | Photo URL                              |
  | Living Room  | https://example.com/photos/living.jpg   |
  | Bedroom      | https://example.com/photos/bedroom.jpg  |
And the price is <price>
And the location is:
    | City Name | Street Name |
    | <city>    | <street>    |
And the available services of the housing are:
    | Service        |
    | Wi-Fi          |
    | Gym Access     |
    | Parking Space  |

Examples:
  | housingUnitId | price | city     | street     |
  | 1             | $560  | Nablus   | Rafidia    |
  | 2             | $700  | Ramallah | City Center|
