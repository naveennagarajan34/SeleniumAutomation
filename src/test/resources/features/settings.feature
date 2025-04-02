Feature: Settings Page functionalities

  Scenario Outline: Delete the Project
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And select the "<project>" and click connect button
    Then verify that the project is connected successfully
    When clicking on the Settings
    And click on the Delete button

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |

  Scenario Outline: Adding the source project
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When clicking on the Settings
    And click on the source project field
    Then select the "<source>" project from the list
    And verify that the source project is added

    Examples: 
      | username                  | password | loginvia | project | source |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     | EASY   |
