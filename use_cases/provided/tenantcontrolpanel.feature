Feature: Tenant Control Panel
Scenario: Tenant views personal data

When the tenant has made a booking
 Then A Control Panel Appears That Has The Tenants Personal Data, The Name: "Ahmad", The Email: "Ahmad@email.com", The Number: "0542555444"
And The name of the residence owner being:"sami" and his contact information being:"sami@email.com" 
And The rent pay check be at "18/7/2023"

