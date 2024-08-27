Feature: Verify Lead functionality

  Scenario: Successful Login with Valid Credentials
    Given the browser is open and the URL is entered
    When the valid username and password are entered
    And the Login button is clicked
    And the lead link is clicked
    Then the lead page text is validated

  Scenario: Importing and Adding a Lead
    When the Import button is clicked
    And the Add button is clicked
    Then the lead add page text is validated

  Scenario: Navigating and Performing Actions on Lead Page
    When the user navigates back to the lead home page
    And the Convert button is clicked
    And the Delete button is clicked
    And the Export link is clicked
    And the page limit is set to 25, 50, and 100
    Then the records on the page are verified

  Scenario: Resetting and Verifying Lead Page
    When the reset button is clicked
    Then verify the page limit is set correctly

  Scenario: Applying City Filter
    When the city dropdown is applied
    Then verify the city column reflects the selected city

  Scenario: Searching Lead by Name
    When the lead is searched by name
    Then validate the received records

  Scenario: Applying Date Filter
    When the reset button is clicked
    And the From date and To date are set
    And the set button is clicked
    Then verify the received records meet the applied filter criteria

  Scenario: Viewing and Editing Lead Details
    When the View button is clicked
    Then verify the lead view page is displayed
    When the Edit button is clicked
    Then verify the lead edit page is displayed

  Scenario: Deleting a Lead
    When the Delete button is clicked
    Then verify the record is deleted

  Scenario: Logging Out
    And the user logs out of the account
