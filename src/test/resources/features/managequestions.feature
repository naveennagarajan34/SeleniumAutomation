Feature: Manage Questions page

  Scenario Outline: Add a question from manage questions page
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    Then click on the manage questions
    And click Add Questions button and enter the scripture reference and verify

    Examples: 
      | project |
      | PDR     |
