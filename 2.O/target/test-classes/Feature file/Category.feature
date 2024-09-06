Feature: Verify the Category Feature

Scenario: Successful Login with Valid Credentials
Given the browser is open and the URL is entered
When the valid username and password are entered
And the Login button is clicked
And the Settings link is clicked, followed by the Serv&Cat tab, then Category
Then the Category page text is validated

Scenario: Verify Category Add Functionality
When the Add Category button is clicked
Then the user should be redirected to the Category add page
When all the necessary data is entered for the new Category
And the Save button is clicked
Then the newly added Category is verified

Scenario: Verify Category Edit Functionality
When a Category is selected and the Edit button is clicked
And the Category name is modified and the Save button is clicked
Then the modified Category name is verified

Scenario: Verify Category Delete Functionality
When a Category is selected and the Delete button is clicked
Then the Category should no longer appear in the list