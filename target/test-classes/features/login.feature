Feature: Login functionality for Scriptureforge

  Scenario Outline: User login with valid credentials
    Given Launch browser
    And Navigate to Scriptureforge
    Then login via "<loginvia>" with "<username>" and "<password>"

    Examples: 
      | username                    | password    | loginvia |
      | shanprabhu7@yahoo.com       | Test@123    | email    |
      | naveennagarajan34@yahoo.com | Angrybird@1 | email    |
      | naveen.n@ecgroup            |             | paratext |
