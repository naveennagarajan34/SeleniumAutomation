Feature: Login functionality for Scriptureforge

  # Login functionality works
  Scenario Outline: User login with valid credentials
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"

    Examples: 
      | username                    | password    | loginvia |
      #| shanprabhu7@yahoo.com       | Test@123    | email    |
     #| naveennagarajan34@yahoo.com | Angrybird@1 | email    |
      | shanmuga.k@ecgroup-intl.com | S           | paratext |
