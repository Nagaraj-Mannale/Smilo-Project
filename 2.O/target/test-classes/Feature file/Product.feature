Feature: Verify the Product Feature

Scenario: Successful login with Valid Credentials
Given the browser is open and the URL is entered
When the valid username and password are entered
And the login button is clicked
And the Settings link is clicked, followed by the Serv&Cat tab, then Product
Then the Product page text is validated

Scenario: Verify Product Add Functionality
When the Add Product button is clicked
Then the user should be redirected to the Product Add page
When the user enters all necessary data on the Product General page
And the Save button is clicked
And the user enters the Product price based on the segment
And the Save button is clicked
And the user uploads the Product image
And clicks the Save Changes button
And the user uploads the product video link
And clicks the Save Changes button
And the user either adds the new service or clicks the Cancel button to return to the Product home page
Then the newly added Product is verified

Scenario: Verify Product Edit Functionality
When a Product is selected and the Edit button is clicked
And the Product name is modified 
And the Save button is clicked
And return to the Product home page
Then the modified Product name is verified

Scenario: Verify Product Delete Functionality
When a Product is selected and the Delete button is clicked
Then the Product should no longer appear in the list