@PIMTest
Feature: OrangeHRM PIM Test
  Test PIM Functionality of OrangeHRM

@AddEmployee
Scenario: Add Employee to Database
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then "Dashboard" Page is Displayed
When User Select "PIM" from Main Menu
Then "PIM" Page is Displayed
When User clicks on Add
Then "Add Employee" Page is Displayed
When User enter Employee Information
And User Submit Employee Information
Then Success Message is Displayed
And "Personal Details" Page is Displayed
Examples:
| username | password |
| Admin    | admin123 |

@DeleteEmployee
Scenario: Delete Employee from Database
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then "Dashboard" Page is Displayed
When User Select "PIM" from Main Menu
Then "PIM" Page is Displayed
When User clicks on Delete button
Then Confirmation Popup is Displayed
When User confirms Deletion
Then Success Message is Displayed
And "PIM" Page is Displayed
Examples:
| username | password |
| Admin    | admin123 |