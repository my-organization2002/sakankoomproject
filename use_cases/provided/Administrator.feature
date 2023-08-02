Feature: Scenes of Requests for Advertisement of Housing

Background:
    Given The Administrator is Logged in

Scenario: Administrator views housing advertisement requests
    Given the administrator accesses the app
    When the administrator navigates to the housing advertisement requests section
    Then the administrator can view a list of housing advertisement requests

Scenario: Administrator reviews a housing advertisement request
    Given the administrator has a housing advertisement request with ID 123
    When the administrator selects the housing advertisement request with ID 123
    Then the administrator can view the details of the housing advertisement request

Scenario: Administrator accepts a housing advertisement request
    Given the administrator has a housing advertisement request with ID 456
    When the administrator selects the housing advertisement request with ID 456
    And approves the request
    Then the housing advertisement request is accepted, and the housing unit is advertised

Scenario: Administrator rejects a housing advertisement request
    Given the administrator has a housing advertisement request with ID 789
    When the administrator selects the housing advertisement request with ID 789
    And rejects the request with the reason "Insufficient Information"
    Then the housing advertisement request is rejected, and the housing unit is not advertised