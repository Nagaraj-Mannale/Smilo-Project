Feature: Verify Dashboard functionality

  Scenario: Successful Login with Valid Credentials
   Given the browser is open and the URL is entered
   When the valid username and password are entered
   And the login button is clicked
   Then the landing page text is validated
        
  #Scenario: Verify the Dashboard lead generated data
   #When get the today this week and this month generated count data
   #And the lead link is clicked
   #And add the new lead
   #Then Validate the new added lead
   #When navigate to the dashboard
   #Then verify the lead generated count data
  
  Scenario: Verify the Dashboard lead converted data
   When get the today this week and this month converted count data
   And the lead link is clicked
   And  select one lead and click on convert button
   And navigate to the customer page
   Then verify the converted lead in the customer page
   When navigate to the dashboard
   Then verify the lead converted count data
   