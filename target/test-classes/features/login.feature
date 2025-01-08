Feature: Login functionality for Scriptureforge

  Scenario Outline: Test user login with Mail id and password
    Given Launch Chrome browser
    And Navigate to Scriptureforge
    When valid "<username>" and "<password>" is entered

    Examples: 
      | username              | password |
      | shanprabhu7@yahoo.com | Test@123 |

  #Scenario Outline: Test user login with Paratext
    #Given Launch Chrome browser
    #And Navigate to Scriptureforge
    #Then Login with paratext "<username>" and "<password>"
#
    #Examples: 
      #| username                  | password        |
      #| naveen.n@ecgroup-intl.com | Angrybird@12345 |
