Feature: Validate the data flow from Order to Dashboard

Scenario: Successful Login with Valid Credentials
   Given the browser is open and the URL is entered
   When the valid username and password are entered
   And the login button is clicked
      
Scenario: Validate the order services and Sales generated data flow
When the order link is clicked
And the current date filter is applied
And the Sub Total data is collected
And the cancel request status filter is applied
And the updated Sub Total data is collected and subtracted from the previously collected value
And the current week date filter is applied
And the cancel request status filter is applied
And the updated Sub Total data is collected and subtracted from the previously collected value
And the current month date filter is applied
And the cancel request status filter is applied
And the updated Sub Total data is collected and subtracted from the previously collected value 
And calculate the Total data with and without GST
And navigate to the dashboard
Then verify the data with dashboard data    
   
   
   
   