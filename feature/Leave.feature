@LeaveTest
Feature: OrangeHRM Leave Test
  Test Leave Functionality of OrangeHRM

@ApproveLeave
Scenario: Approve Leave for an Employee
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then Validate Header Title of Page is "Dashboard"
When User Select "Leave" from Main Menu
Then Validate Header Title of Page is "Leave"
And Validate Title of Table is "Leave List"
When User clicks on Approve
Then Success Message is Displayed
And Validate Header Title of Page is "Leave"
Examples:
| username | password |
| Admin    | admin123 |

