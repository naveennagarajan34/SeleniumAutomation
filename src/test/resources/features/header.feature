Feature: Header section functionalies of Scriptureforge application

  Scenario Outline: SF Logo navigation
    Given Launch Chrome browser
    And Navigate to Scriptureforge
    Then Login with paratext "<username>" and "<password>"
    And click on the sf logo in the header

    Examples: 
      | username                  | password        |
      | naveen.n@ecgroup-intl.com | Angrybird@12345 |