Feature: Test Create Lead functionality in LeafTaps
@functional @smoke
Scenario Outline: Create new Lead
Given Click Create Lead button
And Enter user primary details <compName>,<firstName>,<lastName>,<phoneNum>
When Click on Submit button
Then View the new lead information <firstName>
And Page landed to View Lead page <title>

Examples:
|compName|firstName|lastName|phoneNum|title|
|'TestLeaf'|'Aadhi'|'Kalai'|'99'|'View Lead'|