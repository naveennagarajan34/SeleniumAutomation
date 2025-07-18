Feature: Home page redirection links

  Scenario: Verify the redirection on clicking Footer links 
    Given Navigate to Scriptureforge
    Then Click on the Learn more button
    And verify that the user is redirected to learn more page
    Then Click on the Terms button
    And Verify that the user is redirected to the Terms page
    Then Click on the Privacy button
    And Verify that the user is redirected to the Privacy page
    Then Click on the Community Support button
    And Verify that the new tab opened for Community Support page