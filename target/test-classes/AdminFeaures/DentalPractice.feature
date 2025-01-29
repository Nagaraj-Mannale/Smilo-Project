Feature: Ensure dental practice functionalities are working

Scenario: Validate practitioner creation functionality

Given the user launches the browser and enters the application URL
When enter the email and pwd and click on the signin button;
Then ensure user on the dashboard page
When the user navigates to the Practitioner page
Then the user should be on the Practitioner page
When the user clicks the Add button
Then the user should be redirected to the Company Info page
When the user fills in all required details and clicks the Continue button
Then the user should be on the Contact Info page
When the user fills in all required details and clicks the Continue button
Then the user should be on the Settings page
When the user fills in all required details and clicks the Continue button
Then the user should be redirected to the Home page, and the newly created practitioner should be listed