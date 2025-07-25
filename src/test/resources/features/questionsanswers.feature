Feature: Questions and Answers page functionalities

  Scenario Outline: Add the chapter audio for the given book
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the questions and answers page
    Then select the given "<book>" and chapter in questions pane
    When click on the manage audio button
    Then upload the audio files for the "<book>"

    And verify that the audio files are uploaded
    Examples: 
      | project | book     |
      | PDR     | John 1:1 |

Scenario Outline: Delete the chapter audio for the given book
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the questions and answers page
    Then select the given "<book>" and chapter in questions pane
    When click on the manage audio button
    Then upload the audio files for the "<book>"
    And verify that the play icon appeared
    Then click on the manage audio button
    And click delete button on the audio and timing file
    Then click on the save button
    And verify that the play icon disappeared
    

    Examples: 
      | project | book     |
      | PDR     | John 1:1 |