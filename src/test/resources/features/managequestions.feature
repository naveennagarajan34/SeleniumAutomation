Feature: Manage Questions page

  Scenario Outline: Add a question from manage questions page
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    Then click on the manage questions
    And click Add Questions button and enter the scripture reference and verify
    

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | S        | paratext | PDR     |
