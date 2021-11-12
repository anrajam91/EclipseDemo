Feature: Test Edit Lead functionality in LeafTaps
@functional @regression @smoke
Scenario Outline: Duplicate the existing Lead details
Given Enter <phoneNum> to find leads
And Click on Find Leads
And Select a Lead from list
When Click on Duplicate Lead button 
Then Click Submit on Duplicate Lead page
And Page landed to View Lead page <title>

Examples:
|phoneNum|companyName|title|
|'99'|'Wipro'|'View Lead'|