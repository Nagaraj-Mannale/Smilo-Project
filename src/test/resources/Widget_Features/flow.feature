Feature: verify the flow of the widget


Scenario: verify the OHR flow
   Given launch the widget browser with the valid token
   Then ensure your on getStarted page
   When click on get start button
   Then ensure your on the purpose Of Visit Page
   When select one card and click on the continue button
  #Then ensure your on the consent Agreement page
   When click on the continue button
   Then ensure your on the preference Page
   When select the OHR card and click on the continue button
  # Then ensure you are on the upload image page
   When upload images from your local space and click on result button
   | /home/active35/Downloads/5Images/1st.jpeg |
   | /home/active35/Downloads/5Images/2nd.jpeg |
   | /home/active35/Downloads/5Images/3rd.jpeg |
   | /home/active35/Downloads/5Images/4th.jpeg |
   | /home/active35/Downloads/5Images/5th.jpeg |
   Then ensure you are on the contact info page
   When fill all the necessary information and click on the submit button
   Then Ensure you are on the result page with cards
   #And verify the all cards buttons are enabled 