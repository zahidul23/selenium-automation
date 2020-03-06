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
