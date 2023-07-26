Feature: Furniture Advertising

Background:
    Given The Tenant is Logged in
    
Scenario: Tenant advertises used furniture for sale
Given the tenant wants to advertise used furniture

When creates a furniture advertisement:
|furniture name |price |
|sofa|20$|
|tv| 100$|

Then the furniture ad is posted on the app