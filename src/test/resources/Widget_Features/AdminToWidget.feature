Feature: verifying the redirection of admin to widget flow

Scenario:
Given the user launches the browser and enters the application URL
 When enter the email and pwd and click on the signin button
 Then extract the otp from mail and enter into the otp fields and click on the save button
  And ensure user on the dashboard page
 When the user navigates to the Practitioner page
 Then the user should be on the Practitioner page
 When the user searches for the practitioner and clicks the edit button
 Then the user should be redirected to the Company Info page
 When navigate to the setting page
 Then the user should be on the Settings page
  And capture the changes in the setting page and click on the save button
 Then the user should be redirected to the home page with a success message
#And close the browser
 When launch the widget browser with the valid token	
  And click on get start button 
  And select one card and click on the continue button
  And click on the continue button
 Then ensure your on the preference Page
 Then ensure the cards displaying according to configure in the admin portal
 When select the OHR card and click on the continue button
 #Then ensure you are on the upload image page
 When upload images from your local space and click on result button
   | /home/active35/Downloads/5Images/1st.jpeg |
   | /home/active35/Downloads/5Images/2nd.jpeg |
   | /home/active35/Downloads/5Images/3rd.jpeg |
   | /home/active35/Downloads/5Images/4th.jpeg |
   | /home/active35/Downloads/5Images/5th.jpeg |
   | /home/active35/Downloads/5Images/1st.jpeg |
 Then ensure image count is match with the admin configure  
 When fill all the necessary information and click on the submit button
 Then Ensure you are on the result page with cards
  And verify the all cards are present as configure in the admin 

