Feature: Search laptops under $400 


@lenova
Scenario: Find out if there is a laptop under $400 
	Given I am on the lenova homepage 
	When I click laptops and select i7 processer 
	Then It should collect the price if it is under $400 