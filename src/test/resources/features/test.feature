Feature: Testing WebDriverUniversity Portals

Scenario: Clicking buttons on buttons page
	 When user clicks buttons
	 
@test	 
Scenario Outline: Selecting options on options page
	Given user is on options page
	When user selects languages <primarylanguage> <enviornment> <secondarylanguage>
	When user selects color <color>
	When user selects options <checkboxes>
	
	Examples: 
	|primarylanguage|enviornment|secondarylanguage|color|checkboxes|
	|python|eclipse|javascript|green|1,2,3|
	|java|junit|css|orange|1,3|
	|sql|maven|jquery|yellow|2,4|
	
Scenario: Closing popups
	When user clicks popup button
	
	
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