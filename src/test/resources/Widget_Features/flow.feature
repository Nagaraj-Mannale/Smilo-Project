Feature: verify the flow of the widget

@smoke
Scenario: verify the OHR flow
   Given launch the browser and enter the URL
   Then ensure your on getStarted page
   When click on get start button
   Then ensure your on the purpose Of Visit Page
   When select one card and click on the continue button
  # Then ensure your on the consent Agreement page 
   When click on the continue button
  # Then ensure your on the preference Page
   When select the OHR card and click on the continue button
  # Then ensure you are on the upload image page
   When upload an image from your local space 
   And  click on the get result button
  # Then ensure you are on the contact info page
   When fill all the necessary information and click on the submit button
   Then Ensure you are on the result page with cards
   And verify the all cards buttons are enabled 