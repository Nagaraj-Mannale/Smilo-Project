Feature: Verify Mall Functionality

  Scenario: Successful login with Valid Credentials
    Given the browser is open and the URL is entered
    When the valid username and password are entered
    And the login button is clicked
    And the MallUser link and mall tab is clicked
    Then the Mall page text is validated

  Scenario: Verify Mall Add Functionality
    When the Add Mall button is clicked
    Then the user is on the Add Mall page
    When all the necessary data is filled for new Mall
    And the Save button is clicked   
    Then the new Mall is verified

  Scenario: Verify Mall Edit Functionality
    When a Mall is selected and the Edit button is clicked
    And the Mall name is modified and the Save button is clicked
    Then the modified mall name is verified
    
  Scenario: Verify Mall delete Functionality
    When a mall is selected and the delete button is clicked
    Then the mall should no longer appear in the list  
    
  