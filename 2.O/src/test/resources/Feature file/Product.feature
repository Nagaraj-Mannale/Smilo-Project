Feature: Verify the Product Feature

Scenario: Successful Login with Valid Credentials
Given the browser is open and the URL is entered
When the valid username and password are entered
And the Login button is clicked
And the Settings link is clicked, followed by the Serv&Cat tab, then Product
Then the Product page text is validated

Scenario: Verify Product Add Functionality
When the Add Product button is clicked
Then the user should be redirected to the Product Add page
When all the necessary data is entered for the new Product
And the Save button is clicked
Then the newly added Product is verified

Scenario: Verify Product Edit Functionality
When a Product is selected and the Edit button is clicked
And the Product name is modified and the Save button is clicked
Then the modified Product name is verified

Scenario: Verify Product Delete Functionality
When a Product is selected and the Delete button is clicked
Then the Product should no longer appear in the list