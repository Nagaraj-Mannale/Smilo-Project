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

#Scenario: Validate practitioner modification functionality
#When the user searches for the practitioner and clicks the edit button
#Then the user should be redirected to the Company Info page
#When updates the required company info and clicks continue
#Then the user should be on the Contact Info page
#When the user updates the required contact info and clicks continue
#Then the user should be on the Settings page
#When the user saves the changes on the settings page
#Then the user should be redirected to the home page with a success message
#And logout from the application

Scenario: validate the setting page component functionality
When the user searches for the practitioner and clicks the edit button
And navigate to the setting page
Then ensure that atleast two widget buttons are selected; if not, make it two
And uncheck the OHR button if it selected previously
Then all components except dabour should hidden
When select the OHR button
Then verify all the components are displayed
When select OHR widget button and select the OHR normal flow
Then CTA Purchase a detailed report option should be hide
When the user selects "Request for an Appointment" in CTA
Then D4W and CorePractice options should be displayed
When the user selects D4W as "Yes"
Then the D4W Practice ID field should be displayed and enabled
When the user unchecks "Request for an Appointment" if selected
Then D4W and corepractice options should not be displayed
When select OHR widget button and select the OHR "Reverse flow"
Then "Purchase a detailed report" option should displayed
When the user selects "Purchase a Detailed Report" option
Then the Payment option should be displayed
When the user unselects "Purchase a Detailed Report" option
Then the Payment option should not be displayed

  

