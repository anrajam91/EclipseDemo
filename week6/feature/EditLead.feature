Feature: Test Edit Lead functionality in LeafTaps
@functional @sanity
Scenario Outline: Edit the existing Lead details
Given Enter <phoneNum> to find leads
And Click on Find Leads
And Select a Lead from list
When Click on Edit button 
Then Update the <companyName> in Edit Lead Page
And Page landed to View Lead page <title>

Examples:
|phoneNum|companyName|title|
|'99'|'Wipro'|'View Lead'|