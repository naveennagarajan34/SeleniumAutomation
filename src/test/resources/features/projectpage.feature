Feature: Projects page functionalities

  #Scenario Outline: Connect to the given project
  #Given Navigate to Scriptureforge
  #When clicking on login button
  #Then login via "<loginvia>" with "<username>" and "<password>"
  #And select the "<project>" and click connect button
  #Then verify that the project is connected successfully
  #Examples:
  #| username                  | password | loginvia | project |
  #| naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |
  #
  #| shanprabhu7@yahoo.com       | Test@123    | email    ||
  #| naveennagarajan34@yahoo.com | Angrybird@1 | email    ||
  Scenario Outline: Connect to the given already connected project
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And click on the connected project "<project>"
    Then verify that the project is connected successfully

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |
