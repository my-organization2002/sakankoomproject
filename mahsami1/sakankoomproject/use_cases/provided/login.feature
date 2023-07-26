Feature: Administrator loginn
	Description: The administrator logs in
	Actor: Administrator
Scenario: Administrator can loginn
Given the administrator is not logged in
And the password is "12345"
Then the administrator login succeeds
And the administrator is logged in
