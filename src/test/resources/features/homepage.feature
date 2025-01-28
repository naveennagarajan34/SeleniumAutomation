Feature: Home page links

  Scenario: Verify the redirection on clicking Learn more
    When Navigate to Scriptureforge
    Then Click on the Learn more button
    And verify that the user is redirected to learn more page