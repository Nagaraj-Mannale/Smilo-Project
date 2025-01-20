Feature: verify the flow of the widget

Scenario: verify the OHR flow
   Given launch the browser and enter the URL
   Then ensure your on the first page content
   When click on get start button
   Then ensure your on the second page
   When select one card and click on the continue button
   Then ensure your on the third page 
   When click on the continue button
   Then ensure your on the fourth page 
   When select the OHR card and click on the continue button
   Then ensure you are on the upload image page
   When upload an image from your local space
   And  click on the available button
   Then ensure you are on the contact info page
   When fill all the necessary information and click on the submit button
   Then Ensure you are on the result page with cards
   And verify the all cards buttons are enabled 