@LoginTest
Feature: OrangeHRM Login Test
  Test Login Functionality of OrangeHRM

@ValidUser
Scenario: Login with Valid Credentials
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then Validate Header Title of Page is "Dashboard"
Examples:
| username | password |
| Admin    | admin123 |

@InvalidUser
Scenario: Login with Invalid Credentials
Given Login page is Displayed
When User enters "<username>" and "<password>" 
And Clicks on Login
Then Invalid Credentials Error is Displayed
Examples:
| username | password |
| Pra      | admin123 |