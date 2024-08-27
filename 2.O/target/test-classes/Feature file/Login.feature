Feature: Verify Login Functionality

Scenario: Successful Login with Valid Credentials
Given the browser is open and the URL is entered
When the valid username and password are entered
And the Login button is clicked
Then the landing page text is validated
And close the browser

Scenario: Unsuccessful Login with Invalid Password
Given the browser is open and the URL is entered
When a valid username and an invalid password are entered
And the Login button is clicked
Then the error page is validated
And close the browser

Scenario: Unsuccessful Login with Invalid Username
Given the browser is open and the URL is entered
When an invalid username and a valid password are entered
And the Login button is clicked
Then the error page is validated
And close the browser

Scenario: Unsuccessful Login with Empty Credentials
Given the browser is open and the URL is entered
When both the username and password fields are left empty
And the Login button is clicked
Then verify the warning message
And close the browser