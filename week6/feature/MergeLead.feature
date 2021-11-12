Feature: Test Merge Lead functionality in LeafTaps
@regression
Scenario Outline: Merge two existing Lead IDs
Given Click Merge Leads Link
And Select a leads<leadName><dstnLeadName> to merge
When Click on merge Lead
Then First Lead ID should merged and should not be found<leadID>
And No records should be displayed

Examples:
|phoneNum|leadName|dstnLeadName|leadID|
|'99'|'Hari'|'babu'|'10128'|
