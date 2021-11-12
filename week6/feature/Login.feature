Feature: Leaftaps Login Functionality
Background:
Given Open the chrome browser
And open the leaftaps url 'http://leaftaps.com/opentaps/'

Scenario Outline: Test with positive scenarios to login
Given Enter username as <username>
And Enter password as <password>
When Click on login button
Then Leaftaps homepage should be displayed

Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

Scenario Outline: Test with negative scenarios to login
Given Enter username as <username> and password as <password>
When Click on login button
But Error message should be displayed

Examples:
|username|password|
|'DemoSales'|'crmsfa'|