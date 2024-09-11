Feature: Verify Slot Functionality

  Scenario: Successful Login with Valid Credentials
    Given the browser is open and the URL is entered
    When the valid username and password are entered
    And the Login button is clicked
    And the MallUser link and Slot tab is clicked
    Then the Slot page text is validated

  Scenario: Verify Slot Add Functionality
    When the Add Slot button is clicked
    Then the user is on the Add Slot page
    When all the necessary data is filled for new Slot
    And the Save button is clicked
    Then the new Slot is verified

  Scenario: Verify Slot Edit Functionality
    When a Slot is selected and the Edit button is clicked
    And the Slot name is modified 
    And the Save button is clicked
    Then the modified Slot name is verified
 
  