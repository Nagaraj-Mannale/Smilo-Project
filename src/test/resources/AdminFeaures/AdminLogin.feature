Feature: Ensure login functionalities are working fine

Scenario: logging with valid credentials
Given the user launches the browser and enters the application URL
When enter the email and pwd and click on the signin button
And extract the otp from mail and enter into the otp fields and click on the save button
Then ensure user on the dashboard page



