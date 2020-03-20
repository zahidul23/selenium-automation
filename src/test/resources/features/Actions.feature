@test
Feature: Testing actions on Actions and Scrolling page


Scenario: Dragging and dropping element
	Given user is on actions page
	When user drags and drops the element
	Then the element is located in the target 
	
Scenario: Doubling clicking on element
	Given user is on actions page
	When user double clicks on target
	Then background color of target has changed
	
Scenario: Hovering over elements
	Given user is on actions page
	When user hovers through boxes
	Then link boxes will be displayed
	

Scenario: Clicking and holding on element
	Given user is on actions page
	When user clicks and holds target
	Then box text will read Well done
			
Scenario: Hovering over top zone on scrolling page
	Given user is on scrolling page
	When user hovers over top zone
	Then text will read Well done for scrolling

		
Scenario: Hovering over side zones on scrolling page
	Given user is on scrolling page
	When user hovers over side zones
	Then zone text will display entered count
			
Scenario: Hovering over bottom zone on scrolling page
	Given user is on scrolling page
	When user hovers over bottom zone
	Then text will show entry coordinate