
Feature: Tenant views housing details 
Scenario: Tenant views housing details 
Given the teant selects a  housing unit with id =1 
Then the tenant  view pictures:
  | Photo Name       | Photo URL                              |
  | Living Room      | https://example.com/photos/living.jpg   |
  | Bedroom          | https://example.com/photos/bedroom.jpg  |
And prices=560$
And location:
	| City Name       | Street name  |
  | Nablus   			  |  Rafidia		  |
And available services of the housing:
 		 | Service         |
     | Wi-Fi           |
     | Gym Access      |
     | Parking Space   |
