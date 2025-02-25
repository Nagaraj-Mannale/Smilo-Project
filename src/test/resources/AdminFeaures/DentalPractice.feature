Feature: Ensure Dental Practice Functionalities are Working

Background:
Given the user launches the browser and enters the application URL
When enter the email and pwd and click on the signin button
And extract the otp from mail and enter into the otp fields and click on the save button
Then ensure user on the dashboard page
When the user navigates to the Practitioner page
Then the user should be on the Practitioner page

#Scenario: Validate Practitioner Creation Functionality
#When the user clicks the Add button
#Then the user should be redirected to the Company Info page
#When the user fills in all required details and clicks the Continue button
#Then the user should be on the Contact Info page
#When the user fills in all required details and clicks the Continue button
#Then the user should be on the Settings page
#When the user fills in all required details and clicks the Continue button
#Then the user should be redirected to the Home page, and the newly created practitioner should be listed

Scenario: Validate practitioner modification functionality
When the user searches for the practitioner and clicks the edit button
Then the user should be redirected to the Company Info page
When updates the required company info and clicks continue
#Then the user should be on the Contact Info page
When the user updates the required contact info and clicks continue
Then the user should be on the Settings page
When the user saves the changes on the settings page
Then the user should be redirected to the home page with a success message


