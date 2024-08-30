Feature: Verify MallUser Functionality

  Scenario: Successful Login with Valid Credentials
    Given the browser is open and the URL is entered
    When the valid username and password are entered
    And the Login button is clicked
    And the MallUser link is clicked
    Then the User page text is validated

  Scenario: Verify MallUser Add Functionality
    When the Add User button is clicked
    Then the user is on the Add User page
    When all the necessary data is filled
    And the Save button is clicked   
    Then the new MallUser is verified

  Scenario: Verify MallUser Edit Functionality
    When a user is selected and the Edit button is clicked
    And the name is modified and the Save button is clicked
    Then the modified user name is verified
    
  Scenario: Verify MallUser delete Functionality
    When a user is selected and the delete button is clicked
    Then the user should no longer appear in the list  
    
  