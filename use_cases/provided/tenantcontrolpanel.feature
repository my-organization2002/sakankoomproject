Feature: Tenant Control Panel
Scenario: Tenant views personal data
Given the tenant has made a booking
When the tenant accesses the control panel
Then the tenant can view their personal data


Scenario: Tenant views residence owner information
Given the tenant has made a booking
When the tenant accesses the control panel
Then the tenant can view the name and contact information of the residence owner

Scenario: Tenant views rent payment details
Given the tenant has made a booking
When the tenant accesses the control panel
Then the tenant can see when the next rent payment is due