Feature: Verify the Service Feature

Scenario: Successful Login with Valid Credentials
Given the browser is open and the URL is entered
When the valid username and password are entered
And the Login button is clicked
And the "Settings" link is clicked, followed by the "Serv&Cat" tab, then "Service"
Then the Service page text is validated

Scenario: Verify Service Add Functionality
When the "Add Service" button is clicked
Then the user should be redirected to the Service Mall page
When all the necessary data is entered for the new Service
And the "Save" button is clicked
Then the newly added Service is verified

Scenario: Verify Service Edit Functionality
When a Service is selected and the "Edit" button is clicked
And the Service name is modified and the "Save" button is clicked
Then the modified Service name is verified

Scenario: Verify Service Delete Functionality
When a Service is selected and the "Delete" button is clicked
Then the Service should no longer appear in the list