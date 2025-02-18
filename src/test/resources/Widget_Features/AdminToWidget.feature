Feature: verifying the redirection of admin to widget flow

Scenario:
Given the user launches the browser and enters the application URL
When enter the email and pwd and click on the signin button
Then ensure user on the dashboard page
When the user navigates to the Practitioner page
Then the user should be on the Practitioner page
When the user searches for the practitioner and clicks the edit button
Then the user should be redirected to the Company Info page
#When updates the required company info and clicks continue
#Then the user should be on the Contact Info page
#When the user updates the required contact info and clicks continue
#Then the user should be on the Settings page
#When the user saves the changes on the settings page 
And capture the changes in the setting page and click on the save button
#Then the user should be redirected to the home page with a success message
When launch the widget with valid token	
 And click on start now button 
 And navigate to select your preferences page
Then ensure the cards displaying according to configure in the admin portal
When select the OHR card and click on the continue button
Then ensure you are on the upload image page
When upload the image with counting
Then ensure the count is matches with admin page configaration
 And click on the get result button
When fill all the necessary information and click on the submit button
Then Ensure you are on the result page
 And ensure the cards are displayed as per the admin portal configuration

