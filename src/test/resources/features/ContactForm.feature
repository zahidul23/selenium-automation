@test
Feature: Testing contact us form on WebDriverUniversity

Scenario Outline: Filling contact form with valid email
	Given user is on contact us page
	When user submits form <firstname> <lastname> <email> <message>
	Then user is shown thank you response
	
	Examples:
	|firstname|lastname|email|message|
	|Johnny|Test|jjjj@test.com|This is a test message|
	|J0hn|T3st|j.j@test.net|This is also a test message|


Scenario Outline: Filling contact form with invalid email
	Given user is on contact us page
	When user submits form <firstname> <lastname> <email> <message>
	Then user is shown error for invalid input
	
	Examples:
	|firstname|lastname|email|message|
	|Johnny|Test|jjjj@test/com|This is a test message|
	|J0hn|T3st|j.j@testtest|This is also a test message|