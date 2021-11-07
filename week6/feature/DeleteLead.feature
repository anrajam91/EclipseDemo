Feature: Test Delete Lead functionality in LeafTaps
Scenario Outline: Delete the existing Lead
Given Enter <phoneNum> to find leads
And Click on Find Leads
And Select a Lead from list
When Click on Delete Lead button 
Then Deleted <leadID> is not present
And No records should be displayed

Examples:
|phoneNum|leadID|
|'99'|'10458'|