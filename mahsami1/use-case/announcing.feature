Feature: Add Photos to Residence

  Scenario: Owner adds a photo to their residence
    Given The owner is logged in
    When The owner enter link Photo
    Then The photo should be added to the residence

  Scenario: Owner add the location and information of their residence
    Given The owner is logged in
    When The owner add the location of the residence and information about the residence
    Then The location and information of the residence should be add successfully

  Scenario: Owner adds and removes services for their residence
    Given The owner is logged in
    When The owner removes the service
    Then The service of the residence should be  removes successfully
    When The owner adds a new service
    Then The service  should be added to the available services list

  Scenario: Owner specifies whether the monthly rent includes electricity and water
    Given The owner is logged in
    When The owner specifies that the monthly rent includes electricity and water
    Then It should be indicated that the monthly rent is inclusive of electricity and water
    When The owner specifies that the monthly rent does not include electricity and water
    Then It should be indicated that the monthly rent is exclusive of electricity and water

  Scenario: Owner updates their contact information
    Given The owner is logged in
    When The owner updates their phone number to "123-456-7890"
    And The owner updates their email to "owner@example.com"
    Then The owner contact information should be updated successfully
