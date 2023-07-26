@tag
Feature: Administrator

  Scenario: Accepting and rejecting a housing advertisement request
    Given The Administrator is logged in
    When The administrator reviews the request
    Then The administrator can choose to accept or reject the request
    And The request status is updated accordingly

  Scenario: Administrator views reservations
    Given The Administrator is logged in
    When The administrator accesses the reservation monitoring dashboard
    Then The administrator can see a list of reservations
