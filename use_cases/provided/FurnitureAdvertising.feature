Feature: Furniture Advertising

Background:
  Given The Tenant is Logged in

Scenario: Tenant advertises used furniture for sale
  Given the tenant wants to advertise used furniture

  When the tenant creates the following furniture advertisements:
    | Furniture Name | Price |
    | Sofa          | 20$   |
    | TV            | 100$  |

  Then the furniture ads are posted on the app
  And the tenant can view the posted furniture advertisements