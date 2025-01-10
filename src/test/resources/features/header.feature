Feature: Header section functionalities of Scriptureforge application

  #Scenario Outline: SF Logo navigation
  #Given Launch browser
  #And Navigate to Scriptureforge
  #Then Login with paratext "<username>" and "<password>"
  #And click on the sf logo in the header
  #
  #Examples:
  #| username                  | password        |
  #| naveen.n@ecgroup |  |
  Scenario Outline: Change the user name
    Given Launch browser
    And Navigate to Scriptureforge
    Then login via "<loginvia>" with "<username>" and "<password>"
    And click on the profile icon in the header
    Then change the user name to "<newname>"
    And click on the sf logo in the header

    Examples: 
      | username                    | password    | loginvia | newname    |
      | shanprabhu7@yahoo.com       | Test@123    | email    | Prabhu     |
      | naveennagarajan34@yahoo.com | Angrybird@1 | email    | Tom Cruise |
      #| naveen.n@ecgroup            |             | paratext | Iron Man   |
