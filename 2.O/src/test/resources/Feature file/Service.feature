Feature: Verify the Service Feature

Scenario: Successful Login with Valid Credentials
Given the browser is open and the URL is entered
When the valid username and password are entered
And the Login button is clicked
And the Settings link is clicked, followed by the Serv&Cat tab, then Service
Then the Service page text is validated

Scenario: Add a new service
  When the Add Service button is clicked
  Then the user should be redirected to the Service Add page
  When the user enters all necessary data on the General page
  And the Save button is clicked
  And the user fills in the service availability data on the Availability page
  And the Save button is clicked
  And the user enters the price based on the segment
  And the Save button is clicked
  And the user uploads an image
  And clicks the Save Changes button
  And the user uploads a video link
  And clicks the Save Changes button
  And the user either adds the new service or clicks the Cancel button to return to the home page
  Then the newly added service should be verified

Scenario: Verify Service Edit Functionality
When a Service is selected and the Edit button is clicked
And the Service name is modified
And the Save button is clicked 
And get back to the Service home page
Then the modified Service name is verified

Scenario: Verify Service Delete Functionality
When a Service is selected and the Delete button is clicked
Then the Service should no longer appear in the list