@PIMTest
Feature: OrangeHRM PIM Test
  Test PIM Functionality of OrangeHRM

@AddEmployee
Scenario: Add Employee to Database
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then Validate Header Title of Page is "Dashboard"
When User Select "PIM" from Main Menu
Then Validate Header Title of Page is "PIM"
And Validate Title of Table is "Employee Information"
When User clicks on Add
Then Validate Main Title of Page is "Add Employee"
When User enter Employee Information
And User Submit Employee Information
Then Success Message is Displayed
And Validate Main Title of Page is "Personal Details"
Examples:
| username | password |
| Admin    | admin123 |

@DeleteEmployee
Scenario: Delete Employee from Database
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then Validate Header Title of Page is "Dashboard"
When User Select "PIM" from Main Menu
Then Validate Header Title of Page is "PIM"
And Validate Title of Table is "Employee Information"
When User clicks on Delete button
Then Confirmation Popup is Displayed
When User confirms Deletion
Then Success Message is Displayed
And Validate Header Title of Page is "PIM"
Examples:
| username | password |
| Admin    | admin123 |
