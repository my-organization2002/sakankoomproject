
Feature: Student Housing Information
Scenario: Tenant views student housing details
Given the housing is for students
When the tenant accesses the student housing information
Then the tenant can view general data about  ages:
|age|
|"21"|
|"25"|

And university majors:
|university majors|
|"Najah national university"|
|"birzeit  national university"|
