Feature: Furniture Advertising

Background:
    Given The Tenant is Logged in
    
Scenario: Tenant advertises used furniture for sale
Given the tenant wants to advertise used furniture
When the tenant accesses the furniture window
And creates a furniture advertisement
Then the furniture ad is posted on the app