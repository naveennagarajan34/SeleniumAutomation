Feature: Header section functionalities of Scriptureforge application

  Scenario Outline: SF Logo navigation
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the sf logo in the header

  Scenario Outline: Change the user name
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the profile icon in the header
    Then change the user name to "<newname>"
    And click on the profile icon in the header
    And verify that the user name is changed to "<newname>"

    Examples: 
      | newname |
      | Naveen   |
