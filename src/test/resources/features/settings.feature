Feature: Settings Page functionality

  Scenario Outline: Delete the Project
    When Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And select the "<project>" and click connect button
    Then verify that the project is connected successfully
    When clicking on the Settings
    And click on the Delete button

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |
