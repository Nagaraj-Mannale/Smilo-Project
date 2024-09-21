Feature: Validate the data flow from Order to Dashboard

Scenario: Successful Login with Valid Credentials
 Given the browser is open and the URL is entered
 When the valid username and password are entered
 And the login button is clicked
      
Scenario: Validate the order services and Sales generated data flow
When the order link is clicked
And the current date filter is applied
And the Sub Total data is collected except cancel order for "day"
And the current week date filter is applied
And the Sub Total data is collected except cancel order for "week"
And the current month date filter is applied
And the Sub Total data is collected except cancel order for "month"
And calculate the Order Services	
And navigate to the dashboard
And get the data from the dashboard
Then verify the data with dashboard data    
   
   
   
   