@test
Feature: Testing WebDriverUniversity Portals

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


Scenario: Waiting and closing popups
	Given user is on the popups page
	When user clicks ajax loader button
	Then user is taken to the loading page
	When user waits for loader to complete
	And user clicks green button
	Then popup reads well done for waiting
	

Scenario: Closing js and modal popups
	Given user is on the popups page
	When user clicks js popup button
	Then user closes js popup
	When user clicks modal popup button
	Then user closes modal popup
	
Scenario Outline: Inputting valid date with datepicker
	Given user is on datepicker page
	When user inputs date <date>
	Then selected date matches <date>
	
	Examples:
	|date|
	|03-21-2020|
	|02-21-2020|
	|04-21-2020|
	|03-31-2022|


Scenario Outline: Inputting invalid date with datepicker
	Given user is on datepicker page
	When user inputs date <date>
	Then selected date does not match <date>
	
	Examples:
	|date|
	|03-41-2020|
	|02-29-2021|
	|15-21-2020|
	|5-0-2020|
	